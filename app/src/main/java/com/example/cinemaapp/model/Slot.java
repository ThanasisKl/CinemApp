package com.example.cinemaapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Slot implements Serializable {

    private int start;
    private Movie movie;
    private Auditorium auditorium;
    private int available;
    private int availablePremium;
    private Boolean[] seats = new Boolean[30]; // we have 30 seats

    public Slot(int start, Movie movie, Auditorium auditorium) {
        this.start = start;
        this.movie = movie;
        this.auditorium = auditorium;
        this.available = auditorium.getCapacity() - 10; //seats available for not normal users
        this.availablePremium = 10; //10 seats are reserved for premium users
        for(int i =0; i<30; i++){
            seats[i] = true;
        }
    }



    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailablePremium() {
        return availablePremium;
    }

    public void setAvailablePremium(int availablePremium) {
        this.availablePremium = availablePremium;
    }

    public void reserveSeats(int numOfSeats, TypeOfUser typeOfUser) {
        if(typeOfUser == TypeOfUser.NORMAL){
            available-= numOfSeats;
        }else{
            if(availablePremium >= numOfSeats) {
                availablePremium -= numOfSeats;
            }else{
                int x = numOfSeats - availablePremium;
                availablePremium = 0;
                available = available - x;
            }
        }
    }
}
