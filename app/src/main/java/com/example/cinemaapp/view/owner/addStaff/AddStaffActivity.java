package com.example.cinemaapp.view.owner.addStaff;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.owner.mainActivity.OwnerMainActivity;

public class AddStaffActivity extends AppCompatActivity implements AddStaffView{

    private EditText edtEmail, edtPassword, edtFirstName, edtLastName, edtMovieTheater;
    private Button submitOwnerSignUp;
    private AddStaffPresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_add_staff);
        setTitle(R.string.add_staff_owner);


        edtEmail = findViewById(R.id.email_add_staff);
        edtPassword = findViewById(R.id.password_add_staff);
        edtFirstName = findViewById(R.id.first_name_add_staff);
        edtLastName = findViewById(R.id.last_name_add_staff);
        edtMovieTheater = findViewById(R.id.movie_theater_add_staff);

        presenter = new AddStaffPresenter(this, new UserDAOMemory(), new MovieTheaterDAOMemory());

        submitOwnerSignUp = findViewById(R.id.submit_add_staff);
        submitOwnerSignUp.setOnClickListener((v) -> {
            presenter.addStaff();
        });
    }

    @Override
    public String getEmail() {
        return edtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public String getFirstName() {
        return edtFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return edtLastName.getText().toString();
    }

    @Override
    public String getMovieTheater() {
        return edtMovieTheater.getText().toString();
    }

    @Override
    public void onOwnerMain() {
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

}