package com.example.cinemaapp.view.customer.reservationCustomer;

import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Slot;

public interface CustomerReservationView {
    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */


    /**
     * Method that returns the amount of seats the user wants to book
     * @return numberOfSeats
     */
    int getSeats();

    /**
     * Method that returns the name of the movie theater the user selected
     * @return movie_theater
     */
    String getMovieTheaterName();


    /**
     * Method that returns the slot the user selected to view a movie
     * @return slotDay.getSlot()
     */
    Slot getSelectedSlot();

    /**
     * Method that returns the day the user selected to view a movie
     * @return slotDay.getDay()
     */
    Day getSelectedDay();

    /**
     * Method that creates a pop up message in users screen
     * @param message
     */
    void showMessage(String message);
}
