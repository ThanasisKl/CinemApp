package com.example.cinemaapp.view.staff.selectMovie;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffSelectMoviePresenterTest {

    private StaffSelectMovieViewStub view;
    private UserDAOMemory users;
    private MemoryInitialiser data;
    private StaffSelectMoviePresenter presenter;
    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        users = new UserDAOMemory();
        view = new StaffSelectMovieViewStub();
        presenter = new StaffSelectMoviePresenter(view,users);
    }

    /**
     * Test that checks if we find the correct Movie Theater of a staff member
     */
    @Test
    public void TestfindMovieTheater() {
        view.setEmail("stest2@gmail.com");
        Assert.assertEquals("Village",presenter.findMovieTheater());
    }
}