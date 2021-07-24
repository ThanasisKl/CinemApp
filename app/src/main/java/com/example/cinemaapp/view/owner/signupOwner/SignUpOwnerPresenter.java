package com.example.cinemaapp.view.owner.signupOwner;

import com.example.cinemaapp.dao.daostub.UserDAO;
import com.example.cinemaapp.model.Owner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpOwnerPresenter {

    private SignUpOwnerView view;
    private UserDAO users;
    private Owner owner;
    private String email, password, firstName, lastName, SSN, AMKA;

    SignUpOwnerPresenter(SignUpOwnerView view, UserDAO users){
        this.view = view;
        this.users = users;
    }

    public void signUpOwner() {
        email = view.getEmail();
        password = view.getPassword();
        firstName = view.getFirstName();
        lastName = view.getLastName();
        SSN = view.getSSN();
        AMKA = view.getAMKA();

        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields...");
        }else if(checkIfEmailExists()){
            view.showMessage("Email already used...");
        }else if (!checkIfEmailValid()){
            view.showMessage("Wrong format for email...");
        }
        else if(AMKA.length() != 10){
            view.showMessage("Wrong AMKA...");
        }
        else{
            owner = new Owner(email, password, firstName, lastName, SSN, AMKA);
            users.save(owner);
            view.showMessage("Successfull Sign up, Welcome!");
            view.onOwnerMain();
        }
    }

    private boolean checkForEmptyFields() {
        return email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || SSN.isEmpty() || AMKA.isEmpty();
    }

    private boolean checkIfEmailExists(){
        if(users.find(email) != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkIfEmailValid(){
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher Checker = pattern.matcher(email);
        if(Checker.matches()){
            return true;
        }else{
            return false;
        }
    }
}
