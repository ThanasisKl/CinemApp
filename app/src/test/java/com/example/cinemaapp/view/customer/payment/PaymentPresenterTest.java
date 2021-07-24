package com.example.cinemaapp.view.customer.payment;

import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.PaymentDAOMemory;
import com.example.cinemaapp.dao.memorydao.ReservationDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.util.Slot_Day;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentPresenterTest {

    private PaymentPresenter presenter;
    private PaymentViewStub view;
    private MemoryInitialiser initialiser;
    private Slot slot;
    private Movie movie;
    private Auditorium auditorium;
    private PaymentDAOMemory payments;

    @Before
    public void setUp() throws Exception {
        initialiser = new MemoryInitialiser();
        initialiser.prepareData();

        view = new PaymentViewStub();
        presenter = new PaymentPresenter(view, new PaymentDAOMemory(), new UserDAOMemory(), new ReservationDAOMemory(), new MovieTheaterDAOMemory());
        view.setPresenter(presenter);

        payments = new PaymentDAOMemory();
    }


    /**
     * This test checks if payment is completed for a premium user
     */
    @Test
    public void testPaymentForPremium() {
        view.setAmount(50);
        view.setCreditCardNumber("creditcardPremium");
        presenter.executePaymentSignUp();

        Assert.assertEquals(1, view.getCustomerMainClicks());
    }

    /**
     * This test checks if a payment is saved well in DAO
     */
    @Test
    public void testPaymentForBooking() {
        view.setAmount(60);
        view.setCreditCardNumber("creditcardBooking");
        view.setEmail("iasonas@gmail.com");
        view.setMovieTheaterName("Village");
        view.setSeats(2);
        Slot_Day slot_day = new Slot_Day(new MovieTheaterDAOMemory().find("Village").getDailySchedules().get(0).getSlots().get(0), Day.MONDAY);
        view.setSlot_day(slot_day);

        presenter.executePaymentBookSeats();
        Assert.assertEquals(60, payments.find(60,"creditcardBooking").getAmount(), 0f);
        Assert.assertEquals("creditcardBooking", payments.find(60,"creditcardBooking").getCardNum());
    }
}