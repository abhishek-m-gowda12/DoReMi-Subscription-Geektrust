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
        return LocalDate.parse(date, formatter);
    }

    public static boolean validateDate(String date) {
        return VALIDATOR_USING_LOCAL_DATE.isValid(date);
    }


    public static String addMonthsAndGetAsString(LocalDate localDate, int months) {
        LocalDate localDateCopy = localDate.plusMonths(months);
        localDateCopy = localDateCopy.minusDays(10);
        return localDateCopy.format(formatter);
    }
}
