package com.abhishek.service.impl;

import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.modal.SubscriptionTime;
import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.factory.SubscriptionAmountFactory;
import com.abhishek.service.SubscriptionRenewalService;
import com.abhishek.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionRenewalServiceImpl implements SubscriptionRenewalService {

    public void generateRenewalPlan(SubscriptionDetail subscriptionDetail) {
        BigDecimal renewalAmount = BigDecimal.ZERO;

        if (subscriptionDetail.getSubscriptionDetails() != null && !subscriptionDetail.getSubscriptionDetails().isEmpty()) {
            for (Map.Entry<SubscriptionPlan, SubscriptionCategory> subscriptionInfo : subscriptionDetail.getSubscriptionDetails().entrySet()) {
                SubscriptionAmountFactory subscriptionAmountFactory = SubscriptionAmountFactory.getSubscriptionAmountFactoryInstance(subscriptionInfo.getKey(), subscriptionInfo.getValue());
                SubscriptionTime subscriptionTime = subscriptionAmountFactory.getSubscriptionTime();

                System.out.println("RENEWAL_REMINDER " + subscriptionInfo.getKey().toString() + " " + DateUtils.addMonthsAndGetAsString(subscriptionDetail.getSubscriptionStartDate(), subscriptionTime.getTime()));

                if (subscriptionDetail.isPrintRenewalDetails() && (!Objects.equals(subscriptionTime.getAmount(), BigDecimal.ZERO))) {
                    renewalAmount = renewalAmount.add(subscriptionTime.getAmount());
                }
            }
            int topUpAmount = getTopUpDetails(subscriptionDetail);
            renewalAmount = renewalAmount.add(BigDecimal.valueOf(topUpAmount));

            printRenewalAmount(subscriptionDetail, renewalAmount);
        }
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
