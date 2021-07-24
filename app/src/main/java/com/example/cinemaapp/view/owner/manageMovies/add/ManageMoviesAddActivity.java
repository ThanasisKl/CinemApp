package com.example.cinemaapp.view.owner.manageMovies.add;

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
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.view.owner.manageMovies.main.ManageMoviesMainActivity;

import static java.lang.Integer.parseInt;

public class ManageMoviesAddActivity extends AppCompatActivity implements ManageMoviesAddView {

    private EditText edtTitle, edtDuration;
    private ManageMoviesAddPresenter presenter;
    private Button submitMovieButton;
    private static final int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movies_add);
        setTitle(R.string.add_movies_text);

        edtTitle = findViewById(R.id.owner_manage_movies_title);
        edtDuration = findViewById(R.id.owner_manage_movies_duration);

        presenter = new ManageMoviesAddPresenter(this, new MovieDAOMemory());

        submitMovieButton = findViewById(R.id.owner_manage_movies_submit);
        submitMovieButton.setOnClickListener(v -> {
            presenter.addMovie();
        });
    }

    @Override
    public String getMovieTitle() {
        return edtTitle.getText().toString();
    }

    @Override
    public int getDuration() {
        if(edtDuration.getText().toString().isEmpty()){
            return -1;
        }
        return parseInt(edtDuration.getText().toString());
    }

    @Override
    public void onManageMoviesMain() {
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }
}