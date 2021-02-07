package com.javaschool.domainlogic.admin.productmanagement.exception;

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
