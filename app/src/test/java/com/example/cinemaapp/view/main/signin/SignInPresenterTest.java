package com.example.cinemaapp.view.main.signin;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInPresenterTest {

    private SignInPresenter presenter;
    private SignInViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new SignInViewStub();
        presenter = new SignInPresenter(view, new UserDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     * This test checks if the user left any fields empty during his signIn
     */
    @Test
    public void testEmptyField() {
        view.setEmail("");
        presenter.signIn();
        Assert.assertEquals("Please complete all fields...", view.getMessage());
    }

    /**
     * This test checks if the user gave incorrect email during his signIn
     */
    @Test
    public void testIncorrectEmail() {
        view.setEmail("stelios");
        view.setPassword("password");
        presenter.signIn();
        Assert.assertEquals("Incorrect email...", view.getMessage());
    }

    /**
     * This test checks if the user gave incorrect password during his signIn
     */
    @Test
    public void testIncorrectPassword() {
        view.setEmail("stelios@gmail.com");
        view.setPassword("fail password");
        presenter.signIn();
        Assert.assertEquals("Incorrect password...", view.getMessage());
    }

    /**
     * This test checks if the main customer activity loads when all fields are correct and user is customer
     */
    @Test
    public void testSignInCustomer() {
        view.setEmail("stelios@gmail.com");
        view.setPassword("password");
        presenter.signIn();

        Assert.assertEquals(1, view.getCustomerMainClicks());
    }

    /**
     * This test checks if the main owner activity loads when all fields are correct and user is owner
     */
    @Test
    public void testSignInOwner() {
        view.setEmail("owner@aueb.gr");
        view.setPassword("password");
        presenter.signIn();

        Assert.assertEquals(1, view.getOwnerMainClicks());
    }

    /**
     * This test checks if the main staff activity loads when all fields are correct and user is staff
     */
    @Test
    public void testSignInStaff() {
        view.setEmail("stest2@gmail.com");
        view.setPassword("password");
        presenter.signIn();

        Assert.assertEquals(1, view.getStaffMainClicks());
    }
}