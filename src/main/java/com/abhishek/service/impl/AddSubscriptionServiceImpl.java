package com.abhishek.service.impl;

import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.exceptions.DuplicateSubscriptionException;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.InvalidDateException;
import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.service.CommandExecutor;

import java.util.List;

/**
 * @author abhishek-m-gowda12
 */
public class AddSubscriptionServiceImpl implements CommandExecutor {
    @Override
    public void fulfillCommand(SubscriptionDetail subscriptionDetail, Command command) {
        List<String> params = command.getCommandParams();
        if (subscriptionDetail.getSubscriptionDetails().containsKey(SubscriptionPlan.valueOf(params.get(0)))) {
            throw new DuplicateSubscriptionException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY", ErrorCodes.DUPLICATE_SUBSCRIPTION_EXCEPTION);
        } else if (subscriptionDetail.getSubscriptionStartDate() == null) {
            throw new InvalidDateException("ADD_SUBSCRIPTION_FAILED INVALID_DATE", ErrorCodes.INVALID_DATE_EXCEPTION);
        } else {
            subscriptionDetail.getSubscriptionDetails().put(SubscriptionPlan.valueOf(params.get(0)), SubscriptionCategory.valueOf(params.get(1)));
        }
    }
}
