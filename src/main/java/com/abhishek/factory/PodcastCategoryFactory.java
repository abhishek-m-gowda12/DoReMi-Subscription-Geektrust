package com.abhishek.factory;

import com.abhishek.domain.SubscriptionTime;
import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.NoPlanException;

import java.math.BigDecimal;

/**
 * @author abhishek-m-gowda12
 */
public class PodcastCategoryFactory extends SubscriptionAmountFactory {
    private final SubscriptionCategory subscriptionCategory;

    public PodcastCategoryFactory(SubscriptionCategory subscriptionCategory) {
        this.subscriptionCategory = subscriptionCategory;
    }

    @Override
    public SubscriptionTime getSubscriptionTime() {
        switch (subscriptionCategory) {
            case FREE:
                return new SubscriptionTime(BigDecimal.ZERO, 1);
            case PERSONAL:
                return new SubscriptionTime(BigDecimal.valueOf(100), 1);
            case PREMIUM:
                return new SubscriptionTime(BigDecimal.valueOf(300), 2);
            default:
                throw new NoPlanException("no info for subscriptionPlan and subscriptionCategory", ErrorCodes.NO_PLAN_EXCEPTION);
        }
    }
}
