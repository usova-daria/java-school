package com.javaschool.domainlogic.products.cart.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CartExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AddItemToCartException.class)
    public ResponseEntity<Object> handleAddItemToCartException(RuntimeException e, WebRequest webRequest) {
        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, webRequest);
    }

}
