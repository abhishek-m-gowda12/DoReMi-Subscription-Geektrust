package com.abhishek.service.impl;

import com.abhishek.enums.TopUp;
import com.abhishek.exceptions.DuplicateTopUpException;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.InvalidDateException;
import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.modal.TopUpDetail;
import com.abhishek.service.CommandExecutor;

import java.util.List;

/**
 * @author abhishek-m-gowda12
 */
public class AddTopUpServiceImpl implements CommandExecutor {
    @Override
    public void fulfillCommand(SubscriptionDetail subscriptionDetail, Command command) {
        List<String> params = command.getCommandParams();

        TopUpDetail topupDetail = new TopUpDetail(TopUp.valueOf(params.get(0)), Integer.parseInt(params.get(1)));
        if (subscriptionDetail.getTopUpDetail() != null) {
            throw new DuplicateTopUpException("ADD_TOPUP_FAILED DUPLICATE_TOPUP", ErrorCodes.DUPLICATE_TOP_UP_EXCEPTION);
        } else if (subscriptionDetail.getSubscriptionStartDate() == null) {
            throw new InvalidDateException("ADD_TOPUP_FAILED INVALID_DATE", ErrorCodes.INVALID_DATE_EXCEPTION);
        }
        subscriptionDetail.setTopUpDetail(topupDetail);
    }
}
