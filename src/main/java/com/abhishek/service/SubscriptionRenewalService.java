package com.abhishek.service;

import com.abhishek.domain.SubscriptionDetails;

/**
 * @author abhishek-m-gowda12
 */
public interface SubscriptionRenewalService {
    void generateRenewalPlan(SubscriptionDetails subscriptionDetails);
}
