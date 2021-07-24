package com.example.cinemaapp.view.customer.selectMovieTheater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.view.customer.CustomerSelectSlot.CustomerSelectSlotActivity;
import com.example.cinemaapp.view.customer.selectMovie.CustomerSelectMovieActivity;

public class CustomerSelectMovieTheaterActivity extends AppCompatActivity implements CustomerSelectMovieTheaterView{
    private static final String MOVIE_THEATER = "movie_theater";
    private static final String EMAIL = "email";
    private String movieTitle;
    public static final String MOVIE_TITLE = "movie title";
    private CustomerSelectMovieTheaterPresenter presenter;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CustomerSelectMovieTheaterPresenter(this, new MovieTheaterDAOMemory());
        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);

        setContentView(R.layout.activity_customer_select_movie_theater);
        setTitle(getString(R.string.choose_cinema_for) + " " + movieTitle);

    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void onSelectMovieTheater(String movieTheater) {
        Log.d("select movie theater", "mpike mesa");
        Intent intent = new Intent(CustomerSelectMovieTheaterActivity.this, CustomerSelectSlotActivity.class);
        intent.putExtra(MOVIE_TITLE, getMovieTitle());
        intent.putExtra(MOVIE_THEATER, movieTheater);
        intent.putExtra(EMAIL,getEmail());
        startActivity(intent);

    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

}