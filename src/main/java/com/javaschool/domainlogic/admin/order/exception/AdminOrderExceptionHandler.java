package com.javaschool.domainlogic.admin.order.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdminOrderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = OrderStatusUpdateFailed.class)
    public ResponseEntity<Object> handleOrderStatusUpdateFailed(RuntimeException e, WebRequest webRequest) {
        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

}
