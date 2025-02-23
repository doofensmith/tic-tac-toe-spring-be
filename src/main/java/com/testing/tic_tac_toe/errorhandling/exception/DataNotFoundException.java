package com.testing.tic_tac_toe.errorhandling.exception;

import java.io.Serial;

public class DataNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -972057058348049809L;

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }

    public DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
