package com.example.cinemaapp.view.customer.CustomerSelectSlot;

import com.example.cinemaapp.util.Slot_Day;

import java.util.ArrayList;

public interface CustomerSelectSlotView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * the method returns the movie title of the movie the user selected
     * @return movieTitle
     */
    String getMovieTitle();

    /**
     *the method returns the movie theater name of the movie theater the user selected
     * @return movieTheaterName
     */
    String getMovieTheaterTitle();

    /**
     *The method returns the slots and the days that the movie selected is available for the particular movie theater
     * the user selected
     * @return ArrayList<Slot_Day> slot_day_list
     */
    ArrayList<Slot_Day> onFindMovieSlots();

    /**
     * The moethod starts the CustomerReservationActivity when the user selects the slot he wants to watch
     * the movie on
     * @param slot_day
     */

    void onSelectMovie(Slot_Day slot_day);

    /**
     * The method returns the email of the user
     * @return email
     */
    String getEmail();
}
