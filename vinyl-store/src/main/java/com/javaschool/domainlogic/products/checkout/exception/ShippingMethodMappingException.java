package com.javaschool.domainlogic.products.checkout.exception;

public class ShippingMethodMappingException extends RuntimeException {

    public ShippingMethodMappingException() {
    }

    public ShippingMethodMappingException(String message) {
        super(message);
    }

    public ShippingMethodMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
