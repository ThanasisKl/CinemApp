package com.example.cinemaapp.view.owner.manageMovieTheaters.main;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ManageMovieTheatersMainPresenterTest {

    private ManageMovieTheatersMainPresenter presenter;
    private ManageMovieTheatersMainViewStub view;

    @Before
    public void setUp() throws Exception {
        view = new ManageMovieTheatersMainViewStub();
        presenter = new ManageMovieTheatersMainPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Test for button AddMovieTheater in ManageMovieTheatersMainActivity
     */
    @Test
    public void testAddMovieTheater() {
        for(int i = 0; i < 10; i++) {
            presenter.addMovieTheater();
        }

        Assert.assertEquals(10, view.getAddMovieTheaterClicks());
    }

    /**
     * Test for button RemoveMovieTheater in ManageMovieTheatersMainActivity
     */
    @Test
    public void testRemoveMovieTheater() {
        for(int i = 0; i < 10; i++) {
            presenter.removeMovieTheater();
        }

        Assert.assertEquals(10, view.getRemoveMovieTheaterClicks());
    }
}