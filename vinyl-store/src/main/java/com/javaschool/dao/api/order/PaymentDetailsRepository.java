package com.javaschool.dao.api.order;

import com.javaschool.dao.api.AbstractRepository;
import com.javaschool.entity.order.PaymentDetails;

import java.time.LocalDate;

/**
 * @author Daria Usova
 */
public interface PaymentDetailsRepository extends AbstractRepository<PaymentDetails, Long> {

    /**
     * Gets total amount after.
     *
     * @param date the date
     * @return the total amount after
     */
    double getTotalAmountAfter(LocalDate date);

    /**
     * Gets total amount between.
     *
     * @param from the from
     * @param to   the to
     * @return the total amount between
     */
    double getTotalAmountBetween(LocalDate from, LocalDate to);

    /**
     * Gets min payment date.
     *
     * @return the min payment date
     */
    LocalDate getMinPaymentDate();

}
