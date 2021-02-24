package com.javaschool.domainlogic.user.registration.exception;

/**
 * @author Daria Usova
 */
public class RoleNotFoundException extends RuntimeException {

    /**
     * Instantiates a new role not found exception.
     */
    public RoleNotFoundException() {
    }

    /**
     * Instantiates a new role not found exception.
     *
     * @param message the message
     */
    public RoleNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new role not found exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
