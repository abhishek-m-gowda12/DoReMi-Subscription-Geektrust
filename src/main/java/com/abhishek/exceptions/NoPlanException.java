package com.abhishek.exceptions;

/**
 * @author abhishek-m-gowda12
 */
public class NoPlanException extends RuntimeException {
    private final ErrorCodes errorCode;

    public NoPlanException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
