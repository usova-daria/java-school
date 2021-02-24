package com.javaschool.domainlogic.user.profile.exception.password;

/**
 * @author Daria Usova
 */
public class ChangePasswordException extends RuntimeException {

    /**
     * Instantiates a new Change password exception.
     */
    public ChangePasswordException() {
    }

    /**
     * Instantiates a new Change password exception.
     *
     * @param message the message
     */
    public ChangePasswordException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Change password exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ChangePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

}
