package com.example.cinemaapp.view.customer.selectMovieTheater;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

public class CustomerSelectMovieTheaterPresenter {
    private CustomerSelectMovieTheaterActivity view;
    private MovieTheaterDAOMemory movieTheater;

    CustomerSelectMovieTheaterPresenter(CustomerSelectMovieTheaterActivity view, MovieTheaterDAOMemory dao){
        this.view = view;
        this.movieTheater = dao;
    }
}
