package com.javaschool.domainlogic.order.checkout.service.api;

import com.javaschool.entity.order.Order;

/**
 * @author Daria Usova
 */
public interface PaymentService {

    /**
     * Pays for the order.
     *
     * @param order the order
     */
    void payForTheOrder(Order order);

}
