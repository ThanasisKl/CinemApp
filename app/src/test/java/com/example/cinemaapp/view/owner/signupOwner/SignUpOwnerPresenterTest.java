package com.example.cinemaapp.view.owner.signupOwner;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SignUpOwnerPresenterTest {

    private SignUpOwnerPresenter presenter;
    private SignUpOwnerViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new SignUpOwnerViewStub();
        presenter = new SignUpOwnerPresenter(view, new UserDAOMemory());
        view.setPresenter(presenter);
    }


    /**
     * This test checks if the owner left any fields empty during his signUp
     */
    @Test
    public void testEmptyField() {
        view.setEmail("");
        presenter.signUpOwner();
        Assert.assertEquals("Please complete all fields...", view.getMessage());
    }

    /**
     * This test checks if the owner gave email that exists in the database during his signUp
     */
    @Test
    public void testEmailExists() {
        view.setEmail("owner@aueb.gr");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setAMKA("1234567890");
        view.setSSN("mySSN123");
        presenter.signUpOwner();
        Assert.assertEquals("Email already used...", view.getMessage());
    }

    /**
     * This test checks if the owner gave wrong format of email (___@___.___) during his signUp
     */
    @Test
    public void testWrongFormatOfEmail() {
        view.setEmail("ownerNew");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setAMKA("1234567890");
        view.setSSN("mySSN123");
        presenter.signUpOwner();
        Assert.assertEquals("Wrong format for email...", view.getMessage());
    }

    /**
     * This test checks if the owner gave wrong format of AMKA (10 digits number) during his signUp
     */
    @Test
    public void testWrongFormatOfAMKA() {
        view.setEmail("ownerNew@aueb.gr");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setAMKA("1");
        view.setSSN("mySSN123");
        presenter.signUpOwner();
        Assert.assertEquals("Wrong AMKA...", view.getMessage());
    }

    /**
     * This test checks if the main owner activity loads when all fields are correct
     */
    @Test
    public void testSuccessfulSignUp() {
        view.setEmail("ownerNew@aueb.gr");
        view.setPassword("password");
        view.setFirstName("George");
        view.setLastName("Papatzis");
        view.setAMKA("1234567890");
        view.setSSN("mySSN123");
        presenter.signUpOwner();
        Assert.assertEquals("Successfull Sign up, Welcome!", view.getMessage());

        Assert.assertEquals(1, view.getOwnerMainClicks());
    }
}