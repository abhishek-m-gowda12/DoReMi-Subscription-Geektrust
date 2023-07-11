package com.abhishek;

import com.abhishek.modal.Command;
import com.abhishek.service.FileProcessorService;
import com.abhishek.service.impl.SubscriptionManagementSystem;

import java.util.List;

public class DoReMiSubscriptionGeektrustApplication {

    public static void main(String[] args) {
        try {
            FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
            List<Command> commandList = fileProcessorService.processLine();

            SubscriptionManagementSystem subscriptionManagementSystem = new SubscriptionManagementSystem();

            for (Command command : commandList) {
                subscriptionManagementSystem.fulfillCommand(command);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
