package com.abhishek.factory;

import com.abhishek.modal.SubscriptionTime;
import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.NoPlanException;

/**
 * @author abhishek-m-gowda12
 */
public abstract class SubscriptionAmountFactory {

    public abstract SubscriptionTime getSubscriptionTime();

    public static SubscriptionAmountFactory getSubscriptionAmountFactoryInstance(SubscriptionPlan subscriptionPlan, SubscriptionCategory subscriptionCategory) {
        switch (subscriptionPlan) {
            case MUSIC:
                return new MusicCategoryFactory(subscriptionCategory);
            case PODCAST:
                return new PodcastCategoryFactory(subscriptionCategory);
            case VIDEO:
                return new VideoCategoryFactory(subscriptionCategory);
            default:
                throw new NoPlanException("no info for subscriptionPlan and subscriptionCategory", ErrorCodes.NO_PLAN_EXCEPTION);
        }
    }
}
