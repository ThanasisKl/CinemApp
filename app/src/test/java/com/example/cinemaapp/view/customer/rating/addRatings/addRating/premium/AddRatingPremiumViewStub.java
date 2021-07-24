package com.example.cinemaapp.view.customer.rating.addRatings.addRating.premium;

public class AddRatingPremiumViewStub implements AddRatingPremiumView{

    private AddRatingPremiumPresenter presenter;

    private int addRatingsMainClicks;

    private String movieTitle, email, comments;
    private float rating;

    public void setPresenter(AddRatingPremiumPresenter presenter) {
        this.presenter = presenter;
    }

    public int getAddRatingsMainClicks() {
        return addRatingsMainClicks;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public float getRating() {
        return rating;
    }

    public void onMainAddRating() {
        addRatingsMainClicks++;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}