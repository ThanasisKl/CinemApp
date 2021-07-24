package com.example.cinemaapp.view.customer.mainActivity;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;

public class CustomerMainPresenter {


    private CustomerMainView view;
    private UserDAOMemory users;

    public CustomerMainPresenter(CustomerMainView view, UserDAOMemory users) {
        this.view = view;
        this.users = users;
    }

    public void bookTickets() {
        view.onBookTicket();
    }

    public void makeReview() {
        view.onMakeReview();
    }

    public String getFirstName() {
        return users.find(view.getEmail()).getFirstName();
    }
}
