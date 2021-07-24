package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;
    private ArrayList<Rating> ratings;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        movie = new Movie("Avengers Endgame", 3f);
        ratings = new ArrayList<>();
        customer = new Customer("customer@gmail.com", "password", "Stelios", "Pantelopoulos");
        Rating rating1 = new Rating(3, "good", customer.getFirstName(), customer.getLastName(), movie);
        Rating rating2 = new Rating(1, "bad", customer.getFirstName(), customer.getLastName(), movie);
        ratings.add(rating1);
        ratings.add(rating2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTitle() {
        assertEquals("Avengers Endgame", movie.getTitle());
    }

    @Test
    public void setTitle() {
        movie.setTitle("Avengers infinity war");
        assertEquals("Avengers infinity war", movie.getTitle());
    }

    @Test
    public void getDuration() {
        assertEquals(3f, movie.getDuration(), 3f);
    }

    @Test
    public void setDuration() {
        movie.setDuration(2f);
        assertEquals(2f, movie.getDuration(),2f);
    }

    @Test
    public void getMovieId() {
        assertEquals(-1, movie.getId());
    }

    @Test
    public void setMovieId() {
        movie.setId(1);
        assertEquals(1, movie.getId());
    }

    @Test
    public void setRatings(){
        movie.setRatings(ratings);
        assertArrayEquals(ratings.toArray(), movie.getRatings().toArray());
    }

    @Test
    public void addRating() {
        Rating rating3 = new Rating(0, "very bad", customer.getFirstName(), customer.getLastName(), movie);
        movie.addRating(rating3);
        assertEquals(rating3, movie.getRatings().get(0));
    }
}

