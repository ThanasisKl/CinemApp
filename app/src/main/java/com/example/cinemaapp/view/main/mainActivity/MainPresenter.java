package com.example.cinemaapp.view.main.mainActivity;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void signIn() {
        view.onSignIn();
    }

    public void signUp() {
        view.onSignUp();
    }
}
