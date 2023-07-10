package com.abhishek.modal;

import com.abhishek.enums.TopUp;

/**
 * @author abhishek-m-gowda12
 */
public class TopUpDetail {
    private final TopUp topUp;
    private final int month;

    public TopUpDetail(TopUp topUp, int month) {
        this.topUp = topUp;
        this.month = month;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public int getMonth() {
        return month;
    }
}
