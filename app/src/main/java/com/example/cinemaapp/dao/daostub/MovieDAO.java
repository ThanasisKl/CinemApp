package com.example.cinemaapp.dao.daostub;

import com.example.cinemaapp.model.Movie;

import java.util.ArrayList;

public interface MovieDAO {

    /**
     //The method that saves movies to the database
     * @param movie
     */
    void save(Movie movie);

    /**
     * The method that removes movies from a database
     * @param movieId
     */
    void delete(int movieId);

    /**
     * The method that updates movies from a database
     * @param movie
     */
    void update(Movie movie);

    /**
     * The method that finds movies
     * @param movieTitle
     * @return user or null
     */
    Movie find(String movieTitle);

    /**
     * The method that returns all movies
     * @return all customers or null
     */
    ArrayList<Movie> listMovies();

    int nextId();
}
