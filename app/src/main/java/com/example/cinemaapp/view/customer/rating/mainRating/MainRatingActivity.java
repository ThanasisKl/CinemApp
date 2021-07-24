package com.example.cinemaapp.view.customer.rating.mainRating;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.view.customer.rating.addRatings.main.AddRatingsActivity;
import com.example.cinemaapp.view.customer.rating.readRatings.main.ReadRatingsActivity;

public class MainRatingActivity extends AppCompatActivity implements MainRatingView{


    public static final String EMAIL = "email";
    private MainRatingPresenter presenter;
    private Button addRatings, readRatings;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);

        setContentView(R.layout.activity_customer_main_rating);
        setTitle(R.string.ratings);

        presenter = new MainRatingPresenter(this);

        addRatings = findViewById(R.id.customer_rating_main_add);
        addRatings.setOnClickListener(v -> {
            presenter.addRatings();
        });

        readRatings = findViewById(R.id.customer_rating_main_read);
        readRatings.setOnClickListener(v -> {
            presenter.readRatings();
        });

    }


    @Override
    public void onAddRatings() {
        Intent intentAddRatingActivity = new Intent(this, AddRatingsActivity.class);
        intentAddRatingActivity.putExtra(EMAIL, email);
        startActivity(intentAddRatingActivity);
    }

    @Override
    public void onReadRatings() {
        Intent intentReadRatingActivity = new Intent(this, ReadRatingsActivity.class);
        startActivity(intentReadRatingActivity);
    }
}