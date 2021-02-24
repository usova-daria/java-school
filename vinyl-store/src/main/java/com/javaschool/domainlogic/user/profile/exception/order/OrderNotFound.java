package com.javaschool.domainlogic.user.profile.exception.order;

public class OrderNotFound extends RuntimeException {

    public OrderNotFound() {
    }

    public OrderNotFound(Long id) {
        super("Order with id = " + id + " not found");
    }

    public OrderNotFound(String message) {
        super(message);
    }

    public OrderNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
