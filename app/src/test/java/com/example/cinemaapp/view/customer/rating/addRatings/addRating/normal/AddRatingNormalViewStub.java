package com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal;

public class AddRatingNormalViewStub implements AddRatingNormalView{

    private int mainRatingClicks;

    private AddRatingNormalPresenter presenter;

    private String movieTitle, email;
    private float rating;


    public void setPresenter(AddRatingNormalPresenter presenter) {
        this.presenter = presenter;
    }

    public int getMainRatingClicks() {
        return mainRatingClicks;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getEmail() {
        return email;
    }

    public float getRating() {
        return rating;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void onMainAddRating() {
        mainRatingClicks++;
    }
}