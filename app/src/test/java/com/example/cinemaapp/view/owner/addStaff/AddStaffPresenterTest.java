package com.example.cinemaapp.view.owner.addStaff;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddStaffPresenterTest {

    private AddStaffPresenter presenter;
    private AddStaffViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new AddStaffViewStub();
        presenter = new AddStaffPresenter(view, new UserDAOMemory(), new MovieTheaterDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test checks if the owner left any fields empty during addition of staff
     */
    @Test
    public void testEmptyField() {
        view.setEmail("");
        presenter.addStaff();
        Assert.assertEquals("Please complete all fields", view.getMessage());
    }

    /**
     * This test checks if the owner gave email that exists in the database during addition of staff
     */
    @Test
    public void testEmailExists() {
        view.setEmail("stest2@gmail.com");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setMovieTheater("Village");
        presenter.addStaff();
        Assert.assertEquals("Email already used", view.getMessage());
    }

    /**
     * This test checks if the owner gave movie theater name that doesn't exists in the database during his signUp
     */
    @Test
    public void testMovieTheaterWrong() {
        view.setEmail("staffNew@gmail.com");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setMovieTheater("WrongMovieTheater");
        presenter.addStaff();
        Assert.assertEquals("Incorrect Movie Theater...", view.getMessage());

    }

    /**
     * This test checks if the main owner activity loads when all fields are correct
     */
    @Test
    public void testSuccessfulStaffAddition() {
        view.setEmail("staffNew@gmail.com");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setMovieTheater("Village");
        presenter.addStaff();
        Assert.assertEquals(1, view.getOwnerMainClicks());
    }
}