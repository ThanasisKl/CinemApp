package com.example.cinemaapp.view.staff.addMovie;

import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Movie;

public interface AddMovieView {
    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     *Method that returns the Movie Title as given from another activity
     * @return
     */
    String getMovieTitle();

    /**
     * Method that returns the MovieTheater as given from another activity
     * @return
     */
    String getMovieTheater();

    /**
     * Method that sets a new value to the variable MovieTheater
     * @param movieTheaterName
     */
    void setMovieTheater(String movieTheaterName);

    /**
     * Method that returns the email as given from another activity
     * @return
     */
    String getEmail();

    /**
     * Method that creates an intent to StaffSelectMovieActivity
     * @param day
     * @param start
     * @param auditorium
     * @param movieTheaterName
     */
    void onAddMovie(int day, int start, Auditorium auditorium, String movieTheaterName);

    /**
     * Method that creates a popup to current activity
     * @param Message
     */
    void showMessage(String Message);

    /**
     * Method that sets a new value to day
     * @param day
     */
    void setDay(int day);

    /**
     * Method that returns the variable day
     * @return
     */
    int getDay();

    /**
     * Method that sets a new value to the variable start
     * @param start
     */
    void setStart(int start);

    /**
     * Method that returns the variable start
     * @return
     */
    int getStart();

    /**
     * Method that sets a new value to the variable Movie
     * @param movie
     */
    void setMovie(Movie movie);

    /**
     * Method that returns the value of the variable Movie
     * @return
     */
    Movie getMovie();

    /**
     * Method that sets a new value to the variable Auditorium
     * @param auditorium
     */
    void setAuditorium(Auditorium auditorium);

    /**
     * Method that returns the value of a the variable Auditorium
     * @return
     */
    Auditorium getAuditorium();



}
