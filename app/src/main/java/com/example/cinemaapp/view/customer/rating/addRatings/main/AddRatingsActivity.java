package com.example.cinemaapp.view.customer.rating.addRatings.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.view.customer.rating.addRatings.addRating.normal.AddRatingNormalActivity;
import com.example.cinemaapp.view.customer.rating.addRatings.addRating.premium.AddRatingPremiumActivity;

public class AddRatingsActivity extends AppCompatActivity implements AddRatingsView {

    public static final String EMAIL = "email";
    public static final String MOVIE_TITLE = "MovieTitle";
    private AddRatingsPresenter presenter;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        setContentView(R.layout.activity_customer_add_ratings);
        setTitle(R.string.add_ratings);

        presenter = new AddRatingsPresenter(this, new UserDAOMemory());
    }

    @Override
    public void onSelectMovie(String movieTitle) {
        if(getTypeOfUser() == TypeOfUser.NORMAL){
            Intent intentAddRatingNormalActivity = new Intent(this, AddRatingNormalActivity.class);
            intentAddRatingNormalActivity.putExtra(MOVIE_TITLE, movieTitle);
            intentAddRatingNormalActivity.putExtra(EMAIL, email);
            startActivity(intentAddRatingNormalActivity);
        }else{
            Intent intentAddRatingPremiumActivity = new Intent(this, AddRatingPremiumActivity.class);
            intentAddRatingPremiumActivity.putExtra(MOVIE_TITLE, movieTitle);
            intentAddRatingPremiumActivity.putExtra(EMAIL, email);
            startActivity(intentAddRatingPremiumActivity);
        }

    }

    @Override
    public TypeOfUser getTypeOfUser() {
        return presenter.findTypeOfUser();
    }

    @Override
    public String getEmail() {
        return email;
    }
}