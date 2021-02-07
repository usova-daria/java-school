package com.javaschool.domainlogic.admin.order.dto;

import com.javaschool.entity.order.enumeration.OrderStatus;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import com.javaschool.entity.order.enumeration.PaymentStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminOrderInfo {
    /**
     * Order id
     */
    private Long id;

    /**
     * Order creation date
     */
    private LocalDate created;

    /**
     * String representation of {@link com.javaschool.entity.address.Address} object
     */
    private String address;

    /**
     * Order status
     */
    private OrderStatus orderStatus;

    /**
     * Payment method
     */
    private PaymentMethod paymentMethod;

    /**
     * Payment status
     */
    private PaymentStatus paymentStatus;

    /**
     * Shipping company name
     */
    private String shippingCompany;

    /**
     * String representation of {@link com.javaschool.entity.order.Recipient} object
     */
    private String recipientContacts;

}
