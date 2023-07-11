package com.abhishek.service.impl;

import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.factory.SubscriptionAmountFactory;
import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.modal.SubscriptionTime;
import com.abhishek.service.CommandExecutor;
import com.abhishek.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * @author abhishek-m-gowda12
 */
public class PrintRenewalDetailsServiceImpl implements CommandExecutor {
    @Override
    public void fulfillCommand(SubscriptionDetail subscriptionDetail, Command command) {
        if (subscriptionDetail.getSubscriptionDetails().isEmpty()) {
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
        } else {
            subscriptionDetail.setPrintRenewalDetails(true);
            BigDecimal renewalAmount = BigDecimal.ZERO;
            for (Map.Entry<SubscriptionPlan, SubscriptionCategory> subscriptionInfo : subscriptionDetail.getSubscriptionDetails().entrySet()) {
                BigDecimal renewalAmountForSubscription = getRenewAmountAndPrintRenewalDetails(subscriptionDetail, subscriptionInfo);
                renewalAmount = renewalAmount.add(renewalAmountForSubscription);
            }
            int topUpAmount = getTopUpDetails(subscriptionDetail);
            renewalAmount = renewalAmount.add(BigDecimal.valueOf(topUpAmount));

            printRenewalAmount(subscriptionDetail, renewalAmount);
        }
    }

    private BigDecimal getRenewAmountAndPrintRenewalDetails(SubscriptionDetail subscriptionDetail, Map.Entry<SubscriptionPlan, SubscriptionCategory> subscriptionInfo) {
        SubscriptionAmountFactory subscriptionAmountFactory = SubscriptionAmountFactory.getSubscriptionAmountFactoryInstance(subscriptionInfo.getKey(), subscriptionInfo.getValue());
        SubscriptionTime subscriptionTime = subscriptionAmountFactory.getSubscriptionTime();
        BigDecimal renewalAmount = BigDecimal.ZERO;

        System.out.println("RENEWAL_REMINDER " + subscriptionInfo.getKey().toString() + " " + DateUtils.addMonthsAndGetAsString(subscriptionDetail.getSubscriptionStartDate(), subscriptionTime.getTime()));

        if (subscriptionDetail.isPrintRenewalDetails() && (!Objects.equals(subscriptionTime.getAmount(), BigDecimal.ZERO))) {
            renewalAmount = subscriptionTime.getAmount();
        }
        return renewalAmount;
    }

    private int getTopUpDetails(SubscriptionDetail subscriptionDetail) {
        int topUpAmount = 0;
        if (subscriptionDetail.getTopUpDetail() != null) {
            topUpAmount = subscriptionDetail.getTopUpDetail().getMonth() * subscriptionDetail.getTopUpDetail().getTopUp().getAmount();
        }
        return topUpAmount;
    }

    private void printRenewalAmount(SubscriptionDetail subscriptionDetail, BigDecimal renewalAmount) {
        if (subscriptionDetail.isPrintRenewalDetails()) {
            System.out.println("RENEWAL_AMOUNT " + renewalAmount);
        }
    }
}
