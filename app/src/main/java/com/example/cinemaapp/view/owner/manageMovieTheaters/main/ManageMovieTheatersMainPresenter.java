package com.example.cinemaapp.view.owner.manageMovieTheaters.main;

public class ManageMovieTheatersMainPresenter {

    ManageMovieTheatersMainView view;

    public ManageMovieTheatersMainPresenter(ManageMovieTheatersMainView view) {
        this.view = view;
    }

    public void addMovieTheater() {
        view.onAddMovieTheater();
    }

    public void removeMovieTheater() {
        view.onRemoveMovieTheater();
    }

}
