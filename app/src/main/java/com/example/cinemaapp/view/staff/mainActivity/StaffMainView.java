package com.example.cinemaapp.view.staff.mainActivity;

public interface StaffMainView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that creates an intent to StaffSelectMovieActivity
     */
    void onSelectMovie();

    /**
     * Method that creates an intent to ClearProgramActivity
     */
    void onClearProgram();

    /**
     * Method that returns the Movie Theater as given from another activity
     * @return
     */
    String getMovieTheater();

    /**
     * Method that returns the email as given from another activity
     * @return
     */
    String getEmail();

}
