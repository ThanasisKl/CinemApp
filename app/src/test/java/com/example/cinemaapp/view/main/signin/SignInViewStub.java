package com.example.cinemaapp.view.main.signin;

import com.example.cinemaapp.view.main.signup.SignUpPresenter;
import com.example.cinemaapp.view.main.signup.SignUpView;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignInViewStub implements SignInView{

    private int staffMainClicks,
                customerMainClicks,
                ownerMainClicks;

    private String email, password, message;

    private SignInPresenter presenter;

    public SignInPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignInPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessage(String message) {
        this.message = message;
    }

    public void onStaffMain() {
        staffMainClicks++;
    }

    public void onCustomerMain() {
        customerMainClicks++;
    }

    public void onOwnerMain() {
        ownerMainClicks++;
    }

    public int getStaffMainClicks() {
        return staffMainClicks;
    }

    public int getCustomerMainClicks() {
        return customerMainClicks;
    }

    public int getOwnerMainClicks() {
        return ownerMainClicks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }
}