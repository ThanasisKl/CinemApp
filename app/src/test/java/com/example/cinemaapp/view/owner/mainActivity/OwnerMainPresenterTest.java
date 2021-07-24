package com.example.cinemaapp.view.owner.mainActivity;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerMainPresenterTest {

    private OwnerMainPresenter presenter;
    private OwnerMainViewStub view;

    private UserDAOMemory userDao;
    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();
        userDao = new UserDAOMemory();

        view = new OwnerMainViewStub();
        presenter = new OwnerMainPresenter(view, userDao);
        view.setPresenter(presenter);
    }

    /**
     * Test for button AddStaff in OwnerMainActivity
     */
    @Test
    public void testAddStaff() {
        for(int i = 0; i < 10; i++) {
            presenter.addStaff();
        }

        Assert.assertEquals(10, view.getAddStaffClicks());
    }

    /**
     * Test for button ManageMovies in OwnerMainActivity
     */
    @Test
    public void testManageMovies() {
        for(int i = 0; i < 10; i++) {
            presenter.manageMovies();
        }

        Assert.assertEquals(10, view.getManageMoviesClicks());
    }

    /**
     * Test for button ManageMovieTheaters in OwnerMainActivity
     */
    @Test
    public void testManageMovieTheaters() {
        for(int i = 0; i < 10; i++) {
            presenter.manageMovieTheaters();
        }

        Assert.assertEquals(10, view.getManageMovieTheatersClicks());
    }

    /**
     * Test for button SeeStatistics in OwnerMainActivity
     */
    @Test
    public void testSeeStatistics() {
        for(int i = 0; i < 10; i++) {
            presenter.seeStatistics();
        }

        Assert.assertEquals(10, view.getSeeStatisticsClicks());
    }

    /**
     * This test checks if given an owner email the correct first name is retrieved from the database
     */
    @Test
    public void testGetFirstName() {
        view.setEmail("owner@aueb.gr");
        Assert.assertEquals("George", userDao.find(view.getEmail()).getFirstName());
    }
}