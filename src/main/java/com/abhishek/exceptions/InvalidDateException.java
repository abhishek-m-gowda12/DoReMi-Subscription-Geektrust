package com.abhishek.exceptions;

/**
 * @author abhishek-m-gowda12
 */
public class InvalidDateException extends RuntimeException {
    private ErrorCodes errorCode;

    public InvalidDateException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
