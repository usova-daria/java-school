package com.javaschool.exception;

public class TownNotFoundException extends RuntimeException {

    public TownNotFoundException() {
    }

    public TownNotFoundException(Integer id) {
        super("Town with id=" + id + " not found");
    }

    public TownNotFoundException(String message) {
        super(message);
    }

    public TownNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
