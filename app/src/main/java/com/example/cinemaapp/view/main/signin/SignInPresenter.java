package com.example.cinemaapp.view.main.signin;

import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.Owner;
import com.example.cinemaapp.model.Staff;
import com.example.cinemaapp.model.User;

public class SignInPresenter {

    private SignInView view;
    private UserDAOMemory users;
    private String email, password;

    SignInPresenter(SignInView view, UserDAOMemory users){
        this.view = view;
        this.users = users;
    }

    public void signIn() {
        email = view.getEmail();
        password = view.getPassword();

        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields...");
        }else if(!checkIfEmailExists()){
            view.showMessage("Incorrect email...");
        }else if(!checkIfPasswordCorrect()){
            view.showMessage("Incorrect password...");
        }else{
            view.showMessage("Welcome Back!");
            User user = users.find(view.getEmail());
            if(user instanceof Staff){
                view.onStaffMain();
            }else if(user instanceof Customer){
                view.onCustomerMain();
            }else if(user instanceof Owner){
                view.onOwnerMain();
            }
        }
    }

    private boolean checkForEmptyFields() {
        return email.isEmpty() || password.isEmpty();
    }

    private boolean checkIfEmailExists(){
        if(users.find(email) != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkIfPasswordCorrect() {
        if(users.find(email).getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
