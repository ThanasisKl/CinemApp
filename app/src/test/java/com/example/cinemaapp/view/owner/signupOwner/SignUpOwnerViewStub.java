package com.example.cinemaapp.view.owner.signupOwner;


public class SignUpOwnerViewStub implements SignUpOwnerView{

    private int ownerMainClicks;

    private SignUpOwnerPresenter presenter;

    private String email, password, firstName, lastName, AMKA, SSN, message;

    public SignUpOwnerPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignUpOwnerPresenter presenter) {
        this.presenter = presenter;
    }

    public int getOwnerMainClicks() {
        return ownerMainClicks;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAMKA() {
        return AMKA;
    }

    public String getSSN() {
        return SSN;
    }

    public String getMessage() {
        return message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public void onOwnerMain() {
        ownerMainClicks++;
    }

    @Override
    public void showMessage(String message) {
        this.message = message;
    }
}