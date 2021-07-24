package com.example.cinemaapp.view.owner.manageMovieTheaters.add;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ManageMovieTheatersAddPresenterTest {

    private ManageMovieTheatersAddViewStub view;
    private ManageMovieTheatersAddPresenter presenter;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new ManageMovieTheatersAddViewStub();
        presenter = new ManageMovieTheatersAddPresenter(view, new MovieTheaterDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test checks if the owner left any fields empty during addition of movie theater
     */
    @Test
    public void testEmptyFields() {
        view.setMovieTheaterName("");
        presenter.addMovieTheater();

        Assert.assertEquals("Please complete all fields...", view.getMessage());
    }

    /**
     * This test checks if the owner gave movie theater name that exists in the database during addition of movie theater
     */
    @Test
    public void testMovieExists() {
        view.setMovieTheaterName("Village");
        view.setAddress("Omonoias5");
        view.setAuditoriumsNumber(9);
        presenter.addMovieTheater();

        Assert.assertEquals("Movie Theater already submitted...", view.getMessage());
    }

    /**
     * This test checks if the owner gave too many auditoriums during addition of movie theater
     */
    @Test
    public void testWrongNumberOfAuditoriums() {
        view.setMovieTheaterName("New Movie Theater");
        view.setAddress("Omonoias5");
        view.setAuditoriumsNumber(100);
        presenter.addMovieTheater();

        Assert.assertEquals("Too many Auditoriums...", view.getMessage());
    }

    /**
     * This test checks if the main movie theater manage activity loads when all fields are correct
     */
    @Test
    public void testSuccessfulAddition() {
        view.setMovieTheaterName("New Movie Theater");
        view.setAddress("Omonoias5");
        view.setAuditoriumsNumber(9);
        presenter.addMovieTheater();
        Assert.assertEquals(1, view.getManageMovieTheatersMainClicks());
    }
}