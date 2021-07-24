package com.example.cinemaapp.view.owner.mainActivity;

import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerMainViewStub implements OwnerMainView{

    private int addStaffClicks,
                manageMoviesClicks,
                manageMovieTheatersClicks,
                seeStatisticsClicks;

    private OwnerMainPresenter presenter;

    private String email;

    public OwnerMainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(OwnerMainPresenter presenter) {
        this.presenter = presenter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void onAddStaff() {
        addStaffClicks++;
    }

    public void onManageMovies() {
        manageMoviesClicks++;
    }

    public void onManageMovieTheaters() {
        manageMovieTheatersClicks++;
    }

    public void onSeeStatistics() {
        seeStatisticsClicks++;
    }

    public int getAddStaffClicks() {
        return addStaffClicks;
    }

    public int getManageMoviesClicks() {
        return manageMoviesClicks;
    }

    public int getManageMovieTheatersClicks() {
        return manageMovieTheatersClicks;
    }

    public int getSeeStatisticsClicks() {
        return seeStatisticsClicks;
    }

}