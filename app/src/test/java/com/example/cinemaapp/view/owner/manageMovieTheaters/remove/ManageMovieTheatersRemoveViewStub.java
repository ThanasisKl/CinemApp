package com.example.cinemaapp.view.owner.manageMovieTheaters.remove;

public class ManageMovieTheatersRemoveViewStub implements ManageMovieTheatersRemoveView{

    private int removeMovieTheaterClicks;

    private ManageMovieTheatersRemovePresenter presenter;

    private String movieTheaterName;

    public void setPresenter(ManageMovieTheatersRemovePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onRemoveMovieTheater(String movieTheaterName) {

    }

    @Override
    public String getMovieTheaterName() {
        removeMovieTheaterClicks++;
        return movieTheaterName;
    }

    public void setMovieTheaterName(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
    }

    public int getRemoveMovieTheaterClicks() {
        return removeMovieTheaterClicks;
    }
}