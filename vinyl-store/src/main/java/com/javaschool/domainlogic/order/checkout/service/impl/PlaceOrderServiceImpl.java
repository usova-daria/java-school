package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.domainlogic.order.cart.dto.Cart;
import com.javaschool.domainlogic.order.cart.service.api.UpdateCartService;
import com.javaschool.domainlogic.order.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.order.checkout.exception.NotEnoughUnitsInStoreException;
import com.javaschool.domainlogic.order.checkout.exception.OrderNotPlacedException;
import com.javaschool.domainlogic.order.checkout.service.api.PaymentService;
import com.javaschool.domainlogic.order.checkout.service.api.PlaceOrderService;
import com.javaschool.domainlogic.order.checkout.service.api.SaveOrderService;
import com.javaschool.domainlogic.salesdisplay.jms.MessageSender;
import com.javaschool.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.jms.JmsException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j
@Service
@AllArgsConstructor
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private final PaymentService paymentService;
    private final SaveOrderService saveOrderService;
    private final UpdateCartService updateCartService;
    private final MessageSender messageSender;

    @Override
    @Transactional
    public void placeOrder(CheckoutFormDto checkoutFormDto, Cart cart) {
        try {
            saveOrderAndPay(checkoutFormDto, cart);
        } catch (ObjectOptimisticLockingFailureException e) {
            if (updateCartService.itemsAreAvailable(cart)) {
                saveOrderAndPay(checkoutFormDto, cart);
            } else {
                throw new OrderNotPlacedException("Not enough units in store",
                        new NotEnoughUnitsInStoreException());
            }
        }

        updateCartService.emptyCart(cart);
    }

    @Transactional
    public void saveOrderAndPay(CheckoutFormDto checkoutFormDto, Cart cart) {
        Order order = saveOrderService.saveOrder(checkoutFormDto, cart);
        paymentService.payForTheOrder(order);
    }

    @Override
    public void sendMessageToQueue() {
        try {
            messageSender.sendMessage();
        } catch (JmsException e) {
            log.error("An error occurred while sending a message to the queue", e);
        }
    }

}
