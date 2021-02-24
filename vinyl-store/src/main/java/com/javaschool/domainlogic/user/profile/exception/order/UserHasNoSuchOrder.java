package com.javaschool.domainlogic.user.profile.exception.order;

public class UserHasNoSuchOrder extends RuntimeException {

    public UserHasNoSuchOrder() {
    }

    public UserHasNoSuchOrder(String message) {
        super(message);
    }

    public UserHasNoSuchOrder(String message, Throwable cause) {
        super(message, cause);
    }

}
