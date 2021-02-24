package com.javaschool.domainlogic.user.profile.exception.edit;

/**
 * @author Daria Usova
 */
public class GetUserInfoException extends RuntimeException {

    /**
     * Instantiates a new get user info exception.
     */
    public GetUserInfoException() {
    }

    /**
     * Instantiates a new get user info exception.
     *
     * @param message the message
     */
    public GetUserInfoException(String message) {
        super(message);
    }

    /**
     * Instantiates a new get user info exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GetUserInfoException(String message, Throwable cause) {
        super(message, cause);
    }

}
