package com.example.cinemaapp.view.owner.seeStatistics.individualMovie;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import static org.junit.Assert.*;

public class SeeStatisticsForIndividualMoviePresenterTest {

    private SeeStatisticsForIndividualMovieViewStub view;
    private SeeStatisticsForIndividualMoviePresenter presenter;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new SeeStatisticsForIndividualMovieViewStub();
        presenter = new SeeStatisticsForIndividualMoviePresenter(view, new MovieTheaterDAOMemory());

    }

    @Test
    public void testSeeStatisticsForACertainMovie() {
        view.setMovieTitle("Avengers Endgame");
        ArrayList<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(20); expectedArray.add(0); expectedArray.add(0); expectedArray.add(0); expectedArray.add(0); expectedArray.add(0); expectedArray.add(0); expectedArray.add(20);

        Assert.assertEquals(expectedArray, presenter.getTicketsSold());
    }
}