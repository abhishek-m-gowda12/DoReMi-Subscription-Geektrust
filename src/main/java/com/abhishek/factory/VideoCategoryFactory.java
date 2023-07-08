package com.abhishek.factory;

import com.abhishek.domain.SubscriptionTime;
import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.NoPlanException;

import java.math.BigDecimal;

/**
 * @author abhishek-m-gowda12
 */
public class VideoCategoryFactory extends SubscriptionAmountFactory {
    private final SubscriptionCategory subscriptionCategory;

    public VideoCategoryFactory(SubscriptionCategory subscriptionCategory) {
        this.subscriptionCategory = subscriptionCategory;
    }

    @Override
    public SubscriptionTime getSubscriptionTime() {
        switch (subscriptionCategory) {
            case FREE:
                return new SubscriptionTime(BigDecimal.ZERO, 1);
            case PERSONAL:
                return new SubscriptionTime(BigDecimal.valueOf(200), 0);
            case PREMIUM:
                return new SubscriptionTime(BigDecimal.valueOf(500), 3);
            default:
                throw new NoPlanException("no info for subscriptionPlan and subscriptionCategory", ErrorCodes.NO_PLAN_EXCEPTION);
        }
    }
}
