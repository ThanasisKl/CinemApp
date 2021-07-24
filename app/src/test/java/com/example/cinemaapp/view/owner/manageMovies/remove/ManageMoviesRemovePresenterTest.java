package com.example.cinemaapp.view.owner.manageMovies.remove;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.view.owner.manageMovieTheaters.remove.ManageMovieTheatersRemovePresenter;
import com.example.cinemaapp.view.owner.manageMovieTheaters.remove.ManageMovieTheatersRemoveViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManageMoviesRemovePresenterTest {

    private ManageMoviesRemovePresenter presenter;
    private ManageMoviesRemoveViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new ManageMoviesRemoveViewStub();
        presenter = new ManageMoviesRemovePresenter(view, new MovieDAOMemory());
        view.setPresenter(presenter);
    }

    @Test
    public void testRemoveMovie() {
        view.setMovieTitle("Avengers Endgame");
        presenter.removeMovie();
        Assert.assertEquals(1, view.getRemoveMovieClicks());
    }
}