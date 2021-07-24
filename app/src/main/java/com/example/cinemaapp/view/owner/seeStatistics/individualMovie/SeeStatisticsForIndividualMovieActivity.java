package com.example.cinemaapp.view.owner.seeStatistics.individualMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

import java.util.ArrayList;

public class SeeStatisticsForIndividualMovieActivity extends AppCompatActivity implements SeeStatisticsForIndividualMovieView{

    private static final String MOVIE_TITLE = "MovieTitle";
    private SeeStatisticsForIndividualMoviePresenter presenter;
    private String movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent receivedIntent = getIntent();
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);

        presenter = new SeeStatisticsForIndividualMoviePresenter(this, new MovieTheaterDAOMemory());
        setContentView(R.layout.activity_owner_see_statistics_for_individual_movie);
        setTitle(movieTitle);

    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public ArrayList<Integer> getTicketsSold() {
        return presenter.getTicketsSold();
    }
}