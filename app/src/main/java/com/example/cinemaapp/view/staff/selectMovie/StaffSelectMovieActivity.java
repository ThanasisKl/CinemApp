package com.example.cinemaapp.view.staff.selectMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.staff.addMovie.AddMovieActivity;

public class StaffSelectMovieActivity extends AppCompatActivity implements StaffSelectMovieView {

    public static final String EMAIL = "email";
    public static final String MOVIE_TITLE = "MovieTitle";
    public static final String MOVIE_THEATER = "MovieTheater";
    private String email;
    private StaffSelectMoviePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_select_movie);
        setTitle(R.string.select_movie);

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);

        presenter = new StaffSelectMoviePresenter(this, new UserDAOMemory());

    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getMovieTheaterName() {
        return presenter.findMovieTheater();
    }

    @Override
    public void onSelectMovie(String movieName) {
        Intent intent = new Intent( this , AddMovieActivity.class);
        intent.putExtra(MOVIE_TITLE, movieName);
        intent.putExtra(MOVIE_THEATER, getMovieTheaterName());
        intent.putExtra(EMAIL, getEmail());
        startActivity(intent);
    }

}