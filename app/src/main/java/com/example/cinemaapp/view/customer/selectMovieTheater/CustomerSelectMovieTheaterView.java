package com.example.cinemaapp.view.customer.selectMovieTheater;

public interface CustomerSelectMovieTheaterView {
    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that starts the CustomerSelectSlotActivity after a user selects a movie theater to watch a movie
     * @param movieTheater
     */
    void onSelectMovieTheater(String movieTheater);

    /**
     * Method that returns the movie title of the movie the user selected
     * @return movieTitle
     */
    String getMovieTitle();

    /**
     * Method that returns the email of the customer
     * @return email
     */
    String getEmail();
}
