package com.example.cinemaapp.view.owner.addStaff;


public class AddStaffViewStub implements  AddStaffView{

    private int ownerMainClicks;

    private AddStaffPresenter presenter;

    private String email, password, firstName, lastName, movieTheater, message;

    public void setPresenter(AddStaffPresenter presenter) {
        this.presenter = presenter;
    }

    public void onOwnerMain() {
        ownerMainClicks++;
    }

    public void showMessage(String message) {
        this.message = message;
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

    public String getMovieTheater() {
        return movieTheater;
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

    public void setMovieTheater(String movieTheater) {
        this.movieTheater = movieTheater;
    }
}