package com.example.cinemaapp.view.owner.seeStatistics.individualMovie;

import java.util.ArrayList;

public interface SeeStatisticsForIndividualMovieView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that returns the Movie Title
     * @return
     */
    String getMovieTitle();

    /**
     * Method that returns an arraylist that contains the number
     * of tickets for a specific movie over a period of a week
     * @return
     */
    ArrayList<Integer> getTicketsSold();
}
