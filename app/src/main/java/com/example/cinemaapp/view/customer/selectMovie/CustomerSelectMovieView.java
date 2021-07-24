package com.example.cinemaapp.view.customer.selectMovie;

public interface CustomerSelectMovieView {
    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that starts the CustomerSelectMovieTheaterActivity after a user selected a movie
     * @param MovieTitle
     */
    void onSelectMovie(String MovieTitle);

    /**
     * Method that returns the email of the customer
     * @return email
     */
    String getEmail();
}
