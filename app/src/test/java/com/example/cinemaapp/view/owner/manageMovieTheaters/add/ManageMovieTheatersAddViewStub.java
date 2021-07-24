package com.example.cinemaapp.view.owner.manageMovieTheaters.add;


public class ManageMovieTheatersAddViewStub implements ManageMovieTheatersAddView{

    private int manageMovieTheatersMainClicks;

    private ManageMovieTheatersAddPresenter presenter;

    private String name, address, message;
    private int numberOfAuditoriums;

    public void setPresenter(ManageMovieTheatersAddPresenter presenter) {
        this.presenter = presenter;
    }

    public int getManageMovieTheatersMainClicks() {
        return manageMovieTheatersMainClicks;
    }

    public void setManageMovieTheatersMainClicks(int manageMovieTheatersMainClicks) {
        this.manageMovieTheatersMainClicks = manageMovieTheatersMainClicks;
    }

    @Override
    public void onManageMovieTheatersMain() {
        manageMovieTheatersMainClicks++;
    }

    @Override
    public void showMessage(String message) {
        this.message = message;
    }

    public String getMovieTheaterName() {
        return name;
    }

    public void setMovieTheaterName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAuditoriumsNumber() {
        return numberOfAuditoriums;
    }

    public void setAuditoriumsNumber(int numberOfAuditoriums) {
        this.numberOfAuditoriums = numberOfAuditoriums;
    }
}