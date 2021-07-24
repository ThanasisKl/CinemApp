package com.example.cinemaapp.view.main.mainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainPresenterTest {

    private MainPresenter presenter;
    private MainViewStub view;

    @Before
    public void setUp() throws Exception {
        view = new MainViewStub();
        presenter = new MainPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Test for button SignUp in MainActivity
     */
    @Test
    public void testSignUp() {
        for(int i = 0; i < 10; i++) {
            presenter.signUp();
        }

        Assert.assertEquals(10, view.getSignUpClicks());
    }

    /**
     * Test for button SignIn in MainActivity
     */
    @Test
    public void testSignIn() {
        for(int i = 0; i < 10; i++) {
            presenter.signIn();
        }

        Assert.assertEquals(10, view.getSignInClicks());
    }
}