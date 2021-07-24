package com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal;

public interface AddRatingNormalView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return movie title as given from previous activity
     * @return movieTitle
     */
    String getMovieTitle();

    /**
     * Method that return email as given from previous activity
     * @return email
     */
    String getEmail();

    /**
     * Method that return rating as given from input
     * @return rating
     */
    float getRating();

    /**
     * Method that creates an intent to add rating main activity
     */
    void onMainAddRating();
}
