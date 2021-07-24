package com.example.cinemaapp.view.customer.rating.addRatings.addRating.premium;

public interface AddRatingPremiumView {

    /**
     * @author Pantelopoulos Stelios
     * @author Ziogas Iasonas
     * @author Apostolopoulos Themis
     * @author Klettas Thanasis
     */

    /**
     * Method that return movie title as given from previous activity
     * @return
     */
    String getMovieTitle();

    /**
     * Method that return email as given from previous activity
     * @return
     */
    String getEmail();

    /**
     * Method that return comments as given from input
     * @return
     */
    String getComments();

    /**
     * Method that return rating as given from input
     * @return
     */
    float getRating();

    /**
     * Method that creates an intent to add rating main activity
     */
    void onMainAddRating();
}
