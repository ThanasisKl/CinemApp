package com.example.cinemaapp.view.customer.mainActivity;

public interface CustomerMainView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that creates an intent to customer book ticket activity
     */
    void onBookTicket();

    /**
     * Method that creates an intent to customer make review activity
     */
    void onMakeReview();

    /**
     * Method that return email as given from previous activity
     * @return
     */
    String getEmail();
}
