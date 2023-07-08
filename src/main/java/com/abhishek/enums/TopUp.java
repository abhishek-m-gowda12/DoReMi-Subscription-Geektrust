package com.abhishek.enums;

/**
 * @author abhishek-m-gowda12
 */
public enum TopUp {
    FOUR_DEVICE(4, 50), TEN_DEVICE(10, 100);
    private final int device;
    private final int amount;

    TopUp(int device, int amount) {
        this.device = device;
        this.amount = amount;
    }

    public int getDevice() {
        return device;
    }

    public int getAmount() {
        return amount;
    }
}
