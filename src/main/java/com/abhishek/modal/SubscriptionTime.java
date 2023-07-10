package com.abhishek.modal;

import java.math.BigDecimal;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionTime {
    private final BigDecimal amount;
    private final Integer time;

    public SubscriptionTime(BigDecimal amount, Integer time) {
        this.amount = amount;
        this.time = time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getTime() {
        return time;
    }
}
