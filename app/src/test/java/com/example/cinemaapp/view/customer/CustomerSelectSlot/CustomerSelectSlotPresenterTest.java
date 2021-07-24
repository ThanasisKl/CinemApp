package com.example.cinemaapp.view.customer.CustomerSelectSlot;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerSelectSlotPresenterTest {
    private CustomerSelectSlotPresenter presenter;
    private MemoryInitialiser data;
    private MovieTheaterDAOMemory movieTheaters;
    private CustomerSelectSlotViewStub view;

    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        movieTheaters = new MovieTheaterDAOMemory();
        view = new CustomerSelectSlotViewStub();
        presenter = new CustomerSelectSlotPresenter(view,movieTheaters);

    }

    /**
     * This test checks if the size of the list that findMovieSlots is the correct one
     */
    @Test
    public void findMovieSlots() {
        view.setMovieTheaterTitle("Cinemax");
        view.setMovieTitle("Harry Potter And The Half Blood Prince ");
        //presenter.findMovieSlots();
        assertEquals(2, presenter.findMovieSlots().size());

    }
}