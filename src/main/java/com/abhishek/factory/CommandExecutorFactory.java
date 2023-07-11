package com.abhishek.factory;

import com.abhishek.modal.Command;
import com.abhishek.service.CommandExecutor;
import com.abhishek.service.impl.AddSubscriptionServiceImpl;
import com.abhishek.service.impl.AddTopUpServiceImpl;
import com.abhishek.service.impl.PrintRenewalDetailsServiceImpl;
import com.abhishek.service.impl.StartSubscriptionServiceImpl;

/**
 * @author abhishek-m-gowda12
 */
public class CommandExecutorFactory {

    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if (task != null) {
            switch (task.getInputCommand()) {
                case START_SUBSCRIPTION:
                    executor = new StartSubscriptionServiceImpl();
                    break;
                case ADD_SUBSCRIPTION:
                    executor = new AddSubscriptionServiceImpl();
                    break;
                case ADD_TOPUP:
                    executor = new AddTopUpServiceImpl();
                    break;
                case PRINT_RENEWAL_DETAILS:
                    executor = new PrintRenewalDetailsServiceImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
