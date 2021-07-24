package com.example.cinemaapp.dao.daostub;

import com.example.cinemaapp.model.Reservation;

import java.util.ArrayList;

public interface ReservationDAO {

    /**
     //The method that saves reservations to the database
     * @param reservation
     */
    void save(Reservation reservation);

    /**
     * The method that removes reservations from a database
     * @param reservationId
     */
    void delete(int reservationId);

    /**
     * The method that removes reservations from a database
     * @param reservation
     */
    void update(Reservation reservation);

    /**
     * The method that finds reservations by
     * @param reservationId
     * @return user or null
     */
    Reservation find(int reservationId);

    /**
     * The method that returns all users
     * @return all reservations or null
     */
    ArrayList<Reservation> listReservations();

}
