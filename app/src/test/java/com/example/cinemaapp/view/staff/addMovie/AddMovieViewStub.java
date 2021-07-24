package com.example.cinemaapp.view.staff.addMovie;

import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.view.main.signin.SignInPresenter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddMovieViewStub implements  AddMovieView {

    private AddMoviePresenter presenter;
    private String MovieTitle;
    private String movieTheater;
    private int day;
    private int start;
    private Movie movie;
    private Auditorium auditorium;



    public AddMoviePresenter getPresenter() {
        return presenter;
    }


    public void setPresenter(AddMoviePresenter presenter) {
        this.presenter = presenter;
    }


    public void setMovieTitle(String newTitle){
        MovieTitle = newTitle;
    }


    public String getMovieTitle() {return MovieTitle;
    }

    public String getEmail() {return null;
    }

    @Override
    public void onAddMovie(int day, int start, Auditorium auditorium, String movieTheaterName) {

    }

    public void showMessage(String Message) {

    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public Movie getMovie() {
        return movie;
    }

    @Override
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Auditorium getAuditorium() {
        return auditorium;
    }

    @Override
    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }


    @Override
    public String getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(String movieTheaterName) {
        this.movieTheater = movieTheaterName;
    }
}