package com.example.cinemaapp.view.owner.addStaff;

public interface AddStaffView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     *  Method that return email as given from input form
     * @return email
     */
    String getEmail();

    /**
     * Method that return password as given from input form
     * @return password
     */
    String getPassword();

    /**
     * Method that return first name as given from input form
     * @return firstName
     */
    String getFirstName();

    /**
     * Method that return last name as given from input form
     * @return lastName
     */
    String getLastName();

    /**
     * Method that return movie theater name as given from input form
     * @return movieTheaterName
     */
    String getMovieTheater();

    /**
     * Method that creates an intent to owner main activity
     */
    void onOwnerMain();

    /**
     * Method that creates a pop up message to current activity
     * @param message
     */
    void showMessage(String message);

}
