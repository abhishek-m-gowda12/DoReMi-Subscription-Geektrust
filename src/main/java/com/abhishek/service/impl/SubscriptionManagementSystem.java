package com.abhishek.service.impl;

import com.abhishek.factory.CommandExecutorFactory;
import com.abhishek.modal.Command;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.service.CommandExecutor;

/**
 * @author abhishek-m-gowda12
 */
public class SubscriptionManagementSystem {
    private final SubscriptionDetail subscriptionDetail;

    public SubscriptionManagementSystem() {
        subscriptionDetail = new SubscriptionDetail();
    }

    public void fulfillCommand(Command inputCommand) throws RuntimeException {
        CommandExecutor commandExecutor = CommandExecutorFactory.getExecutor(inputCommand);
        try {
            commandExecutor.fulfillCommand(subscriptionDetail, inputCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
