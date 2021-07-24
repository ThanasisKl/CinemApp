package com.example.cinemaapp.view.customer.selectMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.view.customer.selectMovieTheater.CustomerSelectMovieTheaterActivity;

public class CustomerSelectMovieActivity extends AppCompatActivity implements CustomerSelectMovieView {
    private static final String EMAIL = "email";
    //TEST
    private CustomerSelectMoviePresenter presenter;
    public static final String MOVIE_TITLE = "movie title";
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        setTitle("Choose a movie" + " " +email);
        setContentView(R.layout.activity_customer_select_movie);
        presenter = new CustomerSelectMoviePresenter(this, new MovieDAOMemory());
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void onSelectMovie(String MovieTitle) {
        Intent intent = new Intent(CustomerSelectMovieActivity.this, CustomerSelectMovieTheaterActivity.class);
        intent.putExtra(EMAIL, getEmail());
        intent.putExtra(MOVIE_TITLE, MovieTitle);
        startActivity(intent);

    }
}

