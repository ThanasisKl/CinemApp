package com.example.cinemaapp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SlotsTest {
    private Slot slot;
    private Auditorium auditorium;
    private ArrayList<Boolean> seats = new ArrayList();
    private Movie slotMovie = new Movie("Iron man", 2f);
     ArrayList<Integer> failsafe;



    @Before
    public void setUp() throws Exception {
        auditorium = new Auditorium(2, 30);
        slot = new Slot(3,slotMovie,auditorium);
        failsafe = new ArrayList<>();
        failsafe.add(1);
        failsafe.add(3);
        failsafe.add(5);
    }

    @Test
    public void getStart() {
        assertEquals(3, slot.getStart());
    }

    @Test
    public void setStart() {
        slot.setStart(5);
        assertEquals(5, slot.getStart());
    }

    @Test
    public void getMovie() {
        assertEquals(slotMovie, slot.getMovie());
    }

    @Test
    public void setMovie() {
        Movie movie2 = new Movie("Iron man 2", 2f);
        slot.setMovie(movie2);
        assertEquals(movie2.getTitle() , slot.getMovie().getTitle());
    }

    @Test
    public void getAuditorium() {
        assertEquals(auditorium, slot.getAuditorium());
    }

    @Test
    public void setAuditorium() {
        Auditorium auditorium2 = new Auditorium(10, 10);
        slot.setAuditorium(auditorium2);
        assertSame(auditorium2, slot.getAuditorium());
    }

    @Test
    public void setAvailable() {
        slot.setAvailable(11);
        assertEquals(11, slot.getAvailable());
    }

    @Test
    public void setAvailablePremium() {
        slot.setAvailablePremium(12);
        assertEquals(12, slot.getAvailablePremium());
    }

    @Test
    public void getAvailable() {
        assertEquals(20 , slot.getAvailable());
    }

    @Test
    public void getAvailablePremium() {
        assertEquals(10 , slot.getAvailablePremium());
    }


    @Test
    public void testReserveSeatsNormal() {
        slot.reserveSeats(10, TypeOfUser.NORMAL);
        Assert.assertEquals(10, slot.getAvailable());

    }

    @Test
    public void testReserveSeatsPremiumAvailable() {
        slot.reserveSeats(5, TypeOfUser.PREMIUM);
        Assert.assertEquals(5, slot.getAvailablePremium());
    }

    @Test
    public void testReserveSeatsPremiumNotAvailable() {
        slot.reserveSeats(15, TypeOfUser.PREMIUM);
        Assert.assertEquals(0, slot.getAvailablePremium());
        Assert.assertEquals(15, slot.getAvailable());
    }
}

