package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.PaymentDetailsRepository;
import com.javaschool.dao.impl.AbstractRepositoryImpl;
import com.javaschool.entity.order.PaymentDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Repository
public class PaymentDetailsRepositoryImpl extends AbstractRepositoryImpl<PaymentDetails, Long>
                                   implements PaymentDetailsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PaymentDetailsRepositoryImpl() {
        super(PaymentDetails.class);
    }

    @Override
    public double getTotalAmountAfter(LocalDate date) {
        return (double) entityManager.createNamedQuery("PaymentDetails.findTotalAmountByPaymentDateAfter")
                .setParameter("date", date)
                .getSingleResult();
    }

    @Override
    public double getTotalAmountBetween(LocalDate from, LocalDate to) {
        return (double) entityManager.createNamedQuery("PaymentDetails.findTotalAmountByPaymentDateBetween")
                .setParameter("fromDate", from)
                .setParameter("toDate", to)
                .getSingleResult();
    }

}
