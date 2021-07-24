package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class OwnerTest {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieTheater movieTheater;
    private MovieTheater movieTheater2;
    private Owner owner;
    private Auditorium auditorium1;
    private Auditorium auditorium2;
    private ArrayList<Auditorium> auditoriums = new ArrayList<>();
    private ArrayList<Boolean> seats = new ArrayList();
    private Slot slot;
    private Slot slot2;
    private ArrayList<Slot> slots = new ArrayList();
    private DailySchedule dailySchedule;
    private Movie movie;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Customer customner;
    @Before
    public void setUp() throws Exception {
        owner = new Owner("ypo@aueb.gr", "bruh", "david", "villa", "0805", "1111");
        for(int i=0; i<10; i++){
            seats.add(true);
        }
        auditorium1 = new Auditorium(1, 30);
        auditorium2 = new Auditorium(2, 30);
        auditoriums.add(auditorium1);
        auditoriums.add(auditorium2);
        movie = new Movie("Finding Nemo", 2f);
        slot = new Slot(1, movie, auditorium1);
        slot2 = new Slot(3, movie, auditorium1);
        Day day = Day.FRIDAY;
        slots.add(slot);
        slots.add(slot2);
//        dailySchedule = new DailySchedule(day, slots);
        System.setOut(new PrintStream(outContent));
        customner = new Customer("a@aueb.gr", "invincible", "taki", "tsan");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSn() {
        assertEquals("0805", owner.getSn());
    }

    @Test
    public void setSn() {
        owner.setSn("0806");
        assertEquals("0806", owner.getSn());
    }

    @Test
    public void getAmka() {
        assertEquals("1111", owner.getAmka());
    }

    @Test
    public void setAmka() {
        owner.setAmka("2222");
        assertEquals("2222", owner.getAmka());
    }

    @Test
    public void getMovieTheaters() {
        movieTheater = new MovieTheater("niarxos", "Paraliaki", auditoriums);
        movieTheater2 = new MovieTheater("niarxos2","peiraias",auditoriums);
        ArrayList<MovieTheater> movieTheaters = new ArrayList<>();
        movieTheaters.add(movieTheater);
        movieTheaters.add(movieTheater2);
        owner.setMovieTheaters(movieTheaters);
        assertEquals("niarxos", owner.getMovieTheaters().get(0).getName());
    }

    @Test
    public void setMovieTheaters() {
        ArrayList<MovieTheater> movieTheaters2 = new ArrayList<>();
        movieTheater = new MovieTheater("niarxos2","peiraias",auditoriums);
        movieTheaters2.add(movieTheater);
        owner.setMovieTheaters(movieTheaters2);
        assertArrayEquals(movieTheaters2.toArray(), owner.getMovieTheaters().toArray());
    }


    @Test
    public void setMovies() {
        Movie movie2 = new Movie("Inception", 2f);
        movies.add(movie2);
        owner.setMovies(movies);
        assertArrayEquals(movies.toArray(), owner.getMovies().toArray());

    }


}
