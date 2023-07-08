package com.abhishek.service.impl;

import com.abhishek.domain.SubscriptionDetails;
import com.abhishek.domain.SubscriptionTime;
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

    public void generateRenewalPlan(SubscriptionDetails subscriptionDetails) {
        BigDecimal renewalAmount = BigDecimal.ZERO;

        if (subscriptionDetails.getSubscriptionDetails() != null && !subscriptionDetails.getSubscriptionDetails().isEmpty()) {
            for (Map.Entry<SubscriptionPlan, SubscriptionCategory> subscriptionInfo : subscriptionDetails.getSubscriptionDetails().entrySet()) {
                SubscriptionAmountFactory subscriptionAmountFactory = SubscriptionAmountFactory.getSubscriptionAmountFactoryInstance(subscriptionInfo.getKey(), subscriptionInfo.getValue());
                SubscriptionTime subscriptionTime = subscriptionAmountFactory.getSubscriptionTime();

                System.out.println(subscriptionInfo.getKey().toString() + " " + DateUtils.addMonthsAndGetAsString(subscriptionDetails.getSubscriptionStartDate(), subscriptionTime.getTime()));

                if (subscriptionDetails.isPrintRenewalDetails() && (!Objects.equals(subscriptionTime.getAmount(), BigDecimal.ZERO))) {
                    renewalAmount = renewalAmount.add(subscriptionTime.getAmount());
                }
            }

            if (subscriptionDetails.getTopupDetail() != null) {
                int topUpAmount = subscriptionDetails.getSubscriptionDetails().size() * subscriptionDetails.getTopupDetail().getTopUp().getAmount();
                renewalAmount = renewalAmount.add(BigDecimal.valueOf(topUpAmount));
            }

            if (subscriptionDetails.isPrintRenewalDetails()) {
                System.out.println("RENEWAL_AMOUNT " + renewalAmount);
            }
        }
    }
}
