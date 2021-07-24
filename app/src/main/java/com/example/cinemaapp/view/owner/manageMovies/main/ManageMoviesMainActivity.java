package com.example.cinemaapp.view.owner.manageMovies.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.owner.manageMovies.add.ManageMoviesAddActivity;
import com.example.cinemaapp.view.owner.manageMovies.remove.ManageMoviesRemoveActivity;

public class ManageMoviesMainActivity extends AppCompatActivity implements ManageMoviesMainView{

    private Button addMovieButton, removeMovieButton;
    ManageMoviesMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movies_main);
        setTitle(R.string.manage_movies_text);

        presenter = new ManageMoviesMainPresenter(this);

        addMovieButton = findViewById(R.id.owner_manage_movie_main_add_selection_button);
        addMovieButton.setOnClickListener(v -> {
            presenter.addMovie();
        });

        removeMovieButton = findViewById(R.id.owner_manage_movie_main_remove_selection_button);
        removeMovieButton.setOnClickListener(v -> {
            presenter.removeMovie();
        });
    }

    @Override
    public void onAddMovie() {
        Intent intentAddMovie = new Intent(this, ManageMoviesAddActivity.class);
        startActivity(intentAddMovie);
    }

    @Override
    public void onRemoveMovie() {
        Intent intentRemoveMovie = new Intent(this, ManageMoviesRemoveActivity.class);
        startActivity(intentRemoveMovie);
    }
}