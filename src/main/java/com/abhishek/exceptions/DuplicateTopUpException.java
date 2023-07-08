package com.abhishek.exceptions;

/**
 * @author abhishek-m-gowda12
 */
public class DuplicateTopUpException extends RuntimeException {
    private ErrorCodes errorCode;

    public DuplicateTopUpException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
