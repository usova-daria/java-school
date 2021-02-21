package com.javaschool.domainlogic.products.checkout.exception;

public class OrderNotPlacedException extends RuntimeException {

    public OrderNotPlacedException() {
    }

    public OrderNotPlacedException(String message) {
        super(message);
    }

    public OrderNotPlacedException(String message, Throwable cause) {
        super(message, cause);
    }

}
