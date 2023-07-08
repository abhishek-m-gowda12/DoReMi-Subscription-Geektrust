package com.abhishek.domain;

import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.exceptions.DuplicateSubscriptionException;
import com.abhishek.exceptions.DuplicateTopUpException;
import com.abhishek.exceptions.ErrorCodes;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionDetails {
    private LocalDate subscriptionStartDate;
    private final Map<SubscriptionPlan, SubscriptionCategory> subscriptionDetails = new EnumMap<>(SubscriptionPlan.class);
    private TopUpDetail topUpDetail;
    private boolean printRenewalDetails;

    public SubscriptionDetails() {
    }

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Map<SubscriptionPlan, SubscriptionCategory> getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void addSubscriptionDetails(SubscriptionPlan subscriptionPlan, SubscriptionCategory subscriptionCategory) {
        if (this.subscriptionDetails.containsKey(subscriptionPlan)) {
            throw new DuplicateSubscriptionException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY", ErrorCodes.DUPLICATE_SUBSCRIPTION_EXCEPTION);
        }
        this.subscriptionDetails.put(subscriptionPlan, subscriptionCategory);
    }

    public TopUpDetail getTopupDetail() {
        return topUpDetail;
    }

    public void setTopUpDetail(TopUpDetail topUpDetail) {
        if (this.topUpDetail != null) {
            throw new DuplicateTopUpException("ADD_TOPUP_FAILED DUPLICATE_TOPUP", ErrorCodes.DUPLICATE_TOP_UP_EXCEPTION);
        }
        this.topUpDetail = topUpDetail;
    }

    public boolean isPrintRenewalDetails() {
        return printRenewalDetails;
    }

    public void setPrintRenewalDetails(boolean printRenewalDetails) {
        this.printRenewalDetails = printRenewalDetails;
    }

}
