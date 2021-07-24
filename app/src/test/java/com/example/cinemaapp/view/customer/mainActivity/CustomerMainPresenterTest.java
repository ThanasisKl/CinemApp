package com.example.cinemaapp.view.customer.mainActivity;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMainPresenterTest {

    private CustomerMainPresenter presenter;
    private CustomerMainViewStub view;

    private UserDAOMemory userDao;
    private MemoryInitialiser initialiser;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();
        userDao = new UserDAOMemory();

        view = new CustomerMainViewStub();
        presenter = new CustomerMainPresenter(view, userDao);
        view.setPresenter(presenter);
    }

    /**
     * Test for button BookTickets in CustomerMainActivity
     */
    @Test
    public void testBookTickets() {
        for(int i = 0; i < 10; i++) {
            presenter.bookTickets();
        }

        Assert.assertEquals(10, view.getBookTicketClicks());
    }

    /**
     * Test for button MakeReview in CustomerMainActivity
     */
    @Test
    public void testMakeReview() {
        for(int i = 0; i < 10; i++) {
            presenter.makeReview();
        }

        Assert.assertEquals(10, view.getMakeReviewClicks());
    }

    @Test
    public void getFirstName() {
    }
}