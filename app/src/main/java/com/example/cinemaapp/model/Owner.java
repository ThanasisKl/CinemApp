package com.example.cinemaapp.model;

import java.util.ArrayList;

public class Owner extends User {
    private String sn, Amka;
    private ArrayList<MovieTheater> movieTheaters = new ArrayList();
    private ArrayList<Movie> movies = new ArrayList();

    public Owner(String email, String password, String firstName, String lastName, String sn, String Amka){
        super(email, password, firstName, lastName);
        this.sn = sn;
        this.Amka = Amka;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAmka() {
        return Amka;
    }

    public void setAmka(String amka) {
        Amka = amka;
    }

    public ArrayList<MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

    public void setMovieTheaters(ArrayList<MovieTheater> movieTheaters) {
        this.movieTheaters = movieTheaters;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }


}
