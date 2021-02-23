package com.javaschool.domainlogic.admin.productmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Daria Usova
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFound extends RuntimeException {

    /**
     * Instantiates a new Genre not found.
     */
    public GenreNotFound() {
    }

    /**
     * Instantiates a new Genre not found.
     *
     * @param message the message
     */
    public GenreNotFound(String message) {
        super(message);
    }

    /**
     * Instantiates a new Genre not found.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GenreNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
