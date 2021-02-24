package com.javaschool.domainlogic.order.checkout.exception;

/**
 * @author Daria Usova
 */
public class NotEnoughUnitsInStoreException extends RuntimeException {

    /**
     * Instantiates a new Not enough units in store exception.
     */
    public NotEnoughUnitsInStoreException() {
    }

    /**
     * Instantiates a new Not enough units in store exception.
     *
     * @param message the message
     */
    public NotEnoughUnitsInStoreException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Not enough units in store exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NotEnoughUnitsInStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
