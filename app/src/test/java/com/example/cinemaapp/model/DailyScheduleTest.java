package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DailyScheduleTest {
    private Auditorium auditorium;
    private Movie movie;
    private Movie movie2;
    private Slot slot ;
    private Slot slot2 ;
    private DailySchedule dailySchedule;
    private ArrayList<Slot> slots = new ArrayList<>();
    private Auditorium auditorium2;
    private Auditorium auditorium3;
    private Slot slot3;
    private ArrayList<Auditorium> auditoriums = new ArrayList<>();


    @Before
    public void setUp() throws Exception {

        auditorium = new Auditorium(1, 30);
        auditorium2 = new Auditorium(2, 30);
        auditorium3 = new Auditorium(3, 30);
        movie2 = new Movie("Avengers", 2f);
        movie = new Movie("Avengers Endgame", 2f);
        slot = new Slot(9, movie, auditorium);
        slots.add(slot);
        slot2 = new Slot(11, movie2, auditorium2);
        slots.add(slot2);
        slot3 = new Slot(9, movie2, auditorium3);
        slots.add(slot3);
        auditoriums.add(auditorium);
        auditoriums.add(auditorium2);
        auditoriums.add(auditorium3);
        Day day = Day.WEDNESDAY;
        dailySchedule = new DailySchedule(day, auditoriums);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setSlots(){
        dailySchedule.setSlots(slots);
        assertArrayEquals(slots.toArray(), dailySchedule.getSlots().toArray());
    }

    @Test
    public void getDay() {
       Day day2 = Day.WEDNESDAY;
        assertEquals(day2.toString(), dailySchedule.getDay().toString());
    }

    @Test
    public void setDay() {
        Day day2 = Day.MONDAY;
        dailySchedule.setDay(day2);
        assertEquals(day2.toString(), dailySchedule.getDay().toString());
    }

    @Test
    public void addSlot() {
        dailySchedule.addSlot(new Slot(13, movie2, auditorium));
        assertEquals(13, dailySchedule.getSlots().size());
    }

}

