package com.example.cinemaapp.view.customer.signUpCustomer;

public interface SignUpCustomerView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return email as given from input form
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
     * Method that creates an intent to customer main activity (normal customer)
     */
    void onCustomerMain();

    /**
     * Method that creates an intent to payment activity (premium customer)
     */
    void onPayment();

    /**
     * Method that creates a pop up message in current activity
     * @param message
     */
    void showMessage(String message);


}
