package com.example.cinemaapp.view.owner.manageMovies.remove;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;

public class ManageMoviesRemoveActivity extends AppCompatActivity implements ManageMoviesRemoveView{

    private ManageMoviesRemovePresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;

    private String movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_manage_movies_remove);
        setTitle(R.string.remove_movies);

        presenter = new ManageMoviesRemovePresenter(this, new MovieDAOMemory());
    }

    @Override
    public void onRemoveMovie(String movieTitle){
        this.movieTitle = movieTitle;
        presenter.removeMovie();
        this.finish();
        startActivity(getIntent());
    }

    @Override
    public void showMessage(String message){
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }
}