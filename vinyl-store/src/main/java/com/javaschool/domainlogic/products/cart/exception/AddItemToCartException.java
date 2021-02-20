package com.javaschool.domainlogic.products.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddItemToCartException extends RuntimeException {

    public AddItemToCartException() {
    }

    public AddItemToCartException(String message) {
        super(message);
    }

    public AddItemToCartException(String message, Throwable cause) {
        super(message, cause);
    }

}
