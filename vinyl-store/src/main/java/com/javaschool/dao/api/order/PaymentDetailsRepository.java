package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.order.PaymentDetails;

import java.time.LocalDate;

public interface PaymentDetailsRepository extends AbstractRepository<PaymentDetails, Long> {

    double getTotalAmountAfter(LocalDate date);

    double getTotalAmountBetween(LocalDate from, LocalDate to);

    LocalDate getMinPaymentDate();

}
