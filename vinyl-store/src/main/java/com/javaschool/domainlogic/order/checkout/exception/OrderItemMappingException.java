package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class OrderItemMappingException extends RuntimeException {

    /**
     * Instantiates a new Order item mapping exception.
     */
    public OrderItemMappingException() {
    }

    /**
     * Instantiates a new Order item mapping exception.
     *
     * @param message the message
     */
    public OrderItemMappingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Order item mapping exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public OrderItemMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
