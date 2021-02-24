package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class OrderNotPlacedException extends RuntimeException {

    /**
     * Instantiates a new Order not placed exception.
     */
    public OrderNotPlacedException() {
    }

    /**
     * Instantiates a new Order not placed exception.
     *
     * @param message the message
     */
    public OrderNotPlacedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Order not placed exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public OrderNotPlacedException(String message, Throwable cause) {
        super(message, cause);
    }

}
