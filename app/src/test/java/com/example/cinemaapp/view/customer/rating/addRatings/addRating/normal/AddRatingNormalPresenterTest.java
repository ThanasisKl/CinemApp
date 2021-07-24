package com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.RatingsDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Rating;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddRatingNormalPresenterTest {

    private AddRatingNormalPresenter presenter;
    private AddRatingNormalViewStub view;

    private MemoryInitialiser initialiser;
    private RatingsDAOMemory ratings;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        ratings = new RatingsDAOMemory();

        view = new AddRatingNormalViewStub();
        presenter = new AddRatingNormalPresenter(view, new UserDAOMemory(), new RatingsDAOMemory(), new MovieDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test check if the data of a normal user rating are saved correctly in the database and
     * if the main ratings activity is lunched when the button is pressed
     */
    @Test
    public void testNormalCustomerMakesRating() {
        view.setEmail("themis@gmail.com");
        view.setRating(5);
        view.setMovieTitle("Avengers Endgame");
        presenter.addRating();

        Assert.assertEquals("Themis", ratings.find(7).getFirstName());
        Assert.assertEquals("Apostolopoulos", ratings.find(7).getLastName());
        Assert.assertEquals((float)5, ratings.find(7).getScore(), 1);
        Assert.assertEquals("Avengers Endgame", ratings.find(7).getMovie().getTitle());
        Assert.assertEquals(1, view.getMainRatingClicks());
    }
}