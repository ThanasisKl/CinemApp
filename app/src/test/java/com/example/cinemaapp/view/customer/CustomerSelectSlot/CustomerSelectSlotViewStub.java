package com.example.cinemaapp.view.customer.CustomerSelectSlot;

import com.example.cinemaapp.util.Slot_Day;

import java.util.ArrayList;

public class CustomerSelectSlotViewStub implements CustomerSelectSlotView {

    private String movieTitle, movieTheaterTitle, email;
    private ArrayList<Slot_Day> slot_days = new ArrayList<>();

    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public void setMovieTheaterTitle(String movieTheaterTitle){
        this.movieTheaterTitle = movieTheaterTitle;
    }

    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String getMovieTheaterTitle() {
        return movieTheaterTitle;
    }

    @Override
    public ArrayList<Slot_Day> onFindMovieSlots() {
        return slot_days;
    }

    @Override
    public void onSelectMovie(Slot_Day slot_day) {

    }

    @Override
    public String getEmail() {
        return email;
    }
}
