package com.javaschool.domainlogic.admin.productmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFound extends RuntimeException {

    public GenreNotFound() {
    }

    public GenreNotFound(String message) {
        super(message);
    }

    public GenreNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
