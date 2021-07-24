package com.example.cinemaapp.view.owner.manageMovieTheaters.main;


public class ManageMovieTheatersMainViewStub implements ManageMovieTheatersMainView{

    private int addMovieTheaterClicks,
                removeMovieTheaterClicks;

    private ManageMovieTheatersMainPresenter presenter;

    public ManageMovieTheatersMainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(ManageMovieTheatersMainPresenter presenter) {
        this.presenter = presenter;
    }

    public void onAddMovieTheater() {
        addMovieTheaterClicks++;
    }

    public void onRemoveMovieTheater() {
        removeMovieTheaterClicks++;
    }

    public int getAddMovieTheaterClicks() {
        return addMovieTheaterClicks;
    }

    public int getRemoveMovieTheaterClicks() {
        return removeMovieTheaterClicks;
    }
}