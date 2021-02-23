package com.javaschool.domainlogic.admin.productmanagement.exception;

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
public class AdminProductManagementExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle genre not found exception.
     *
     * @param e          the e
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler(value = GenreNotFound.class)
    public ResponseEntity<Object> handleGenreNotFound(RuntimeException e, WebRequest webRequest) {
        String bodyOfResponse = "Genre not found";
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(),
                HttpStatus.NOT_FOUND, webRequest);
    }


}
