package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Movie slotMovie = new Movie("Iron man", 2f);
    private Customer customer;
    private Auditorium auditorium;
    private Auditorium auditorium2;
    private Auditorium auditorium3;
    private Auditorium auditorium4;
    private Auditorium auditorium5;
    private ArrayList<Auditorium> auditoriums = new ArrayList<>();
    private ArrayList<Auditorium> auditoriums2 = new ArrayList<>();
    private MovieTheater movieTheater;
    private MovieTheater movieTheater2;
    private Slot slot;
    private Slot slot2;
    private Slot slot3;
    private Slot slot4;
    private Slot slot5;
    private ArrayList<Slot> slots = new ArrayList();
    private ArrayList<Slot> slots2 = new ArrayList();
    private Boolean[] seats = new Boolean[30];
    private Boolean[] seats2 = new Boolean[30];
    private Boolean[] seats3 = new Boolean[30];
    private DailySchedule dailySchedule;
    private DailySchedule dailySchedule2;
    private ArrayList<MovieTheater> movieTheaters = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        customer = new Customer("p318@aueb.gr", "ivangreko", "Ivan", "Greko");
        for(int i=0; i<30; i++){
            seats[i]=true;
            seats2[i]=true;
            seats3[i]=true;
        }
        auditorium = new Auditorium(1, 30);
        auditoriums.add(auditorium);
        auditorium2 = new Auditorium(2, 30);
        auditoriums.add(auditorium2);
        auditorium3 = new Auditorium(3, 30);
        auditoriums2.add(auditorium3);
        slot = new Slot(2,slotMovie,auditorium);
        slot2 = new Slot(4, slotMovie, auditorium);
        slot3 = new Slot(4, new Movie("Interstellar", 2f), auditorium2);
        slot4 = new Slot(6, slotMovie, auditorium3);
        slot5 = new Slot(8, new Movie("Knives out", 2f), auditorium3);
        slots.add(slot);
        slots.add(slot2);
        slots.add(slot3);
        slots2.add(slot4);
        slots2.add(slot5);
        Day myday = Day.SATURDAY;
//        dailySchedule = new DailySchedule(myday,slots);
//        dailySchedule2 = new DailySchedule(myday, slots2);
        movieTheater = new MovieTheater("omniman", "napoli",  auditoriums);
        movieTheater2 = new MovieTheater("invincible", "gotham",  auditoriums2);
//        movieTheater.setDailySchedule(dailySchedule);
//        movieTheater2.setDailySchedule(dailySchedule2);
        movieTheaters.add(movieTheater);
        movieTheaters.add(movieTheater2);
    }

    @After
    public void tearDown() throws Exception {
    }





    @Test
    public void selectionOfType() {
        TypeOfUser type = TypeOfUser.PREMIUM;
        customer.setTypeOfUser(type);
        assertEquals(type, customer.getTypeOfUser());
        TypeOfUser type2 = TypeOfUser.NORMAL;
        customer.setTypeOfUser(type2);
        assertEquals("NORMAL", customer.getTypeOfUser().toString());
    }

    @Test
    public void testRatings(){
        Movie movie = new Movie("Pulp fiction", 2f);
        Movie movie2 = new Movie("Avengers", 2f);
        Rating rating = new Rating(4f,"pretty good", customer.getFirstName(), customer.getLastName(), movie);
        Rating rating2 = new Rating(1f,"pretty bad", customer.getFirstName(), customer.getFirstName(), movie2);
        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(rating);
        ratings.add(rating2);
        customer.setRatings(ratings);
        assertArrayEquals(ratings.toArray(), customer.getRatings().toArray());
        assertEquals(movie2.getTitle(), customer.getRatings().get(1).getMovie().getTitle());


    }
//
//    @Test
//    public void getSelectionOfType() {
//        TypeOfUser type = TypeOfUser.NORMAL;
//        TypeOfUser type2 = TypeOfUser.NORMAL;
//        customer.selectionOfType(type);
//        assertEquals(type2, customer.getSelectionOfType());
//
//    }
//
//    @Test
//    public void addRating() {
//        Movie movie = new Movie("Pulp fiction", 2f);
//        Rating rating = new Rating(3, "really good", movie);
//        assertEquals(rating.getMovie(), customer.addRating(movie, 3, "good").getMovie());
//        assertEquals(rating.getScore(), customer.addRating(movie, 3, "good").getScore());
//        assertNotEquals(rating.getText(), customer.addRating(movie, 3, "good").getText());
//    }
//
//    @Test
//    public void makeReservation() {
//      //  Day day = Day.SATURDAY;
//        Reservation reservationExpected = new Reservation(customer, 4, slot5, "318");
//        assertEquals(reservationExpected.getSlot(), customer.makeReservation(slot5, 4, "318").getSlot());
//        assertEquals(reservationExpected.getNumOfSeats(), customer.makeReservation(slot5, 4, "318").getNumOfSeats() );
//    }
}
