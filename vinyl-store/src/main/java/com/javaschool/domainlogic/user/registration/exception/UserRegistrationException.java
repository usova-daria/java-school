package com.javaschool.domainlogic.user.registration.exception;

/**
 * @author Daria Usova
 */
public class UserRegistrationException extends RuntimeException {

    /**
     * Instantiates a new user registration exception.
     */
    public UserRegistrationException() {
        super("An error occurred during user registration");
    }

    /**
     * Instantiates a new user registration exception.
     *
     * @param message the message
     */
    public UserRegistrationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new user registration exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
