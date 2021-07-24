package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.Initialiser;
import com.example.cinemaapp.dao.daostub.MovieDAO;
import com.example.cinemaapp.dao.daostub.MovieTheaterDAO;
import com.example.cinemaapp.dao.daostub.RatingsDAO;
import com.example.cinemaapp.dao.daostub.ReservationDAO;
import com.example.cinemaapp.dao.daostub.UserDAO;

public class MemoryInitialiser extends Initialiser {
    @Override
    public void eraseAllData() {
        UserDAOMemory.usersList.clear();
        UserDAOMemory.autoIncrementId = 0;
        MovieDAOMemory.movieList.clear();
        MovieDAOMemory.autoIncrementId = 0;
        MovieTheaterDAOMemory.movieTheaterList.clear();
        MovieTheaterDAOMemory.autoIncrementId = 0;
        ReservationDAOMemory.reservationList.clear();
        ReservationDAOMemory.autoIncrementId = 0;
        RatingsDAOMemory.ratingsList.clear();
        RatingsDAOMemory.autoIncrementId = 0;
        PaymentDAOMemory.paymentsList.clear();
        PaymentDAOMemory.autoIncrementId = 0;
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMemory();
    }

    @Override
    public MovieDAO getMovieDAO() {
        return new MovieDAOMemory();
    }

    @Override
    public MovieTheaterDAO getMovieTheaterDAO() {
        return new MovieTheaterDAOMemory();
    }

    @Override
    public ReservationDAO getReservationDAO() {
        return new ReservationDAOMemory();
    }

    @Override
    public RatingsDAO getRatingsDAO() {
        return new RatingsDAOMemory();
    }
}
