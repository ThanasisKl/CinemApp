package com.example.cinemaapp.dao.daostub;

import com.example.cinemaapp.model.Payment;

import java.util.ArrayList;

public interface PaymentDAO {

    /**
     * Method that stores a payment to the dao
     * @param payment
     */
    void save(Payment payment);

    /**
     * Method that finds a payment
     * @param amount
     * @param creditCardNumber
     * @return
     */
    Payment find(int amount, String creditCardNumber);

    /**
     * Method that returns the list of payments
     * @return
     */
    ArrayList<Payment> list();
}
