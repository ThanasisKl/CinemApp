package com.example.cinemaapp.view.customer.payment;

import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.util.Slot_Day;
import com.example.cinemaapp.view.customer.mainActivity.CustomerMainPresenter;

public class PaymentViewStub implements PaymentView {

    private int customerMainClicks;
    private float amount;
    private String creditCardNumber, email, movieTheaterName;
    private int seats;
    private Slot_Day slot_day;

    private PaymentPresenter presenter;

    public void setPresenter(PaymentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String getMovieTheaterName() {
        return movieTheaterName;
    }

    public void setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
    }

    @Override
    public Slot_Day getSlot_Day() {
        return slot_day;
    }

    public void setSlot_day(Slot_Day slot_day) {
        this.slot_day = slot_day;
    }



    @Override
    public void showMessage(String message) {

    }

    @Override
    public void onCustomerMain() {
        customerMainClicks++;
    }

    public int getCustomerMainClicks() {
        return customerMainClicks;
    }

}
