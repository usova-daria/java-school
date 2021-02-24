package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class AddressMappingException extends RuntimeException {

    /**
     * Instantiates a new Address mapping exception.
     */
    public AddressMappingException() {
    }

    /**
     * Instantiates a new Address mapping exception.
     *
     * @param message the message
     */
    public AddressMappingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Address mapping exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AddressMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
