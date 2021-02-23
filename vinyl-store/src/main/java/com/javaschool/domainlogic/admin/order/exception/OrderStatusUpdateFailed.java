package com.javaschool.domainlogic.admin.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Daria Usova
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderStatusUpdateFailed extends RuntimeException {

    /**
     * Instantiates a new Order status update failed.
     *
     * @param message the message
     */
    public OrderStatusUpdateFailed(String message) {
        super(message);
    }

}
