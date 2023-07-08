package com.abhishek.exceptions;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionNotFoundException extends RuntimeException {
    private ErrorCodes errorCode;

    public SubscriptionNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
