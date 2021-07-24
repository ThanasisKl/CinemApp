package com.example.cinemaapp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationTest {


    private Reservation reservation;
    private Reservation reservation2;
    private Customer customer;
    private Slot slot;
    private Auditorium auditorium;
    private static int count =1;


    @Before
    public void setUp() throws Exception {
        customer = new Customer("p3180013@aueb.gr", "password123", "nikos", "papadopoulos");
        auditorium = new Auditorium(14, 5);
        slot = new Slot(6, new Movie("Harry Potter", 3f), auditorium);
        reservation = new Reservation(customer, 5, slot, "34567");
        reservation2 = new Reservation(customer, 7, slot, "3456780");
        count = count + 2;

    }

    @Test
    public void testGetId() {
        Assert.assertEquals(-1, reservation.getId());
    }

    @Test
    public void testSetId() {
        reservation.setId(100);
        Assert.assertEquals(100, reservation.getId());
    }

    @Test
    public void getNumOfSeats() {
        assertEquals(5, reservation.getNumOfSeats());
    }

    @Test
    public void setNumOfSeats() {
        reservation.setNumOfSeats(4);
        assertEquals(4, reservation.getNumOfSeats());
    }

    @Test
    public void getCustomerEmail() {
        assertEquals("p3180013@aueb.gr", reservation.getCustomerEmail());
    }

    @Test
    public void setCustomerEmail() {
        reservation.setCustomerEmail("p318@aueb.gr");
        assertEquals("p318@aueb.gr", reservation.getCustomerEmail());
    }

    @Test
    public void setSlot() {
        reservation.setSlot(null);
        assertNull(reservation.getSlot());
    }

    @Test
    public void getSlot() {
        assertEquals(slot,reservation.getSlot());
    }

    @Test
    public void getPayment() {
        assertEquals(300.f,reservation.getPayment(),300.f);
    }

    @Test
    public void setCustomer() {
        reservation.setCustomer(null);
        assertNull(reservation.getCustomer());
    }

    @Test
    public void getCustomer() {
        assertEquals(customer,reservation.getCustomer());
    }
}

