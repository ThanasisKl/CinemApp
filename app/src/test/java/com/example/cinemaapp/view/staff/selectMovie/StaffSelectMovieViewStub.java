package com.example.cinemaapp.view.staff.selectMovie;


import org.junit.Test;

public class StaffSelectMovieViewStub implements  StaffSelectMovieView{

    private int SelectMovieClicks;
    private StaffSelectMoviePresenter presenter;
    private String email;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StaffSelectMoviePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(StaffSelectMoviePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public String getMovieTheaterName() {
        return null;
    }


    public void onSelectMovie(String movieTitle) {
        SelectMovieClicks++;
    }

    public int getSelectMovieClicks(){return SelectMovieClicks;}

}