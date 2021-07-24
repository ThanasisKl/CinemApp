package com.example.cinemaapp.model;

public class Staff extends User {

    private MovieTheater movieTheater;

    public Staff(String email, String password, String firstName, String lastName, MovieTheater movieTheater){
        super(email, password, firstName, lastName);
        this.movieTheater = movieTheater;
    }

    public MovieTheater getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

}
