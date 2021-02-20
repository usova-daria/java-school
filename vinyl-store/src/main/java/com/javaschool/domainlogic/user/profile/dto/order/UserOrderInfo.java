package com.javaschool.domainlogic.user.profile.dto.order;

import com.javaschool.entity.order.enumeration.OrderStatus;
import com.javaschool.entity.order.enumeration.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOrderInfo {

    private Long id;
    private String address;
    private String contacts;
    private String deliveryMethod;
    private PaymentMethod paymentMethod;
    private String createdDate;
    private OrderStatus status;
    private double total;

}
