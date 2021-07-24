package com.example.cinemaapp.model;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class StaffTest {

    private Staff staff;
    private ArrayList<Auditorium> autitorium_list;
    private ArrayList<Boolean> AuditoriumArray;
    private Auditorium auditorium;
    private MovieTheater theater;

    @Before
    public void setUp() throws Exception {
        AuditoriumArray = new ArrayList();
        AuditoriumArray.add(true);
        AuditoriumArray.add(true);
        AuditoriumArray.add(true);
        AuditoriumArray.add(false);
        AuditoriumArray.add(true);
        auditorium = new Auditorium(14,30);
        autitorium_list = new ArrayList<>();
        autitorium_list.add(auditorium);


        theater = new MovieTheater(" Village Cinema","Sofiko", autitorium_list);
        staff = new Staff("test@gmail.com","123456","Themistoklis","Papadopoulos",theater);
        staff.setMovieTheater(theater);
    }


    @Test
    public void getMovieTheater(){
        assertEquals(theater,staff.getMovieTheater());
    }

    @Test
    public void setMovieTheater(){
        staff.setMovieTheater(null);
        assertNull(staff.getMovieTheater());
    }

}