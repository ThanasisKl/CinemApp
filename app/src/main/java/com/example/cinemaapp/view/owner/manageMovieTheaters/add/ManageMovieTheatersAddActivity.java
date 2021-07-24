package com.example.cinemaapp.view.owner.manageMovieTheaters.add;

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
import com.example.cinemaapp.view.owner.manageMovieTheaters.main.ManageMovieTheatersMainActivity;

import static java.lang.Integer.parseInt;

public class ManageMovieTheatersAddActivity extends AppCompatActivity implements ManageMovieTheatersAddView {

    private EditText edtName, edtAddress, edtNumberOfAuditoriums;
    private ManageMovieTheatersAddPresenter presenter;
    private Button submitMovieTheaterButton;
    private static final int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movie_theaters_add);
        setTitle(R.string.add_movie_theaters);

        edtName = findViewById(R.id.owner_manage_movie_theaters_name);
        edtAddress = findViewById(R.id.owner_manage_movie_theaters_address);
        edtNumberOfAuditoriums = findViewById(R.id.owner_manage_movie_theaters_number_of_auditoriums);

        presenter = new ManageMovieTheatersAddPresenter(this, new MovieTheaterDAOMemory());

        submitMovieTheaterButton = findViewById(R.id.owner_manage_movie_theaters_submit);
        submitMovieTheaterButton.setOnClickListener(v -> {
            presenter.addMovieTheater();
        });
    }


    @Override
    public String getMovieTheaterName() {
        return edtName.getText().toString();
    }

    @Override
    public String getAddress() {
        return edtAddress.getText().toString();
    }

    @Override
    public int getAuditoriumsNumber() {
        if(edtNumberOfAuditoriums.getText().toString().isEmpty()){
            return -1;
        }
        return parseInt(edtNumberOfAuditoriums.getText().toString());
    }

    @Override
    public void onManageMovieTheatersMain() {
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }
}