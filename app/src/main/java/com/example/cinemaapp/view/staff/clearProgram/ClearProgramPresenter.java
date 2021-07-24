package com.example.cinemaapp.view.staff.clearProgram;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Slot;

import java.util.ArrayList;

public class ClearProgramPresenter {

    private ClearProgramView view;
    private UserDAOMemory users;
    private MovieTheaterDAOMemory movieTheaters;

    public ClearProgramPresenter(ClearProgramView view, UserDAOMemory users, MovieTheaterDAOMemory movieTheaters) {
        this.view = view;
        this.users = users;
        this.movieTheaters = movieTheaters;
    }

    public String findMovieTheater() {
        return users.findStaff(view.getEmail()).getMovieTheater().getName();
    }

    public void clearMovieSlot() {
        ArrayList<Slot> slots = movieTheaters.find(view.getMovieTheaterName()).getDailySchedules().get(view.getDay()).getSlots();
        for(Slot slot: slots){
            if(slot.getStart() == view.getStart() && slot.getAuditorium().getId() == view.getAuditorium().getId()){
                slot.setMovie(null);
                view.showMessage("Movie deleted!");
            }
        }
    }
}
