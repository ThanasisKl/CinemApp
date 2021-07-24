package com.example.cinemaapp.view.owner.seeStatistics.individualMovie;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.Slot;

import java.util.ArrayList;

public class SeeStatisticsForIndividualMoviePresenter {

    private SeeStatisticsForIndividualMovieView view;
    private MovieTheaterDAOMemory movieTheaters;

    public SeeStatisticsForIndividualMoviePresenter(SeeStatisticsForIndividualMovieView view, MovieTheaterDAOMemory movieTheaters) {
        this.view = view;
        this.movieTheaters = movieTheaters;
    }

    public ArrayList<Integer> getTicketsSold() {
        String movieTitle = view.getMovieTitle();
        ArrayList<Integer> tickets = new ArrayList<>();


        for(int day=0; day<7; day++){

            int numberOfTickets = 0;
            for(MovieTheater movieTheater : movieTheaters.listMovieTheaters()){
                for(Slot slot: movieTheater.getDailySchedules().get(day).getSlots()){
                    if(slot.getMovie() != null){
                        if(slot.getMovie().getTitle().equals(movieTitle)){
                            numberOfTickets += slot.getAuditorium().getCapacity() - slot.getAvailable() - slot.getAvailablePremium();
                        }
                    }
                }
            }
            tickets.add(numberOfTickets);
        }
        int sumNumberOfTickets = 0;
        for(Integer numberOfTicketsForDay: tickets){
            sumNumberOfTickets += numberOfTicketsForDay;
        }
        tickets.add(sumNumberOfTickets);
        return tickets;
    }
}
