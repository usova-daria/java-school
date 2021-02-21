package com.javaschool.domainlogic.order.checkout.exception;

public class AddressMappingException extends RuntimeException {

    public AddressMappingException() {
    }

    public AddressMappingException(String message) {
        super(message);
    }

    public AddressMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
