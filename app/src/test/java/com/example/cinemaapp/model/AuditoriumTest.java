package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuditoriumTest {
    private Auditorium auditorium;

    @Before
    public void setUp() throws Exception {
        auditorium = new Auditorium(1,30);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        assertEquals(1,auditorium.getId() );
    }

    @Test
    public void setId() {
        auditorium.setId(2);
        assertEquals(2, auditorium.getId());
    }


    @Test
    public void getCapacity() {
        assertEquals(30, auditorium.getCapacity());
    }

    @Test
    public void setCapacity() {
        auditorium.setCapacity(40);
        assertEquals(40, auditorium.getCapacity());
    }
}