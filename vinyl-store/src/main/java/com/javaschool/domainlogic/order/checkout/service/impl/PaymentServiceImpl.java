package com.javaschool.domainlogic.order.checkout.service.impl;

import com.javaschool.domainlogic.order.checkout.service.api.PaymentService;
import com.javaschool.entity.order.Order;
import com.javaschool.entity.order.PaymentDetails;
import com.javaschool.entity.order.enumeration.PaymentStatus;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Log4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void payForTheOrder(Order order) {
        PaymentDetails paymentDetails = order.getPaymentDetails();

        log.info("Order with id=" + order.getId() + " has been paid. Total: " + paymentDetails.getAmount());
        paymentDetails.setStatus(PaymentStatus.PAID);
        paymentDetails.setPaymentDate(LocalDate.now());
    }

}
