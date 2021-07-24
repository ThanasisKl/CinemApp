package com.example.cinemaapp.dao.daostub;


import com.example.cinemaapp.model.Rating;

import java.util.ArrayList;

public interface RatingsDAO {
    /**
     //The method that saves movie theater to the database
     * @param rating
     */
    void save(Rating rating);

    /**
     * Method that deletes a rating from the database
     * @param RatingsId
     */
    void delete(int RatingsId);

    /**
     * Method that updates a rating if it exists in the database
     * @param rating
     */
    void update(Rating rating);

    /**
     * Method that finds a rating from the database
     * @param ratingId
     * @return
     */
    Rating find(int ratingId);

    ArrayList<Rating> listRatings();
}
