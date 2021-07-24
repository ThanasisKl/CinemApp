package com.example.cinemaapp.view.staff.clearProgram;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClearProgramPresenterTest  {

    private MemoryInitialiser data;
    private ClearProgramViewStub view;
    private UserDAOMemory users;
    private MovieTheaterDAOMemory movieTheaters;
    private ClearProgramPresenter presenter;

    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        users = new UserDAOMemory();
        movieTheaters = new MovieTheaterDAOMemory();
        view = new ClearProgramViewStub();
        presenter = new ClearProgramPresenter(view,users,movieTheaters);
    }

    /**
     * Test that checks if the presenter finds the correct movie Theater based on its name
     */
    @Test
    public void TestfindMovieTheater() {
        view.setEmail("stest2@gmail.com");
        presenter.findMovieTheater();
        Assert.assertEquals("Village",presenter.findMovieTheater());
    }

    /**
     * Test that checks if we clear the correct slot
     */
    @Test
    public void TestclearMovieSlot() {
        view.setMovieTheaterName("Village");
        view.setMovieTheater(movieTheaters.find(view.getMovieTheaterName()));
        view.setDay(0);
        view.setStart(9);
        view.setAuditorium(view.getMovieTheater().getAuditoriums().get(0));
        presenter.clearMovieSlot();
        Assert.assertEquals(null,view.getMovieTheater().getDailySchedules().get(0).getSlots().get(0).getMovie());
    }
}