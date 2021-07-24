package com.example.cinemaapp.view.owner.signupOwner;

public interface SignUpOwnerView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that returns the email
     * @return
     */
    String getEmail();

    /**
     * Method that returns the password
     * @return
     */
    String getPassword();

    /**
     * Method that returns the First Name of the owner
     * @return
     */
    String getFirstName();

    /**
     * Method that returns the Last Name of the owner
     * @return
     */
    String getLastName();

    /**
     * Method that returns the Social Security Number of the owner
     * @return
     */
    String getSSN();

    /**
     * Method that returns the AMKA of the owner
     * @return
     */
    String getAMKA();

    /**
     * Method that creates a popup to current activity
     * @param message
     */
    void showMessage(String message);

    /**
     *  Method that creates an intent to OwnerMainActivity
     */
    void onOwnerMain();

}
