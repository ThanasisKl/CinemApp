package com.example.cinemaapp.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class regExpEmailTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isEmail() {
        String test = "p31800@aueb.gr";
        assertTrue(regExpEmail.isEmail(test));
        String test2 = "p3180013";
        assertFalse(regExpEmail.isEmail(test2));
    }
}