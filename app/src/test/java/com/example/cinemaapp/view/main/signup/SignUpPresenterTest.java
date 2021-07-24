package com.example.cinemaapp.view.main.signup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SignUpPresenterTest {

    private SignUpPresenter presenter;
    private SignUpViewStub view;

    @Before
    public void setUp() throws Exception {
        view = new SignUpViewStub();
        presenter = new SignUpPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Test for button SignUpOwner in SignUpActivity
     */
    @Test
    public void testSignUpOwner() {
        for(int i = 0; i < 10; i++) {
            presenter.signUpOwner();
        }

        Assert.assertEquals(10, view.getSignUpOwnerClicks());
    }

    /**
     * Test for button SignUpCustomer in SignUpActivity
     */
    @Test
    public void testSignUpCustomer() {
        for(int i = 0; i < 10; i++) {
            presenter.signUpCustomer();
        }

        Assert.assertEquals(10, view.getSignUpCustomerClicks());
    }
}