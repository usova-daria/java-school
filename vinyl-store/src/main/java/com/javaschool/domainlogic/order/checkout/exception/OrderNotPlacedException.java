package com.javaschool.domainlogic.order.checkout.exception;

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
