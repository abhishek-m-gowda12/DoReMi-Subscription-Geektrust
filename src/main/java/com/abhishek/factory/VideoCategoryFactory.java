package com.abhishek.factory;

import com.abhishek.constants.Constants;
import com.abhishek.modal.SubscriptionTime;
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
                return new SubscriptionTime(BigDecimal.ZERO, Constants.ONE);
            case PERSONAL:
                return new SubscriptionTime(BigDecimal.valueOf(Constants.TWO_HUNDRED), Constants.ZERO);
            case PREMIUM:
                return new SubscriptionTime(BigDecimal.valueOf(Constants.FIVE_HUNDRED), Constants.THREE);
            default:
                throw new NoPlanException("no info for subscriptionPlan and subscriptionCategory", ErrorCodes.NO_PLAN_EXCEPTION);
        }
    }
}
