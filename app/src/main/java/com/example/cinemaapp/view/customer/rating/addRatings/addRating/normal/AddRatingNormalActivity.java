package com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.RatingsDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.customer.rating.addRatings.main.AddRatingsActivity;
import com.example.cinemaapp.view.owner.mainActivity.OwnerMainActivity;

public class AddRatingNormalActivity extends AppCompatActivity implements AddRatingNormalView {

    private static final String MOVIE_TITLE = "MovieTitle";
    public static final String EMAIL = "email";
    private AddRatingNormalPresenter presenter;
    private String movieTitle;
    private String email;
    private Button submitRating;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent receivedIntent = getIntent();
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);
        email = receivedIntent.getStringExtra(EMAIL);

        setContentView(R.layout.activity_customer_add_rating_normal);
        setTitle(getString(R.string.ratings_for) + movieTitle);

        presenter = new AddRatingNormalPresenter(this, new UserDAOMemory(), new RatingsDAOMemory(), new MovieDAOMemory());

        ratingBar = findViewById(R.id.normal_add_rating_bar);
        submitRating = findViewById(R.id.normal_add_rating_submit);
        submitRating.setOnClickListener(v -> {
            presenter.addRating();
        });

    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public float getRating() {
        return ratingBar.getRating();
    }

    public void onMainAddRating(){
        finish();
    }
}