package com.abhishek.service;

import com.abhishek.domain.SubscriptionDetails;
import com.abhishek.domain.TopUpDetail;
import com.abhishek.enums.SubscriptionCategory;
import com.abhishek.enums.SubscriptionPlan;
import com.abhishek.enums.TopUp;
import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.SubscriptionNotFoundException;
import com.abhishek.utils.DateUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author abhishek-m-gowda12
 */
public class FileProcessorService {
    private final File file;

    public FileProcessorService(String filePath) {
        file = new File(filePath);
    }

    public SubscriptionDetails processLine() throws IOException {
        SubscriptionDetails subscriptionDetails = new SubscriptionDetails();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(" ");
                switch (details[0]) {
                    case "START_SUBSCRIPTION":
                        subscriptionDetails.setSubscriptionStartDate(DateUtils.getLocalDateFromString(details[1]));
                        break;
                    case "ADD_SUBSCRIPTION":
                        subscriptionDetails.addSubscriptionDetails(SubscriptionPlan.valueOf(details[1]), SubscriptionCategory.valueOf(details[2]));
                        break;
                    case "ADD_TOPUP":
                        TopUpDetail topupDetail = new TopUpDetail(TopUp.valueOf(details[1]), Integer.parseInt(details[2]));
                        subscriptionDetails.setTopUpDetail(topupDetail);
                        break;
                    case "PRINT_RENEWAL_DETAILS":
                        subscriptionDetails.setPrintRenewalDetails(true);
                        break;
                    default:
                }
            }
        }
        if (subscriptionDetails.getSubscriptionDetails().isEmpty()) {
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND", ErrorCodes.SUBSCRIPTION_NOT_FOUND_EXCEPTION);
        }

        return subscriptionDetails;
    }
}
