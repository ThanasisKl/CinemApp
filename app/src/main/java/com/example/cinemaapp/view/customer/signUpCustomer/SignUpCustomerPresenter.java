package com.example.cinemaapp.view.customer.signUpCustomer;

import com.example.cinemaapp.dao.daostub.UserDAO;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.TypeOfUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpCustomerPresenter {

    private SignUpCustomerView view;
    private UserDAO users;
    private Customer customer;
    private String email, password, firstName, lastName;
    private TypeOfUser typeOfUser;

    SignUpCustomerPresenter(SignUpCustomerView view, UserDAO users){
        this.view = view;
        this.users = users;
    }

    public void setTypeCustomer(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public void signUpCustomer() {
        email = view.getEmail();
        password = view.getPassword();
        firstName = view.getFirstName();
        lastName = view.getLastName();
        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields...");
        }else if(checkIfEmailExists()){
            view.showMessage("Email already used...");
        }else if (!checkIfEmailValid()){
            view.showMessage("Wrong format for email...");
        }else{
            customer = new Customer(email, password, firstName, lastName);
            customer.setTypeOfUser(typeOfUser);
            users.save(customer);
            if(typeOfUser == TypeOfUser.NORMAL){
                view.showMessage("Successfull Sign up, Welcome!");
                view.onCustomerMain();
            }else{
                view.onPayment();
            }
        }
    }

    private boolean checkForEmptyFields() {
        return email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty();
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
