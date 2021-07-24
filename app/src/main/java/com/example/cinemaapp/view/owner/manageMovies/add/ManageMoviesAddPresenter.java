package com.example.cinemaapp.view.owner.manageMovies.add;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.model.Movie;

public class ManageMoviesAddPresenter {

    private ManageMoviesAddView view;
    private MovieDAOMemory movies;
    private Movie movie;
    private String title;
    private int duration;

    ManageMoviesAddPresenter(ManageMoviesAddView view, MovieDAOMemory movies){
        this.view = view;
        this.movies = movies;
    }

    public void addMovie() {
        title = view.getMovieTitle();
        duration = view.getDuration();

        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields...");
        }else if(checkIfTitleExists()){
            view.showMessage("Movie already submitted...");
        }else{
            movie = new Movie(title, duration);
            movies.save(movie);
            view.showMessage("Added movie successfully!");
            view.onManageMoviesMain();
        }
    }

    private boolean checkForEmptyFields() {
        return title.isEmpty() || duration == -1;
    }

    private boolean checkIfTitleExists(){
        if(movies.find(title) != null){
            return true;
        }else{
            return false;
        }
    }
}
