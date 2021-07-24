package com.example.cinemaapp.view.owner.seeStatistics.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.owner.seeStatistics.individualMovie.SeeStatisticsForIndividualMovieActivity;

public class SeeStatisticsMainActivity extends AppCompatActivity implements SeeStatisticsMainView {

    public static final String MOVIE_TITLE = "MovieTitle";
    private SeeStatisticsMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_see_statistics_main);
        setTitle(R.string.see_statistics_owner);

        presenter = new SeeStatisticsMainPresenter(this);
    }

    @Override
    public void onSelectMovie(String movieTitle) {
        Intent intent = new Intent( this , SeeStatisticsForIndividualMovieActivity.class);
        intent.putExtra(MOVIE_TITLE, movieTitle);
        startActivity(intent);
    }
}