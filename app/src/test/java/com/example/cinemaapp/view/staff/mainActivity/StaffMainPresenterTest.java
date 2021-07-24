package com.example.cinemaapp.view.staff.mainActivity;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffMainPresenterTest {


    private StaffMainViewStub view;
    private UserDAOMemory users;
    private StaffMainPresenter presenter;
    private MemoryInitialiser data;

    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        users = new UserDAOMemory();
        view = new StaffMainViewStub();
        presenter = new StaffMainPresenter(view,users);

    }

    /**
     * Test for button addMovie in StaffMainActivity
     */
    @Test
    public void TestaddMovie() {
        for(int i = 0; i < 10; i++) {
            presenter.addMovie();
        }

        Assert.assertEquals(10, view.getSelectMovieActivityClicks());
    }

    /**
     * Test for button ClearProgram in StaffMainActivity
     */
    @Test
    public void TestClearProgram(){
        for(int i = 0; i < 10; i++) {
            presenter.ClearProgram();
        }

        Assert.assertEquals(10, view.getClearProgramActivityClicks());
    }

    /**
     * Test that checks if we find the correct movie Theater based on its name
     */
    @Test
    public void TestfindMovieTheater() {
        view.setEmail("stest2@gmail.com");
        Assert.assertEquals("Village",presenter.findMovieTheater());
    }

    /**
     * Test that checks if we find the correct first name of a user
     */
    @Test
    public void TestgetFirstName() {
        view.setEmail("stest2@gmail.com");
        Assert.assertEquals("Nikolaos",presenter.getFirstName());
    }
}
