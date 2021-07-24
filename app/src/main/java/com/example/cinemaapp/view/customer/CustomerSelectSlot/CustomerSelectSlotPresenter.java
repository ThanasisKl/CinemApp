package com.example.cinemaapp.view.customer.CustomerSelectSlot;

import android.util.Log;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.util.Slot_Day;

import java.util.ArrayList;

public class CustomerSelectSlotPresenter {

    CustomerSelectSlotView view;
    MovieTheaterDAOMemory movieTheaters;

    public CustomerSelectSlotPresenter(CustomerSelectSlotView view, MovieTheaterDAOMemory movieTheaters) {
        this.view = view;
        this.movieTheaters = movieTheaters;
    }

    public ArrayList<Slot_Day> findMovieSlots() {
        String movie_title = view.getMovieTitle();
        String movie_theater_name = view.getMovieTheaterTitle();
        Slot_Day slot_day;
        ArrayList<Slot_Day> slot_day_list = new ArrayList<>();
        for(int day=0; day<7; day++){

            for(MovieTheater movieTheater : movieTheaters.listMovieTheaters()){
                if(movieTheater.getName().equals(movie_theater_name)){
                    for(Slot slot: movieTheater.getDailySchedules().get(day).getSlots()){
                        if(slot.getMovie()!= null){
                            if(slot.getMovie().getTitle().equals(movie_title)){
                                Day movie_day;
                                if(day == 0){
                                    movie_day = Day.MONDAY;
                                }else if(day == 1){
                                    movie_day = Day.TUESDAY;
                                }else if(day == 2){
                                    movie_day = Day.WEDNESDAY;
                                }else if(day == 3){
                                    movie_day = Day.THURSDAY;
                                }else if(day == 4){
                                    movie_day = Day.FRIDAY;
                                }else if(day == 5){
                                    movie_day = Day.SATURDAY;
                                }else{
                                    movie_day = Day.SUNDAY;
                                }
                                slot_day = new Slot_Day(slot, movie_day);
                                slot_day_list.add(slot_day);
                            }
                        }
                    }
                }

            }

        }
        return slot_day_list;
    }
}
