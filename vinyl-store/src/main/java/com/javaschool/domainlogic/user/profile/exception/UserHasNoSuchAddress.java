package com.javaschool.domainlogic.user.profile.exception;

public class UserHasNoSuchAddress extends RuntimeException {

    public UserHasNoSuchAddress() {
    }

    public UserHasNoSuchAddress(String message) {
        super(message);
    }

    public UserHasNoSuchAddress(String message, Throwable cause) {
        super(message, cause);
    }

}
