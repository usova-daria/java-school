package com.javaschool.domainlogic.admin.productmanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdminProductManagementExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = GenreNotFound.class)
    public ResponseEntity<Object> handleGenreNotFound(RuntimeException e, WebRequest webRequest) {
        String bodyOfResponse = "Genre not found";
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(),
                HttpStatus.NOT_FOUND, webRequest);
    }


}
