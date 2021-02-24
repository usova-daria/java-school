package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class ShippingMethodMappingException extends RuntimeException {

    /**
     * Instantiates a new Shipping method mapping exception.
     */
    public ShippingMethodMappingException() {
    }

    /**
     * Instantiates a new Shipping method mapping exception.
     *
     * @param message the message
     */
    public ShippingMethodMappingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Shipping method mapping exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ShippingMethodMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
