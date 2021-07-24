package com.example.cinemaapp.view.owner.manageMovies.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManageMoviesMainViewStub implements ManageMoviesMainView{

    private int addMovieClicks,
                removeMovieClicks;

    private ManageMoviesMainPresenter presenter;

    public ManageMoviesMainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(ManageMoviesMainPresenter presenter) {
        this.presenter = presenter;
    }

    public void onAddMovie() {
        addMovieClicks++;
    }

    public void onRemoveMovie() {
        removeMovieClicks++;
    }

    public int getAddMovieClicks() {
        return addMovieClicks;
    }

    public int getRemoveMovieClicks() {
        return removeMovieClicks;
    }
}