package com.javaschool.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(Long id) {
        super("Address with id=" + id + " not found");
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
