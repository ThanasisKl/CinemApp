package com.example.cinemaapp.view.customer.payment;

import com.example.cinemaapp.util.Slot_Day;

public interface PaymentView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return amount as given from previous activity
     * @return amount
     */
    float getAmount();

    /**
     * Method that return credit card number as given from input
     * @return creditCardNumber
     */
    String getCreditCardNumber();

    /**
     * Method that creates an intent to customer main activity
     */
    void onCustomerMain();

    /**
     * The method returns the day from Slot_Day object
     * @return seats
     */
    Slot_Day getSlot_Day();

    /**
     * The method returns the seats that the user choose
     * @return seats
     */
    int getSeats();

    /**
     * The method returns the email of the user
     * @return email
     */
    String getEmail();

    /**
     * The method that returns the movie theater name that customer choose for his reservation
     * @return movieTheaterName
     */
    String getMovieTheaterName();
    /**
     * This method show a pop on user screen
     * @param message
     */
    void showMessage(String message);

}
