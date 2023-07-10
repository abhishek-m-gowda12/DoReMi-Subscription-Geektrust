package com.abhishek.utils;

import com.abhishek.exceptions.ErrorCodes;
import com.abhishek.exceptions.InvalidDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author abhishek-m-gowda12
 */
public class DateUtils {
    private DateUtils() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final DateValidatorUsingLocalDate VALIDATOR_USING_LOCAL_DATE = new DateValidatorUsingLocalDate(formatter);

    public static LocalDate getLocalDateFromString(String date) {
        boolean isValidDate = VALIDATOR_USING_LOCAL_DATE.isValid(date);
        if (!isValidDate) {
            throw new InvalidDateException("INVALID_DATE \n" +
                    "ADD_SUBSCRIPTION_FAILED INVALID_DATE", ErrorCodes.INVALID_DATE_EXCEPTION);
        }
        return LocalDate.parse(date, formatter);
    }

    public static String addMonthsAndGetAsString(LocalDate localDate, int months) {
        LocalDate localDateCopy = localDate.plusMonths(months);
        localDateCopy = localDateCopy.minusDays(10);
        return localDateCopy.format(formatter);
    }
}
