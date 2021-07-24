package com.example.cinemaapp.view.staff.mainActivity;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

public class StaffMainPresenter {

    private StaffMainView view;
    private UserDAOMemory users;

    StaffMainPresenter(StaffMainView view, UserDAOMemory users){
        this.view = view;
        this.users = users;
    }

    public void addMovie() {
        view.onSelectMovie();
    }

    public void ClearProgram() {
        view.onClearProgram();
    }

    public String findMovieTheater() {
        return users.findStaff(view.getEmail()).getMovieTheater().getName();
    }

    public String getFirstName() {
        return users.find(view.getEmail()).getFirstName();
    }
}
