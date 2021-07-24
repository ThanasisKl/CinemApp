package com.example.cinemaapp.view.customer.rating.addRatings.main;

import com.example.cinemaapp.model.TypeOfUser;

public interface AddRatingsView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that creates an intent to add rating (normal or premium) activity
     * @param movieTitle
     */
    void onSelectMovie(String movieTitle);

    /**
     * Method that return type of users as given from previous activity
     * @return typeOfUser
     */
    TypeOfUser getTypeOfUser();

    /**
     * Method that return email as given from previous activity
     * @return email
     */
    String getEmail();
}
