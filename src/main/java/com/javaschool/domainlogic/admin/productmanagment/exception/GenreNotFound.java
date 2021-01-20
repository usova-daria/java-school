package com.javaschool.domainlogic.admin.productmanagment.exception;

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
