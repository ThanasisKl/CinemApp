package com.example.cinemaapp.view.customer.rating.addRatings.addRating.premium;

import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.RatingsDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.Rating;

public class AddRatingPremiumPresenter {

    private AddRatingPremiumView view;
    private UserDAOMemory users;
    private RatingsDAOMemory ratings;
    private MovieDAOMemory movies;

    public AddRatingPremiumPresenter(AddRatingPremiumView view, UserDAOMemory users, RatingsDAOMemory ratings, MovieDAOMemory movies) {
        this.view = view;
        this.users = users;
        this.ratings = ratings;
        this.movies = movies;
    }

    public void addRating() {
        String firstName = users.find(view.getEmail()).getFirstName();
        String lastName = users.find(view.getEmail()).getLastName();
        Movie movie = movies.find(view.getMovieTitle());
        Rating rating = new Rating(view.getRating(), view.getComments(), firstName, lastName, movie);
        ratings.save(rating);
        movie.addRating(rating);

        view.onMainAddRating();
    }
}
