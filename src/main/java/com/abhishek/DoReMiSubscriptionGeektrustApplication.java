package com.abhishek;

import com.abhishek.domain.SubscriptionDetails;
import com.abhishek.exceptions.DuplicateSubscriptionException;
import com.abhishek.exceptions.DuplicateTopUpException;
import com.abhishek.exceptions.InvalidDateException;
import com.abhishek.exceptions.SubscriptionNotFoundException;
import com.abhishek.service.FileProcessorService;
import com.abhishek.service.SubscriptionRenewalService;
import com.abhishek.service.impl.SubscriptionRenewalServiceImpl;

public class DoReMiSubscriptionGeektrustApplication {

	public static void main(String[] args) {
		try {
			FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
			SubscriptionDetails subscriptionDetails = fileProcessorService.processLine();

			SubscriptionRenewalService subscriptionRenewalServiceImpl = new SubscriptionRenewalServiceImpl();
			subscriptionRenewalServiceImpl.generateRenewalPlan(subscriptionDetails);
		} catch (
				DuplicateTopUpException |
				SubscriptionNotFoundException |
				DuplicateSubscriptionException |
				InvalidDateException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
