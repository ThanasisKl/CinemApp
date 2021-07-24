package com.example.cinemaapp.dao.daostub;



import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.MovieTheater;

import java.util.ArrayList;

public interface MovieTheaterDAO {
    /**
     //The method that saves movie theater to the database
     * @param movieTheater
     */
    void save(MovieTheater movieTheater);

    /**
     * The method that removes movie theater from a database
     * @param movieTheaterId
     */
    void delete(int movieTheaterId);

    /**
     * The method that updates movie theater from a database
     * @param movieTheater
     */
    void update(MovieTheater movieTheater);

    /**
     * The method that finds movie theater
     * @param movieTheaterName
     * @return user or null
     */
    MovieTheater find(String movieTheaterName);

    /**
     * The method that returns all movie theater
     * @return all customers or null
     */
    ArrayList<MovieTheater> listMovieTheaters();

}
