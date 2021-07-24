package com.example.cinemaapp.view.customer.reservationCustomer;

import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Slot;

public class CustomerReservationViewStub implements CustomerReservationView {

    private CustomerReservationPresenter presenter;
    private int seats;
    private Slot slot;
    private Day day;
    private String movie_theater_name;

    public CustomerReservationPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(CustomerReservationPresenter presenter) {
        this.presenter = presenter;
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
        return movie_theater_name;
    }

    public void setMovieTheaterName(String movie_theater_name) {
        this.movie_theater_name = movie_theater_name;
    }

    @Override
    public Slot getSelectedSlot() {
        return slot;
    }


    public void setSelectedSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public Day getSelectedDay() {
        return day;
    }

    public void setSelectedDay(Day day) {
        this.day = day;
    }

    @Override
    public void showMessage(String message) {

    }
}
