package com.example.cinemaapp.view.owner.manageMovieTheaters.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.owner.manageMovieTheaters.add.ManageMovieTheatersAddActivity;
import com.example.cinemaapp.view.owner.manageMovieTheaters.remove.ManageMovieTheatersRemoveActivity;

public class ManageMovieTheatersMainActivity extends AppCompatActivity implements ManageMovieTheatersMainView{

    private Button addMovieTheaterButton, removeMovieTheaterButton;
    ManageMovieTheatersMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movie_theaters_main);
        setTitle(R.string.manage_movie_theaters);

        presenter = new ManageMovieTheatersMainPresenter(this);

        addMovieTheaterButton = findViewById(R.id.owner_manage_movie_theaters_add_selection_button);
        addMovieTheaterButton.setOnClickListener(v -> {
            presenter.addMovieTheater();
        });

        removeMovieTheaterButton = findViewById(R.id.owner_manage_movie_theaters_remove_selection_button);
        removeMovieTheaterButton.setOnClickListener(v -> {
            presenter.removeMovieTheater();
        });

    }

    @Override
    public void onAddMovieTheater() {
        Intent intentAddMovieTheater = new Intent(this, ManageMovieTheatersAddActivity.class);
        startActivity(intentAddMovieTheater);
    }

    @Override
    public void onRemoveMovieTheater() {
        Intent intentRemoveMovieTheater = new Intent(this, ManageMovieTheatersRemoveActivity.class);
        startActivity(intentRemoveMovieTheater);
    }

}