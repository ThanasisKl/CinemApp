package com.example.cinemaapp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new Customer("p3180079@aueb.gr","password1234","Iason","Papadopoulos");
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(-1, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId(100);
        Assert.assertEquals(100, user.getId());
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals("p3180079@aueb.gr", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("p31800@aueb.gr");
        Assert.assertEquals("p31800@aueb.gr", user.getEmail());
    }

    @Test
    public void testGetPassword() {
        Assert.assertEquals("password1234", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("password12");
        Assert.assertEquals("password12", user.getPassword());
    }

    @Test
    public void testGetFirstName() {
        Assert.assertEquals("Iason", user.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        user.setFirstName("Iasonas");
        Assert.assertEquals("Iasonas", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Assert.assertEquals("Papadopoulos", user.getLastName());
    }

    @Test
    public void testSetLastName() {
        user.setLastName("Papas");
        Assert.assertEquals("Papas", user.getLastName());
    }

}
