package com.example.cinemaapp.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieTheaterTest {
    private ArrayList<Boolean> seats1 = new ArrayList<Boolean>();
    private ArrayList<Boolean> seats2 = new ArrayList<Boolean>();
    private Auditorium auditorium1;
    private Auditorium auditorium2;
    private MovieTheater movieTheater;
    private ArrayList<Auditorium> auditoriums = new ArrayList<Auditorium>();
    private Slot slot ;
    private Slot slot2 ;
    private ArrayList<Slot> slots = new ArrayList<Slot>();
    private Movie movie;
    private DailySchedule dailySchedule;



    @Before
    public void setUp() throws Exception {
        for(int i=0; i<10; i++){
            seats1.add(true);
            seats2.add(true);
        }
        auditorium1 = new Auditorium(1, 10);
        auditorium2 = new Auditorium(2, 10);
        auditoriums.add(auditorium1);
        auditoriums.add(auditorium2);
        movieTheater = new MovieTheater("Village", "Athens",  auditoriums );

        movie = new Movie("Avengers endgame", 2f);
        slot = new Slot(1, movie, auditorium1);
        slots.add(slot);
        slot2 = new Slot(3, movie, auditorium1);
        slots.add(slot2);
        Day day = Day.FRIDAY;
//        dailySchedule = new DailySchedule(day, slots);
//        movieTheater.setDailySchedule(dailySchedule);
    }

    @Test
    public void getName() {
        assertEquals("Village", movieTheater.getName());
    }

    @Test
    public void setName() {
        movieTheater.setName("Petretzikis");
        assertEquals("Petretzikis", movieTheater.getName());
    }

    @Test
    public void getAddress() {
        assertEquals("Athens", movieTheater.getAddress());
    }

    @Test
    public void setAddress() {
        movieTheater.setAddress("Olympou 15");
        assertEquals("Olympou 15", movieTheater.getAddress());
    }

    @Test
    public void getId() {
        assertEquals(-1, movieTheater.getId());
    }

    @Test
    public void setId() {
        movieTheater.setId(2);
        assertEquals(2, movieTheater.getId());
    }

    @Test
    public void getAuditoriums() {
        assertArrayEquals(auditoriums.toArray(), movieTheater.getAuditoriums().toArray());
    }

    @Test
    public void setAuditoriums() {
        Auditorium auditorium3 = new Auditorium(3 , 10);
        auditoriums.add(auditorium3);
        movieTheater.setAuditoriums(auditoriums);
        assertArrayEquals(auditoriums.toArray(), movieTheater.getAuditoriums().toArray());
    }
}

