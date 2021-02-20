package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.PaymentDetailsRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.order.PaymentDetails;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class PaymentDetailsRepositoryImpl extends AbstractRepositoryImpl<PaymentDetails, Long>
                                   implements PaymentDetailsRepository {

    public PaymentDetailsRepositoryImpl() {
        super(PaymentDetails.class);
    }

    @Override
    public double getTotalAmountAfter(LocalDate date) {
        return entityManager.createNamedQuery("PaymentDetails.findTotalAmountByPaymentDateAfter", Double.class)
                .setParameter("date", date)
                .getSingleResult();
    }

    @Override
    public double getTotalAmountBetween(LocalDate from, LocalDate to) {
        return entityManager.createNamedQuery("PaymentDetails.findTotalAmountByPaymentDateBetween", Double.class)
                .setParameter("fromDate", from)
                .setParameter("toDate", to)
                .getSingleResult();
    }

    @Override
    public LocalDate getMinPaymentDate() {
        return entityManager.createNamedQuery("PaymentDetails.findMinPaymentDate", LocalDate.class)
                .getSingleResult();
    }

}
