package com.abhishek.exceptions;

public enum ErrorCodes {
    DUPLICATE_SUBSCRIPTION_EXCEPTION(1000),
    DUPLICATE_TOP_UP_EXCEPTION(1001),
    INVALID_DATE_EXCEPTION(1002),
    SUBSCRIPTION_NOT_FOUND_EXCEPTION(1003),
    NO_PLAN_EXCEPTION(1004);

    private final int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}