package com.javaschool.domainlogic.products.checkout.mapper.impl;

import com.javaschool.dao.api.order.ShippingMethodRepository;
import com.javaschool.domainlogic.products.cart.dto.Cart;
import com.javaschool.domainlogic.products.cart.dto.CartItem;
import com.javaschool.domainlogic.products.checkout.dto.CheckoutFormDto;
import com.javaschool.domainlogic.products.checkout.exception.*;
import com.javaschool.domainlogic.products.checkout.mapper.api.AddressMapper;
import com.javaschool.domainlogic.products.checkout.mapper.api.CheckoutFormToOrderMapper;
import com.javaschool.domainlogic.products.checkout.mapper.api.OrderItemMapper;
import com.javaschool.entity.address.Address;
import com.javaschool.entity.order.*;
import com.javaschool.entity.order.enumeration.OrderStatus;
import com.javaschool.entity.order.enumeration.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j
@Component
@AllArgsConstructor
public class CheckoutFormToOrderMapperImpl implements CheckoutFormToOrderMapper {

    private final AddressMapper addressMapper;
    private final ShippingMethodRepository shippingMethodRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public Order toEntity(CheckoutFormDto checkoutFormDto, Cart cart) {
        if (checkoutFormDto == null) return null;

        Order order = new Order();

        try {
            order.setAddress(mapAddress(checkoutFormDto));
            order.setRecipient(mapRecipient(checkoutFormDto));
            order.setPaymentDetails(mapPaymentDetails(checkoutFormDto, cart));
            order.setStatus(OrderStatus.AWAITING_SHIPMENT);
            order.setShippingMethod(mapShippingMethod(checkoutFormDto));

            mapOrderItems(order, cart.getItems());

        } catch (AddressMappingException | ShippingMethodMappingException | OrderItemMappingException e) {
            throw new OrderMappingException(e.getMessage(), e);
        }

        return order;
    }

    private Address mapAddress(CheckoutFormDto checkoutFormDto) {
        return addressMapper.toEntity(checkoutFormDto.getAddress());
    }

    private Recipient mapRecipient(CheckoutFormDto checkoutFormDto) {
        Recipient recipient = new Recipient();
        recipient.setName(checkoutFormDto.getFirstName() + " " + checkoutFormDto.getLastName());
        recipient.setPhoneNumber(checkoutFormDto.getPhoneNumber().replaceAll("-", ""));

        return recipient;
    }

    private PaymentDetails mapPaymentDetails(CheckoutFormDto checkoutFormDto, Cart cart) {
        PaymentDetails paymentDetails = new PaymentDetails();

        paymentDetails.setAmount(cart.getTotal());
        paymentDetails.setMethod(checkoutFormDto.getPaymentMethod());
        paymentDetails.setStatus(PaymentStatus.AWAITING);

        return paymentDetails;
    }

    private ShippingMethod mapShippingMethod(CheckoutFormDto checkoutFormDto) {
        Integer shippingMethodId = checkoutFormDto.getDeliveryMethodId();

        return shippingMethodRepository.findById(shippingMethodId)
                .orElseThrow(() -> new ShippingMethodMappingException("There is no shipping method with id="
                                                                         + shippingMethodId));
    }

    private void mapOrderItems(Order order, List<CartItem> items) {
        List<OrderItem> orderItems = orderItemMapper.toEntityList(items);
        order.setItems(orderItems);
    }
}
