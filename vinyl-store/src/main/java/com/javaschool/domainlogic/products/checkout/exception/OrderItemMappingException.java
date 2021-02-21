package com.javaschool.domainlogic.products.checkout.exception;

public class OrderItemMappingException extends RuntimeException {

    public OrderItemMappingException() {
    }

    public OrderItemMappingException(String message) {
        super(message);
    }

    public OrderItemMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
