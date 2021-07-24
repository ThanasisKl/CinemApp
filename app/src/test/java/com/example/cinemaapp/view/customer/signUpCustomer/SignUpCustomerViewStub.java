package com.example.cinemaapp.view.customer.signUpCustomer;

import com.example.cinemaapp.model.TypeOfUser;

public class SignUpCustomerViewStub implements SignUpCustomerView{

    private int customerMainClicks,
                paymentClicks;

    private SignUpCustomerPresenter presenter;

    private String email, password, firstName, lastName, message;

    public SignUpCustomerPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignUpCustomerPresenter presenter) {
        this.presenter = presenter;
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

    public void onCustomerMain() {
        customerMainClicks++;
    }

    public void onPayment() {
        paymentClicks++;
    }

    public void showMessage(String message) {
        this.message = message;
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

    public int getCustomerMainClicks() {
        return customerMainClicks;
    }

    public int getPaymentClicks() {
        return paymentClicks;
    }
}