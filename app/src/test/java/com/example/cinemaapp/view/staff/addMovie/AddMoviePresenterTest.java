package com.example.cinemaapp.view.staff.addMovie;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Slot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddMoviePresenterTest {

    private AddMovieViewStub view;
    private MovieTheaterDAOMemory movieTheaters;
    private MovieDAOMemory movies;
    private MemoryInitialiser data;
    private AddMoviePresenter presenter;
    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        movieTheaters = new MovieTheaterDAOMemory();
        movies = new MovieDAOMemory();
        view = new AddMovieViewStub();
        presenter = new AddMoviePresenter(view,movieTheaters,movies);
        view.setPresenter(presenter);
    }

    /**
     * This test checks if the presenter finds the correct film
     */
    @Test
    public void TestfindMovie() {
        view.setMovieTitle("Avengers Endgame");

        Assert.assertEquals("Avengers Endgame",presenter.findMovie().getTitle());
    }

    /**
     * Test that checks if the correct slot gets the movie Title
     */
    @Test
    public void TestselectMovieSlot(){
        view.setMovieTheater("Village");
        view.setMovieTitle("Avengers Endgame");
        view.setMovie(movies.find(view.getMovieTitle()));
        view.setAuditorium(movieTheaters.find(view.getMovieTheater()).getAuditoriums().get(0));
        view.setStart(13);
        view.setDay(0);
        presenter.selectMovieSlot();
        Slot correctSlot = movieTheaters.find(view.getMovieTheater()).getDailySchedules().get(0).getSlots().get(2);
        Assert.assertEquals("Avengers Endgame",correctSlot.getMovie().getTitle());
    }



}