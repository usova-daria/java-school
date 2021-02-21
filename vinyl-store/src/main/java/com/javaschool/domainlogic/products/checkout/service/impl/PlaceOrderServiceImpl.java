package com.javaschool.domainlogic.products.checkout.service.impl;

import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.service.api.UpdateCartService;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.exception.NotEnoughUnitsInStoreException;
import com.javaschool.domainlogic.products.checkout.exception.OrderNotPlacedException;
import com.javaschool.domainlogic.products.checkout.service.api.PaymentService;
import com.javaschool.domainlogic.products.checkout.service.api.PlaceOrderService;
import com.javaschool.domainlogic.products.checkout.service.api.SaveOrderService;
import com.javaschool.domainlogic.salesdisplay.jms.MessageSender;
import com.javaschool.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.jms.UncategorizedJmsException;
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
        sendMessageToQueue();
    }

    @Transactional
    public void saveOrderAndPay(CheckoutFormDto checkoutFormDto, Cart cart) {
        Order order = saveOrderService.saveOrder(checkoutFormDto, cart);
        paymentService.payForTheOrder(order);
    }

    private void sendMessageToQueue() {
        try {
            messageSender.sendMessage();
        } catch (UncategorizedJmsException e) {
            log.error("An error occurred while sending a message to the queue", e);
        }
    }

}
