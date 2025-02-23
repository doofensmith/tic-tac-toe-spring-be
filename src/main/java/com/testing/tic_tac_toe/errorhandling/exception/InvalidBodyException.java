package com.testing.tic_tac_toe.errorhandling.exception;

import java.io.Serial;

public class InvalidBodyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7285121092650384704L;

    public InvalidBodyException() {
    }

    public InvalidBodyException(String message) {
        super(message);
    }

    public InvalidBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBodyException(Throwable cause) {
        super(cause);
    }

    public InvalidBodyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
