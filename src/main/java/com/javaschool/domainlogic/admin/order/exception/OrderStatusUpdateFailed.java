package com.javaschool.domainlogic.admin.order.exception;

public class OrderStatusUpdateFailed extends RuntimeException {

    public OrderStatusUpdateFailed() {
    }

    public OrderStatusUpdateFailed(String message) {
        super(message);
    }

    public OrderStatusUpdateFailed(String message, Throwable cause) {
        super(message, cause);
    }

}
