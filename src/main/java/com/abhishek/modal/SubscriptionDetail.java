package com.abhishek.modal;

import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionDetail {
    private LocalDate subscriptionStartDate;
    private Map<SubscriptionPlan, SubscriptionCategory> subscriptionDetails = new EnumMap<>(SubscriptionPlan.class);
    private TopUpDetail topUpDetail;
    private boolean isPrintRenewalDetails;

    public LocalDate getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(LocalDate subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Map<SubscriptionPlan, SubscriptionCategory> getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(Map<SubscriptionPlan, SubscriptionCategory> subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    public TopUpDetail getTopUpDetail() {
        return topUpDetail;
    }

    public void setTopUpDetail(TopUpDetail topUpDetail) {
        this.topUpDetail = topUpDetail;
    }

    public boolean isPrintRenewalDetails() {
        return isPrintRenewalDetails;
    }

    public void setPrintRenewalDetails(boolean printRenewalDetails) {
        this.isPrintRenewalDetails = printRenewalDetails;
    }
}
