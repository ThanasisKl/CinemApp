package com.example.cinemaapp.model;

import java.util.Date;

public class Payment {
    private float amount;
    private String cardNum;
    private int id = -1;

    public Payment(float amount, String cardNum) {
        this.amount = amount;
        this.cardNum = cardNum;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
