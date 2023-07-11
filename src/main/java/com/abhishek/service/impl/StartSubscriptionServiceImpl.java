package com.abhishek.service.impl;

import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.InvalidDateException;
import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.service.CommandExecutor;
import com.abhishek.utils.DateUtils;

import java.util.List;

/**
 * @author abhishek-m-gowda12
 */
public class StartSubscriptionServiceImpl implements CommandExecutor {

    @Override
    public void fulfillCommand(SubscriptionDetail subscriptionDetail, Command command) {
        List<String> params = command.getCommandParams();
        if (validateStartDate(params.get(0))) {
            subscriptionDetail.setSubscriptionStartDate(DateUtils.getLocalDateFromString(params.get(0)));
        } else {
            throw new InvalidDateException("INVALID_DATE", ErrorCodes.INVALID_DATE_EXCEPTION);
        }
    }

    private boolean validateStartDate(String date) {
        return DateUtils.validateDate(date);
    }
}
