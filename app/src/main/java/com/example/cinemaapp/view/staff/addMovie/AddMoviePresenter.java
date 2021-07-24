package com.example.cinemaapp.view.staff.addMovie;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Slot;

import java.util.ArrayList;

public class AddMoviePresenter {

    private AddMovieView view;
    private MovieTheaterDAOMemory movieTheaters;
    private MovieDAOMemory movies;

    public AddMoviePresenter(AddMovieView view, MovieTheaterDAOMemory movieTheaters, MovieDAOMemory movies) {
        this.view = view;
        this.movieTheaters = movieTheaters;
        this.movies = movies;
    }

    public void selectMovieSlot() {
        ArrayList<Slot> slots = movieTheaters.find(view.getMovieTheater()).getDailySchedules().get(view.getDay()).getSlots();

        for(Slot slot : slots){
            if(slot.getStart() == view.getStart() && slot.getAuditorium().getId() == view.getAuditorium().getId()){
                slot.setMovie(view.getMovie());
            }
        }
    }

    public Movie findMovie() {
        return movies.find(view.getMovieTitle());
    }
}
