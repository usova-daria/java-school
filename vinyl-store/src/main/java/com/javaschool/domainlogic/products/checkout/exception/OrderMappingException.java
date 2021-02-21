package com.javaschool.domainlogic.products.checkout.exception;

public class OrderMappingException extends RuntimeException {

    public OrderMappingException() {
    }

    public OrderMappingException(String message) {
        super(message);
    }

    public OrderMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
