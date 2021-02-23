package com.javaschool.domainlogic.admin.order.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Daria Usova
 */
@ControllerAdvice
public class AdminOrderExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle order status update failed.
     *
     * @param ex         the exception
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler(value = OrderStatusUpdateFailed.class)
    public ResponseEntity<Object> handleOrderStatusUpdateFailed(OrderStatusUpdateFailed ex, WebRequest webRequest) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, webRequest);
    }

}
