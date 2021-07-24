package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {
    private Movie movie = new Movie("Gladiator", 2f);
    private Rating rating;
    private Customer customer  = new Customer("customer@gmail.com", "password", "Stelios", "Pantelopoulos");
    @Before
    public void setUp() throws Exception {
        rating = new Rating(4, "great movie", customer.getFirstName(), customer.getLastName(), movie);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(-1, rating.getId());
    }

    @Test
    public void testSetId() {
        rating.setId(100);
        Assert.assertEquals(100, rating.getId());
    }

    @Test
    public void getScore() {
        assertEquals(4, rating.getScore(), 0);
    }

    @Test
    public void setScore() {
        rating.setScore(2);
        assertEquals(2, rating.getScore(), 0);
    }

    @Test
    public void getText() {
        assertEquals("great movie", rating.getText());
    }

    @Test
    public void setText() {
        rating.setText("pretty bad");
        assertEquals("pretty bad", rating.getText());
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rating.getMovie());
    }

    @Test
    public void setMovie() {
        Movie movie2 = new Movie("Dark Knight", 2f);
        rating.setMovie(movie2);
        assertEquals(movie2, rating.getMovie());
    }

    @Test
    public void getFirstName() {
        Assert.assertEquals("Stelios", rating.getFirstName());
    }

    @Test
    public void setFirstName() {
        rating.setFirstName("Themis");
        Assert.assertEquals("Themis", rating.getFirstName());
    }

    @Test
    public void getLastName() {
        Assert.assertEquals("Pantelopoulos", rating.getLastName());
    }

    @Test
    public void setLastName() {
        rating.setLastName("Apostolopoulos");
        Assert.assertEquals("Apostolopoulos", rating.getLastName());
    }
}