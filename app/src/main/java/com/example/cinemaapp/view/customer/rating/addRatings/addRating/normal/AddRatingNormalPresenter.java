package com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.RatingsDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Rating;

public class AddRatingNormalPresenter {

    private AddRatingNormalView view;
    private UserDAOMemory users;
    private RatingsDAOMemory ratings;
    private MovieDAOMemory movies;
    private String firstName, lastName;
    private Movie movie;
    private Rating rating;

    public AddRatingNormalPresenter(AddRatingNormalView view, UserDAOMemory users, RatingsDAOMemory ratings, MovieDAOMemory movies) {
        this.view = view;
        this.users = users;
        this.ratings = ratings;
        this.movies = movies;
    }

    public void addRating() {
        firstName = users.find(view.getEmail()).getFirstName();
        lastName = users.find(view.getEmail()).getLastName();
        movie = movies.find(view.getMovieTitle());
        rating = new Rating(view.getRating(), null, firstName, lastName, movie);
        ratings.save(rating);
        movie.addRating(rating);

        view.onMainAddRating();
    }
}
