package com.example.cinemaapp.view.owner.manageMovieTheaters.remove;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.MovieTheater;

public class ManageMovieTheatersRemovePresenter {

    ManageMovieTheatersRemoveView view;
    MovieTheaterDAOMemory movieTheaters;

    private MovieTheater movieTheaterToRemove;

    public ManageMovieTheatersRemovePresenter(ManageMovieTheatersRemoveView view, MovieTheaterDAOMemory movieTheaters) {
        this.view = view;
        this.movieTheaters = movieTheaters;
    }

    public void removeMovieTheater() {
        movieTheaterToRemove = movieTheaters.find(view.getMovieTheaterName());
        movieTheaters.delete(movieTheaterToRemove.getId());
    }
}
