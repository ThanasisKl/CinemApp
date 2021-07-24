package com.example.cinemaapp.view.owner.seeStatistics.individualMovie;


import java.util.ArrayList;

public class SeeStatisticsForIndividualMovieViewStub implements  SeeStatisticsForIndividualMovieView{

    private SeeStatisticsForIndividualMoviePresenter presenter;

    private String movieTitle;
    private ArrayList<Integer> ticketsSold;

    public void setPresenter(SeeStatisticsForIndividualMoviePresenter presenter) {
        this.presenter = presenter;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public ArrayList<Integer> getTicketsSold() {
        return ticketsSold;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setTicketsSold(ArrayList<Integer> ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
}