package com.abhishek.service;

import com.abhishek.modal.SubscriptionDetail;

/**
 * @author abhishek-m-gowda12
 */
public interface SubscriptionRenewalService {
    void generateRenewalPlan(SubscriptionDetail subscriptionDetail);
}
