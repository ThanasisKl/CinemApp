package com.example.cinemaapp.view.owner.mainActivity;

public interface OwnerMainView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    String getEmail();

    /**
     * Method that creates an intent to owner add staff activity
     */
    void onAddStaff();

    /**
     * Method that creates an intent to owner manage movies main activity
     */
    void onManageMovies();

    /**
     * Method that creates an intent to owner manage movie theaters main activity
     */
    void onManageMovieTheaters();

    /**
     * Method that creates an intent to owner see statistics main activity
     */
    void onSeeStatistics();
}
