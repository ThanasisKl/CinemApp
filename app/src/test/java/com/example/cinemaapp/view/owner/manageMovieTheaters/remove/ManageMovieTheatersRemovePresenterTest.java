package com.example.cinemaapp.view.owner.manageMovieTheaters.remove;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ManageMovieTheatersRemovePresenterTest {

    private ManageMovieTheatersRemovePresenter presenter;
    private ManageMovieTheatersRemoveViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new ManageMovieTheatersRemoveViewStub();
        presenter = new ManageMovieTheatersRemovePresenter(view, new MovieTheaterDAOMemory());
        view.setPresenter(presenter);
    }


    @Test
    public void testRemoveMovieTheater() {
        view.setMovieTheaterName("Village");
        presenter.removeMovieTheater();
        Assert.assertEquals(1, view.getRemoveMovieTheaterClicks());
    }
}