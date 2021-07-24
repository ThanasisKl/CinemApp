package com.example.cinemaapp.view.customer.rating.mainRating;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainRatingPresenterTest {

    private MainRatingPresenter presenter;
    private MainRatingViewStub view;

    @Before
    public void setUp() throws Exception {

        view = new MainRatingViewStub();
        presenter = new MainRatingPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Test for button AddRatings in CustomerRatingMainActivity
     */
    @Test
    public void addRatings() {
        for(int i = 0; i < 10; i++) {
            presenter.addRatings();
        }

        Assert.assertEquals(10, view.getAddRatingsClicks());
    }

    /**
     * Test for button ReadRatings in CustomerRatingMainActivity
     */
    @Test
    public void readRatings() {
        for(int i = 0; i < 10; i++) {
            presenter.readRatings();
        }

        Assert.assertEquals(10, view.getReadRatingsClicks());
    }
}