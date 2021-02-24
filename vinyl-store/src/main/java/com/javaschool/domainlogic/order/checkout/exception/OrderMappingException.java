package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class OrderMappingException extends RuntimeException {

    /**
     * Instantiates a new Order mapping exception.
     */
    public OrderMappingException() {
    }

    /**
     * Instantiates a new Order mapping exception.
     *
     * @param message the message
     */
    public OrderMappingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Order mapping exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public OrderMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
