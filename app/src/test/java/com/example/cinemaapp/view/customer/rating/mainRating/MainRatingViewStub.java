package com.example.cinemaapp.view.customer.rating.mainRating;


public class MainRatingViewStub implements MainRatingView{

    private int addRatingsClicks,
                readRatingsClicks;

    private MainRatingPresenter presenter;

    public MainRatingPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainRatingPresenter presenter) {
        this.presenter = presenter;
    }

    public void onAddRatings() {
        addRatingsClicks++;
    }

    public void onReadRatings() {
        readRatingsClicks++;
    }

    public int getAddRatingsClicks() {
        return addRatingsClicks;
    }

    public int getReadRatingsClicks() {
        return readRatingsClicks;
    }
}