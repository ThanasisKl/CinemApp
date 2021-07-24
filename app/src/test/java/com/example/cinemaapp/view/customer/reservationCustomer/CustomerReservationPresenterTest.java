package com.example.cinemaapp.view.customer.reservationCustomer;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Slot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerReservationPresenterTest {
    private CustomerReservationPresenter presenter;
    private MemoryInitialiser data;
    private MovieTheaterDAOMemory movie_theaters;
    private UserDAOMemory users;
    private CustomerReservationViewStub view;

    @Before
    public void setUp() throws Exception {
        data = new MemoryInitialiser();
        data.prepareData();
        movie_theaters = new MovieTheaterDAOMemory();
        users = new UserDAOMemory();
        view = new CustomerReservationViewStub();
        presenter = new CustomerReservationPresenter(view,movie_theaters,users);
        view.setPresenter(presenter);
    }

    /**
     * This test checks if there are enough available seats for a premium customer
     */
    @Test
    public void TestfindAvailability2_premium(){
        view.setSeats(10);
        view.setSelectedDay(Day.MONDAY);
        view.setMovieTheaterName("Village");
        Auditorium auditorium = new Auditorium(1,30);
        Movie movie = new Movie("Avengers Endgame", 2f);
        movie.setId(1);
        Slot slot = new Slot(9,movie,auditorium);
        view.setSelectedSlot(slot);
        Assert.assertTrue(presenter.findAvailability2("thanasis@gmail.com"));

        view.setSeats(31);
        Assert.assertFalse(presenter.findAvailability2("thanasis@gmail.com"));
    }

    /**
     * This test checks if there are enough available seats for a normal customer
     */
    @Test
    public void TestfindAvailability2_normal(){
        view.setSeats(10);
        view.setSelectedDay(Day.MONDAY);
        view.setMovieTheaterName("Cinemax");
        Auditorium auditorium = new Auditorium(4,30);
        Movie movie = new Movie("Avengers Endgame", 2f);
        movie.setId(1);
        Slot slot = new Slot(9,movie,auditorium);
        view.setSelectedSlot(slot);
        Assert.assertTrue(presenter.findAvailability2("iasonas@gmail.com"));

        view.setSeats(56);
        Assert.assertFalse(presenter.findAvailability2("iasonas@gmail.com"));
    }

    /**
     * This test checks if an email is belong to a premium or to a normal user
     */
    @Test
    public void TestfindTypeOfUserFromEmail(){
        Assert.assertTrue(presenter.findTypeOfUserFromEmail("thanasis@gmail.com"));
        Assert.assertFalse((presenter.findTypeOfUserFromEmail("iasonas@gmail.com")));
    }
}
