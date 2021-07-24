package com.example.cinemaapp.view.customer.rating.mainRating;

public class MainRatingPresenter {

    private MainRatingView view;

    public MainRatingPresenter(MainRatingView view) {
        this.view = view;
    }

    public void addRatings() {
        view.onAddRatings();
    }

    public void readRatings() {
        view.onReadRatings();
    }
}
