package com.example.cinemaapp.view.owner.manageMovieTheaters.add;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.MovieTheater;

import java.util.ArrayList;

public class ManageMovieTheatersAddPresenter {

    public static final int CAPACITY = 30;
    private ManageMovieTheatersAddView view;
    private MovieTheaterDAOMemory movieTheaters;
    private MovieTheater movieTheater;
    private String name, address;
    private int numberOfAuditoriums;

    ManageMovieTheatersAddPresenter(ManageMovieTheatersAddView view, MovieTheaterDAOMemory movieTheaters){
        this.view = view;
        this.movieTheaters = movieTheaters;
    }

    public void addMovieTheater() {
        name = view.getMovieTheaterName();
        address = view.getAddress();
        numberOfAuditoriums = view.getAuditoriumsNumber();

        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields...");
        }else if(checkIfNameExists()){
            view.showMessage("Movie Theater already submitted...");
        }else if (numberOfAuditoriums > 10){
            view.showMessage("Too many Auditoriums...");
        }
        else{

            ArrayList<Auditorium> auditoriums = new ArrayList<>();

            for(int i=0; i < numberOfAuditoriums; i++){
                auditoriums.add(new Auditorium(i, CAPACITY));
            }

            movieTheater = new MovieTheater(name, address, auditoriums);
            movieTheaters.save(movieTheater);
            view.showMessage("Added Movie Theater successfully!");
            view.onManageMovieTheatersMain();
        }
    }

    private boolean checkForEmptyFields() {
        return name.isEmpty() || address.isEmpty() || numberOfAuditoriums == -1;
    }

    private boolean checkIfNameExists(){
        if(movieTheaters.find(name) != null){
            return true;
        }else{
            return false;
        }
    }
}
