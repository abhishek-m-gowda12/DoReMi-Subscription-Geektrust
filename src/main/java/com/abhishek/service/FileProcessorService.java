package com.abhishek.service;

import com.abhishek.exceptions.DuplicateSubscriptionException;
import com.abhishek.exceptions.DuplicateTopUpException;
import com.abhishek.modal.SubscriptionDetail;
import com.abhishek.modal.TopUpDetail;
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
import java.util.EnumMap;
import java.util.Map;

/**
 * @author abhishek-m-gowda12
 */
public class FileProcessorService {
    private final File file;

    public FileProcessorService(String filePath) {
        file = new File(filePath);
    }

    public SubscriptionDetail processLine() throws IOException {
        SubscriptionDetail subscriptionDetail = new SubscriptionDetail();
        Map<SubscriptionPlan, SubscriptionCategory> subscriptionDetails = new EnumMap<>(SubscriptionPlan.class);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(" ");
                switch (details[0]) {
                    case "START_SUBSCRIPTION":
                        subscriptionDetail.setSubscriptionStartDate(DateUtils.getLocalDateFromString(details[1]));
                        break;
                    case "ADD_SUBSCRIPTION":
                        if (subscriptionDetails.containsKey(SubscriptionPlan.valueOf(details[1]))) {
                            throw new DuplicateSubscriptionException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY", ErrorCodes.DUPLICATE_SUBSCRIPTION_EXCEPTION);
                        }
                        subscriptionDetails.put(SubscriptionPlan.valueOf(details[1]), SubscriptionCategory.valueOf(details[2]));
                        break;
                    case "ADD_TOPUP":
                        TopUpDetail topupDetail = new TopUpDetail(TopUp.valueOf(details[1]), Integer.parseInt(details[2]));
                        if (subscriptionDetail.getTopUpDetail() != null) {
                            throw new DuplicateTopUpException("ADD_TOPUP_FAILED DUPLICATE_TOPUP", ErrorCodes.DUPLICATE_TOP_UP_EXCEPTION);
                        }
                        subscriptionDetail.setTopUpDetail(topupDetail);
                        break;
                    case "PRINT_RENEWAL_DETAILS":
                        subscriptionDetail.setPrintRenewalDetails(true);
                        break;
                    default:
                }
            }
            subscriptionDetail.setSubscriptionDetails(subscriptionDetails);
        }
        if (subscriptionDetail.getSubscriptionDetails().isEmpty()) {
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND", ErrorCodes.SUBSCRIPTION_NOT_FOUND_EXCEPTION);
        }

        return subscriptionDetail;
    }
}
