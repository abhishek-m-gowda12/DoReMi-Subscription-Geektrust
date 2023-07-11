package com.abhishek.enums;

public enum CommandOperator {
    START_SUBSCRIPTION(1),
    ADD_SUBSCRIPTION(2),
    ADD_TOPUP(2),
    PRINT_RENEWAL_DETAILS(0);

    CommandOperator(Integer numArgs) {
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}

