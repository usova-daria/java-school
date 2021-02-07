package com.javaschool.domainlogic.user.registration.exception;

public class UserRegistrationException extends RuntimeException {

    public UserRegistrationException() {
        super("An error occurred during user registration");
    }

    public UserRegistrationException(String message) {
        super(message);
    }

    public UserRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
