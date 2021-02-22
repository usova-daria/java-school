package com.javaschool.domainlogic.products.record.exception;

public class GetRecordFailed extends RuntimeException {

    public GetRecordFailed() {
    }

    public GetRecordFailed(String message) {
        super(message);
    }

    public GetRecordFailed(String message, Throwable cause) {
        super(message, cause);
    }

}
