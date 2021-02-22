package com.javaschool.domainlogic.user.profile.exception;

public class AddressNotSavedException extends RuntimeException {

    public AddressNotSavedException() {
    }

    public AddressNotSavedException(String message) {
        super(message);
    }

    public AddressNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }
}
