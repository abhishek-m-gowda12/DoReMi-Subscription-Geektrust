package com.abhishek.service;

import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;

/**
 * @author abhishek-m-gowda12
 */
public interface CommandExecutor {
    void fulfillCommand(SubscriptionDetail subscriptionDetail, Command command);
}
