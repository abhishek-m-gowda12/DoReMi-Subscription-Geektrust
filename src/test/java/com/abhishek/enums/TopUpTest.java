package com.abhishek.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author abhishek-m-gowda12
 */
class TopUpTest {

    Integer FOUR_DEVICE_DEVICE;
    Integer TEN_DEVICE_DEVICE;

    Integer FOUR_DEVICE_AMOUNT;
    Integer TEN_DEVICE_AMOUNT;

    @BeforeEach
    public void setup() {
        FOUR_DEVICE_DEVICE = 4;
        TEN_DEVICE_DEVICE = 10;

        FOUR_DEVICE_AMOUNT = 50;
        TEN_DEVICE_AMOUNT = 100;
    }

    @Test
    void testGetNumberOfArguments() {
        assertEquals(Optional.of(TopUp.FOUR_DEVICE.getDevice()).get(), FOUR_DEVICE_DEVICE);
        assertEquals(Optional.of(TopUp.TEN_DEVICE.getDevice()).get(), TEN_DEVICE_DEVICE);

        assertEquals(Optional.of(TopUp.FOUR_DEVICE.getAmount()).get(), FOUR_DEVICE_AMOUNT);
        assertEquals(Optional.of(TopUp.TEN_DEVICE.getAmount()).get(), TEN_DEVICE_AMOUNT);
    }
}