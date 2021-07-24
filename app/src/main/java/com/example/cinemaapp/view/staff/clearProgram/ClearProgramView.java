package com.example.cinemaapp.view.staff.clearProgram;

import com.example.cinemaapp.model.Auditorium;

public interface ClearProgramView {

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
     * Method that returns the Movie Theater as given from another activity
     * @return
     */
    String getMovieTheaterName();

    void setMovieTheaterName(String movieTheater);

    /**
     * Method that refreshes the current activity
     * @param day
     * @param start
     * @param auditorium
     * @param movieTheaterName
     */
    void onClearSlot(int day, int start, Auditorium auditorium, String movieTheaterName);

    /**
     * Method that creates a popup to current activity
     * @param Message
     */
    void showMessage(String Message);

    /**
     *
     * @return
     */
    int getDay() ;

    /**
     *
     * @param day
     */
    void setDay(int day);

    /**
     *
     * @return
     */
    int getStart();

    /**
     *
     * @param start
     */
    void setStart(int start);

    /**
     *
     * @return
     */
    Auditorium getAuditorium();

    /**
     *
     * @param auditorium
     */
    void setAuditorium(Auditorium auditorium);


}
