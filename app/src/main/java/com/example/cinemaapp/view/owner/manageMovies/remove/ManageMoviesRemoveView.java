package com.example.cinemaapp.view.owner.manageMovies.remove;

public interface ManageMoviesRemoveView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that creates an intent to owner remove activity and passes movieTitle
     * @param movieTitle
     */
    void onRemoveMovie(String movieTitle);

    /**
     * Method that creates a popup to current activity
     * @param Message
     */
    void showMessage(String Message);

    /**
     * Method that returns movie title as given from previous activity
     * @return movieTitle
     */
    String getMovieTitle();
}
