package com.example.cinemaapp.view.owner.manageMovieTheaters.add;

import com.example.cinemaapp.model.Auditorium;

import java.util.ArrayList;

public interface ManageMovieTheatersAddView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return movie theater name as given from input form
     * @return movieTheaterName
     */
    String getMovieTheaterName();

    /**
     * Method that return movie theater address as given from input form
     * @return movieTheaterAddress
     */
    String getAddress();

    /**
     * Method that return movie theater auditoriums as given from input form
     * @return auditoriumsNumber
     */
    int getAuditoriumsNumber();

    /**
     * Method that creates an intent to owner main activity
     */
    void onManageMovieTheatersMain();

    /**
     *  Method that creates a pop up message to current activity
     * @param message
     */
    void showMessage(String message);


}
