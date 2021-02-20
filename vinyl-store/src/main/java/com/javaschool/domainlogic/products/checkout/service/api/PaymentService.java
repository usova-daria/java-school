package com.javaschool.domainlogic.products.checkout.service.api;

import com.javaschool.entity.order.Order;

public interface PaymentService {

    void payForTheOrder(Order order);

}
