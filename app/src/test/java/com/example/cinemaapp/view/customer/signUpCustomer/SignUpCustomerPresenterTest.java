package com.example.cinemaapp.view.customer.signUpCustomer;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.view.owner.signupOwner.SignUpOwnerPresenter;
import com.example.cinemaapp.view.owner.signupOwner.SignUpOwnerViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpCustomerPresenterTest {
    
    private SignUpCustomerPresenter presenter;
    private SignUpCustomerViewStub view;

    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new SignUpCustomerViewStub();
        presenter = new SignUpCustomerPresenter(view, new UserDAOMemory());
        view.setPresenter(presenter);
    }

    /**
     *This test checks if the customer left any fields empty during his signUp
     */
    @Test
    public void testEmptyField() {
        view.setEmail("");
        presenter.signUpCustomer();

        Assert.assertEquals(view.getMessage(), "Please complete all fields...");
    }

    /**
     * This test checks if the customer gave email that exists in the database during his signUp
     */
    @Test
    public void testEmailExists() {
        view.setEmail("thanasis@gmail.com");
        view.setPassword("pasword");
        view.setFirstName("Thanasis");
        view.setLastName("Klettas");
        presenter.setTypeCustomer(TypeOfUser.NORMAL);
        presenter.signUpCustomer();

        Assert.assertEquals(view.getMessage(), "Email already used...");
    }

    /**
     * This test checks if the main customer activity loads when all fields are correct and customer is normal
     */
    @Test
    public void testSuccessfulSignUpNormal() {
        view.setEmail("newNormalUserNormal@gmail.com");
        view.setPassword("pasword");
        view.setFirstName("Thanasis");
        view.setLastName("Klettas");
        presenter.setTypeCustomer(TypeOfUser.NORMAL);
        presenter.signUpCustomer();

        Assert.assertEquals(1, view.getCustomerMainClicks());
    }

    /**
     * This test checks if the payment activity loads when all fields are correct and customer is premium
     */
    @Test
    public void testSuccessfulSignUpPremium() {
        view.setEmail("newNormalUserPremium@gmail.com");
        view.setPassword("pasword");
        view.setFirstName("Thanasis");
        view.setLastName("Klettas");
        presenter.setTypeCustomer(TypeOfUser.PREMIUM);
        presenter.signUpCustomer();

        Assert.assertEquals(1, view.getPaymentClicks());
    }
}