package com.example.cinemaapp.view.owner.mainActivity;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

public class OwnerMainPresenter {

    private OwnerMainView view;
    private UserDAOMemory users;

    public OwnerMainPresenter(OwnerMainView view, UserDAOMemory users) {
        this.view = view;
        this.users = users;
    }

    public void addStaff() {
        view.onAddStaff();
    }

    public void manageMovies() {
        view.onManageMovies();
    }

    public void manageMovieTheaters() {
        view.onManageMovieTheaters();
    }

    public void seeStatistics() {
        view.onSeeStatistics();
    }

    public String getFirstName() {
        return users.find(view.getEmail()).getFirstName();
    }
}
