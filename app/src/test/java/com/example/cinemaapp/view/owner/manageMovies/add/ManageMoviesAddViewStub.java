package com.example.cinemaapp.view.owner.manageMovies.add;

public class ManageMoviesAddViewStub implements ManageMoviesAddView{

    private int manageMoviesMainClicks;

    private ManageMoviesAddPresenter presenter;

    private String title, message;
    private int duration;

    public void setPresenter(ManageMoviesAddPresenter presenter) {
        this.presenter = presenter;
    }

    public int getManageMoviesMainClicks() {
        return manageMoviesMainClicks;
    }

    public void onManageMoviesMain() {
        manageMoviesMainClicks++;
    }

    public void showMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public String getMovieTitle() {
        return title;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}