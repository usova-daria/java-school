package com.javaschool.domainlogic.user.registration.exception;

/**
 * @author Daria Usova
 */
public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException() {
    }

    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
