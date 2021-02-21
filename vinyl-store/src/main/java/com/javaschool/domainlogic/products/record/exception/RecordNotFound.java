package com.javaschool.domainlogic.products.record.exception;

public class RecordNotFound extends RuntimeException {

    public RecordNotFound() {
    }

    public RecordNotFound(String message) {
        super(message);
    }

    public RecordNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
