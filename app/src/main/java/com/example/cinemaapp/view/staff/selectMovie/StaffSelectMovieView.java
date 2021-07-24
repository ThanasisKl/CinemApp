package com.example.cinemaapp.view.staff.selectMovie;

public interface StaffSelectMovieView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that returns the email as given from another activity
     * @return
     */
    String getEmail();

    /**
     * Method that returns the Movie Theater Name
     * @return
     */
    String getMovieTheaterName();

    /**
     * Method that creates an intent to AddMovieActivity
     * @param movieTitle
     */
    void onSelectMovie(String movieTitle);


}
