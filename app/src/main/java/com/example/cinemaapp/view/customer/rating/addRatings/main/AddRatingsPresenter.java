package com.example.cinemaapp.view.customer.rating.addRatings.main;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.TypeOfUser;

public class AddRatingsPresenter {

    private AddRatingsView view;
    private UserDAOMemory users;

    public AddRatingsPresenter(AddRatingsView view, UserDAOMemory users) {
        this.view = view;
        this.users = users;
    }

    public TypeOfUser findTypeOfUser() {
        return ((Customer) users.find(view.getEmail())).getTypeOfUser();
    }
}
