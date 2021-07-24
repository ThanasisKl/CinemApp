package com.example.cinemaapp.view.owner.manageMovies.remove;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.model.Movie;

public class ManageMoviesRemovePresenter {

    private ManageMoviesRemoveView view;
    private MovieDAOMemory movies;

    private Movie movieToRemove;

    public ManageMoviesRemovePresenter(ManageMoviesRemoveView view, MovieDAOMemory movies) {
        this.view = view;
        this.movies = movies;
    }

    public void removeMovie() {
        movieToRemove = movies.find(view.getMovieTitle());
        movies.delete(movieToRemove.getId());
        view.showMessage("Movie removed Successfully");
    }
}
