package com.example.cinemaapp.view.main.signin;

public interface SignInView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that returns the email of the user
     * @return
     */
    String getEmail();

    /**
     * Method that returns the password of the user
     * @return
     */
    String getPassword();


    /**
     * Method that creates a popup to current activity
     * @param message
     */
    void showMessage(String message);

    /**
     * Method that creates an intent to StaffMainActivity
     */
    void onStaffMain();

    /**
     * Method that creates an intent to CustomerMainActivity
     */
    void onCustomerMain();

    /**
     * Method that creates an intent to OwnerMainActivity
     */
    void onOwnerMain();
}
