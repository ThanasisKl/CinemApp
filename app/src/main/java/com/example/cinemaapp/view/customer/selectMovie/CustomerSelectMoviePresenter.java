package com.example.cinemaapp.view.customer.selectMovie;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;

public class CustomerSelectMoviePresenter {
    private CustomerSelectMovieActivity view;
    private MovieDAOMemory movies;

    CustomerSelectMoviePresenter(CustomerSelectMovieActivity view, MovieDAOMemory movies){
        this.view = view;
        this.movies = movies;
    }


}
