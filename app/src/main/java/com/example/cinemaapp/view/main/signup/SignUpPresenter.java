package com.example.cinemaapp.view.main.signup;

public class SignUpPresenter {

    private  SignUpView view;

    SignUpPresenter(SignUpView view){
        this.view = view;
    }

    public void signUpOwner() {
        view.onSignUpOwner();
    }

    public void signUpCustomer() {
        view.onSignUpCustomer();
    }
}
