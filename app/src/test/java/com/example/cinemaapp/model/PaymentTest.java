package com.example.cinemaapp.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PaymentTest {

    private Payment payment;
    @Before
    public void setUp() throws Exception {
       payment = new Payment(10f,"2310" );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(-1, payment.getId());
    }

    @Test
    public void testSetId() {
        payment.setId(100);
        Assert.assertEquals(100, payment.getId());
    }

    @Test
    public void getAmount() {
        assertEquals(10f, payment.getAmount(), 10f);
    }

    @Test
    public void setAmount() {
        payment.setAmount(15f);
        assertEquals(15f, payment.getAmount(), 15f);

    }

    @Test
    public void getCardNum() {
        assertEquals("2310", payment.getCardNum());
    }

    @Test
    public void setCardNum() {
        payment.setCardNum("210");
        assertEquals("210", payment.getCardNum());
    }
}

