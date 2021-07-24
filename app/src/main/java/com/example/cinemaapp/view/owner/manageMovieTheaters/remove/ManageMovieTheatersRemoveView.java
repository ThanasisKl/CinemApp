package com.example.cinemaapp.view.owner.manageMovieTheaters.remove;

public interface ManageMovieTheatersRemoveView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that creates an intent to owner remove movie theater activity
     * @param movieTheaterName
     */
    void onRemoveMovieTheater(String movieTheaterName);

    /**
     * Method that return the movie theater name as given from previous activity
     * @return movieTheaterName
     */
    String getMovieTheaterName();
}
