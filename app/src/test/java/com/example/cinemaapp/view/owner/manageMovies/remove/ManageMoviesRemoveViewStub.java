package com.example.cinemaapp.view.owner.manageMovies.remove;


public class ManageMoviesRemoveViewStub implements ManageMoviesRemoveView {

    private int removeMovieClicks;

    private ManageMoviesRemovePresenter presenter;

    private String movieTitle;

    public void setPresenter(ManageMoviesRemovePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onRemoveMovie(String movieTitle) {

    }

    @Override
    public void showMessage(String Message) {

    }

    @Override
    public String getMovieTitle() {
        removeMovieClicks++;
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRemoveMovieClicks() {
        return removeMovieClicks;
    }
}