package com.example.cinemaapp.view.main.mainActivity;


public class MainViewStub implements MainView{

    private int signUpClicks,
                signInClicks;

    private MainPresenter presenter;

    public MainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void onSignUp() {
        signUpClicks++;
    }

    public void onSignIn() {
        signInClicks++;
    }

    public int getSignUpClicks() {
        return signUpClicks;
    }

    public int getSignInClicks() {
        return signInClicks;
    }
}