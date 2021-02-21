package com.javaschool.domainlogic.products.checkout.exception;

public class NotEnoughUnitsInStoreException extends RuntimeException {

    public NotEnoughUnitsInStoreException() {
    }

    public NotEnoughUnitsInStoreException(String message) {
        super(message);
    }

    public NotEnoughUnitsInStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
