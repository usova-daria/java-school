package com.javaschool.domainlogic.user.profile.exception.edit;

/**
 * @author Daria Usova
 */
public class UserInfoNotUpdatedException extends RuntimeException {

    /**
     * Instantiates a new user info not updated exception.
     */
    public UserInfoNotUpdatedException() {
    }

    /**
     * Instantiates a new user info not updated exception.
     *
     * @param message the message
     */
    public UserInfoNotUpdatedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new user info not updated exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserInfoNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

}
