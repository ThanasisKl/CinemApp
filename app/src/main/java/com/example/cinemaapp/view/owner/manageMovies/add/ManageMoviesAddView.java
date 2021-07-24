package com.example.cinemaapp.view.owner.manageMovies.add;

public interface ManageMoviesAddView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return movie's title as given from input form
     * @return movieTitle
     */
    String getMovieTitle();

    /**
     * Method that return movie's duration as given from input form
     * @return movieDuration
     */
    int getDuration();

    /**
     * Method that creates an intent to owner main activity
     */
    void onManageMoviesMain();

    /**
     * Method that creates a pop up message to current activity
     * @param message
     */
    void showMessage(String message);

}
