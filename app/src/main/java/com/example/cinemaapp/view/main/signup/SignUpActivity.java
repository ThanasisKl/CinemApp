package com.example.cinemaapp.view.main.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RadioButton;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.customer.signUpCustomer.SignUpCustomerActivity;
import com.example.cinemaapp.view.owner.signupOwner.SignUpOwnerActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView{

    private SignUpPresenter presenter;
    private RadioButton signUpCustomer;
    private RadioButton signUpOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        setTitle(R.string.sign_up_text);

        presenter = new SignUpPresenter(this);

        signUpOwner = findViewById(R.id.sign_up_button_owner);
        signUpOwner.setOnClickListener((v) -> {
            signUpOwner.setChecked(false);
            presenter.signUpOwner();
        });

        signUpCustomer = findViewById(R.id.sign_up_customer_button);
        signUpCustomer.setOnClickListener((v) -> {
            signUpCustomer.setChecked(false);
            presenter.signUpCustomer();
        });
    }

    @Override
    public void onSignUpOwner() {
        Intent intentSignUpOwner = new Intent(this, SignUpOwnerActivity.class);
        startActivity(intentSignUpOwner);
    }

    @Override
    public void onSignUpCustomer() {
        Intent intentSignUpCustomer = new Intent(this, SignUpCustomerActivity.class);
        startActivity(intentSignUpCustomer);
    }
}