package com.javaschool.dao.impl.order;

import com.javaschool.dao.api.order.PaymentDetailsDao;
import com.javaschool.dao.impl.AbstractDaoImpl;
import com.javaschool.entity.order.PaymentDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Repository
public class PaymentDetailsDaoImpl extends AbstractDaoImpl<PaymentDetails, Long>
                                   implements PaymentDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PaymentDetailsDaoImpl() {
        super(PaymentDetails.class);
    }

    @Override
    public double getTotalAmountSince(LocalDate date) {
        return (double) entityManager.createNamedQuery("PaymentDetails.findTotalAmountByPaymentDateAfter")
                .setParameter("date", date)
                .getSingleResult();
    }

}
