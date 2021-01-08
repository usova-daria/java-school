package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractDao;
import com.javaschool.entity.order.PaymentDetails;

import java.time.LocalDate;

public interface PaymentDetailsDao extends AbstractDao<PaymentDetails, Long> {

    double getTotalAmountSince(LocalDate date);

}
