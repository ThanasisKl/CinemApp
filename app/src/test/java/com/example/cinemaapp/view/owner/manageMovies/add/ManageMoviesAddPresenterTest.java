package com.example.cinemaapp.view.owner.manageMovies.add;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManageMoviesAddPresenterTest {

    private ManageMoviesAddViewStub view;
    private ManageMoviesAddPresenter presenter;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new ManageMoviesAddViewStub();
        presenter = new ManageMoviesAddPresenter(view, new MovieDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test checks if the owner left any fields empty during addition of movie
     */
    @Test
    public void testEmptyFields() {
        view.setTitle("");
        presenter.addMovie();

        Assert.assertEquals("Please complete all fields...", view.getMessage());
    }

    /**
     * This test checks if the owner gave movie title that exists in the database during addition of movie
     */
    @Test
    public void testMovieExists() {
        view.setTitle("Avengers Endgame");
        view.setDuration(2);
        presenter.addMovie();

        Assert.assertEquals("Movie already submitted...", view.getMessage());
    }

    /**
     * This test checks if the main movie manage activity loads when all fields are correct
     */
    @Test
    public void testSuccessfulAddition() {
        view.setTitle("New movie");
        view.setDuration(2);
        presenter.addMovie();
        Assert.assertEquals(1, view.getManageMoviesMainClicks());
    }
}