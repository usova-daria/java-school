package com.javaschool.domainlogic.admin.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
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
