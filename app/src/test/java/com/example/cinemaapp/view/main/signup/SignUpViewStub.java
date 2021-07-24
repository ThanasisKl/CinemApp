package com.example.cinemaapp.view.main.signup;

import com.example.cinemaapp.view.main.signin.SignInView;

public class SignUpViewStub implements SignUpView {

    private int signUpOwnerClicks,
                signUpCustomerClicks;

    private SignUpPresenter presenter;

    public SignUpPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignUpPresenter presenter) {
        this.presenter = presenter;
    }

    public void onSignUpOwner() {
        signUpOwnerClicks++;
    }

    public void onSignUpCustomer() {
        signUpCustomerClicks++;
    }

    public int getSignUpOwnerClicks() {
        return signUpOwnerClicks;
    }

    public int getSignUpCustomerClicks() {
        return signUpCustomerClicks;
    }
}