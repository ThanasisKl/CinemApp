package com.example.cinemaapp.view.owner.manageMovies.main;

public class ManageMoviesMainPresenter {

    ManageMoviesMainView view;

    public ManageMoviesMainPresenter(ManageMoviesMainView view) {
        this.view = view;
    }

    public void addMovie() {
        view.onAddMovie();
    }

    public void removeMovie() {
        view.onRemoveMovie();
    }
}
