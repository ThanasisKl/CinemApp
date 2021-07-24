package com.example.cinemaapp.view.owner.manageMovies.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManageMoviesMainPresenterTest {

    private ManageMoviesMainPresenter presenter;
    private ManageMoviesMainViewStub view;


    @Before
    public void setUp() throws Exception {
        view = new ManageMoviesMainViewStub();
        presenter = new ManageMoviesMainPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Test for button AddMovie in ManageMoviesMainActivity
     */
    @Test
    public void testAddMovie() {
        for(int i = 0; i < 10; i++) {
            presenter.addMovie();
        }

        Assert.assertEquals(10, view.getAddMovieClicks());
    }

    /**
     * Test for button RemoveMovie in ManageMoviesMainActivity
     */
    @Test
    public void testRemoveMovie() {
        for(int i = 0; i < 10; i++) {
            presenter.removeMovie();
        }

        Assert.assertEquals(10, view.getRemoveMovieClicks());
    }
}