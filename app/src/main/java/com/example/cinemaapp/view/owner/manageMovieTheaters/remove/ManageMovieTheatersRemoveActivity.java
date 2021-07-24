package com.example.cinemaapp.view.owner.manageMovieTheaters.remove;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;

public class ManageMovieTheatersRemoveActivity extends AppCompatActivity implements ManageMovieTheatersRemoveView{

    private ManageMovieTheatersRemovePresenter presenter;
    private String movieTheaterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movie_theaters_remove);
        setTitle(R.string.remove_movie_theaters);

        presenter = new ManageMovieTheatersRemovePresenter(this, new MovieTheaterDAOMemory());
    }

    @Override
    public void onRemoveMovieTheater(String movieTheaterName) {
        this.movieTheaterName = movieTheaterName;
        presenter.removeMovieTheater();
        this.finish();
        startActivity(getIntent());
    }

    @Override
    public String getMovieTheaterName() {
        return movieTheaterName;
    }
}