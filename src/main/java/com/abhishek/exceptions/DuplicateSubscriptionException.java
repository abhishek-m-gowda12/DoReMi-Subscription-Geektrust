package com.abhishek.exceptions;

/**
 * @author abhishek-m-gowda12
 */
public class DuplicateSubscriptionException extends RuntimeException {
    private ErrorCodes errorCode;

    public DuplicateSubscriptionException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
