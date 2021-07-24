package com.example.cinemaapp.view.main.mainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MemoryInitialiser;
import com.example.cinemaapp.view.main.signin.SignInActivity;
import com.example.cinemaapp.view.main.signup.SignUpActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MainView{
    public static MemoryInitialiser memoryInitializer;
    public static boolean firstTime = true;

    private MainPresenter presenter;
    private Button buttonSignUp, buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(firstTime){
            Log.d("mark","/////////////////////////////////////");
            memoryInitializer = new MemoryInitialiser();
            memoryInitializer.prepareData();
            firstTime = false;
        }


        presenter = new MainPresenter(this);

        buttonSignUp = findViewById(R.id.signUpButton);
        buttonSignUp.setOnClickListener(v -> {
            presenter.signUp();
        });


        buttonSignIn = findViewById(R.id.submit_sign_in);
        buttonSignIn.setOnClickListener(v -> {
            presenter.signIn();
        });

    }

    @Override
    public void onSignUp(){
        Intent intentSignUp = new Intent(this, SignUpActivity.class);
        startActivity(intentSignUp);
    }

    @Override
    public void onSignIn(){
        Intent intentSignIn = new Intent(this, SignInActivity.class);
        startActivity(intentSignIn);
    }

}