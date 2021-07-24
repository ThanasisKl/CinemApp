package com.example.cinemaapp.view.staff.selectMovie;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

public class StaffSelectMoviePresenter {

    private StaffSelectMovieView view;
    private UserDAOMemory users;

    public StaffSelectMoviePresenter(StaffSelectMovieView view, UserDAOMemory users) {
        this.view = view;
        this.users = users;
    }

    public String findMovieTheater() {
        return users.findStaff(view.getEmail()).getMovieTheater().getName();
    }
}
