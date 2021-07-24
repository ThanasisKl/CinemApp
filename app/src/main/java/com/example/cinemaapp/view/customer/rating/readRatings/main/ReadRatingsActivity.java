package com.example.cinemaapp.view.customer.rating.readRatings.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.customer.rating.readRatings.individualMovie.ReadIndividualMovieActivity;

public class ReadRatingsActivity extends AppCompatActivity implements ReadRatingsView {

    public static final String MOVIE_TITLE = "MovieTitle";
    private ReadRatingsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_read_ratings);
        setTitle(getString(R.string.read_ratings));

        presenter = new ReadRatingsPresenter(this);
    }

    @Override
    public void onSelectMovie(String movieTitle) {
        Intent intentReadIndividualRatingActivity = new Intent(this, ReadIndividualMovieActivity.class);
        intentReadIndividualRatingActivity.putExtra(MOVIE_TITLE, movieTitle);
        startActivity(intentReadIndividualRatingActivity);
    }
}