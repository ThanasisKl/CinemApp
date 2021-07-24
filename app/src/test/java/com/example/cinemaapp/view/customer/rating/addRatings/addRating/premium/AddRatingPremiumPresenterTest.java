package com.example.cinemaapp.view.customer.rating.addRatings.addRating.premium;

import com.example.cinemaapp.dao.daostub.Initialiser;
import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.RatingsDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal.AddRatingNormalPresenter;
import com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal.AddRatingNormalViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddRatingPremiumPresenterTest {

    private AddRatingPremiumPresenter presenter;
    private AddRatingPremiumViewStub view;

    private Initialiser initialiser;

    private RatingsDAOMemory ratings;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        ratings = new RatingsDAOMemory();

        view = new AddRatingPremiumViewStub();
        presenter = new AddRatingPremiumPresenter(view, new UserDAOMemory(), new RatingsDAOMemory(), new MovieDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test check if the data of a premium user rating are saved correctly in the database and
     * if the main ratings activity is lunched when the button is pressed
     */
    @Test
    public void testNormalCustomerMakesRating() {
        view.setEmail("iasonas@gmail.com");
        view.setRating(4);
        view.setComments("This movie is amazing!!");
        view.setMovieTitle("Avengers Endgame");
        presenter.addRating();

        Assert.assertEquals("Iasonas", ratings.find(7).getFirstName());
        Assert.assertEquals("Ziogas", ratings.find(7).getLastName());
        Assert.assertEquals((float)4, ratings.find(7).getScore(), 1);
        Assert.assertEquals("Avengers Endgame", ratings.find(7).getMovie().getTitle());
        Assert.assertEquals("This movie is amazing!!", ratings.find(7).getText());
        Assert.assertEquals(1, view.getAddRatingsMainClicks());
    }
}