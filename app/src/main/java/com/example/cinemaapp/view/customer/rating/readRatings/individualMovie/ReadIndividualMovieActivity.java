package com.example.cinemaapp.view.customer.rating.readRatings.individualMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;

public class ReadIndividualMovieActivity extends AppCompatActivity implements ReadIndividualMovieView{

    private static final String MOVIE_TITLE = "MovieTitle";
    public static final String EMAIL = "email";
    private ReadIndividualMoviePresenter presenter;
    private String movieTitle;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);
        email = receivedIntent.getStringExtra(EMAIL);

        setContentView(R.layout.activity_customer_read_individual_movies_ratings);
        setTitle(getString(R.string.ratings_for) +" " + movieTitle);

        presenter = new ReadIndividualMoviePresenter(this);
    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }
}