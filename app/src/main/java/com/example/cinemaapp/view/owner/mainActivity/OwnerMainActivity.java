package com.example.cinemaapp.view.owner.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.User;
import com.example.cinemaapp.view.main.mainActivity.MainActivity;
import com.example.cinemaapp.view.owner.addStaff.AddStaffActivity;
import com.example.cinemaapp.view.owner.manageMovieTheaters.main.ManageMovieTheatersMainActivity;
import com.example.cinemaapp.view.owner.manageMovies.main.ManageMoviesMainActivity;
import com.example.cinemaapp.view.owner.seeStatistics.main.SeeStatisticsMainActivity;

import java.util.Calendar;

public class OwnerMainActivity extends AppCompatActivity implements  OwnerMainView{

    public static final String EMAIL = "email";
    private Button addStaffButton, manageMoviesButton, manageMovieTheatersButton, seeStatisticsButton;
    private OwnerMainPresenter presenter;
    private String email, welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new OwnerMainPresenter(this, new UserDAOMemory());

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour < 12){
            welcome = getString(R.string.good_morning_welcome_message);
        }else{
            welcome = getString(R.string.good_evening_welcome_message);
        }

        setContentView(R.layout.activity_owner_main_screen);
        setTitle(welcome + " " + presenter.getFirstName());


        addStaffButton = findViewById(R.id.owner_main_page_add_staff_button);
        addStaffButton.setOnClickListener(v -> {
            presenter.addStaff();
        });

        manageMoviesButton = findViewById(R.id.owner_main_page_manage_movies_button);
        manageMoviesButton.setOnClickListener(v -> {
            presenter.manageMovies();
        });

        manageMovieTheatersButton = findViewById(R.id.owner_main_page_manage_movie_theaters_button);
        manageMovieTheatersButton.setOnClickListener(v -> {
            presenter.manageMovieTheaters();
        });

        seeStatisticsButton = findViewById(R.id.owner_main_page_see_statistics_button);
        seeStatisticsButton.setOnClickListener(v -> {
            presenter.seeStatistics();
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        intentMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentMainActivity);

    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void onAddStaff() {
        Intent intentAddStaff = new Intent(this, AddStaffActivity.class);
        startActivity(intentAddStaff);
    }

    @Override
    public void onManageMovies() {
        Intent intentManageMovies = new Intent(this, ManageMoviesMainActivity.class);
        startActivity(intentManageMovies);
    }

    @Override
    public void onManageMovieTheaters() {
        Intent intentMangeMovieTheaters = new Intent(this, ManageMovieTheatersMainActivity.class);
        startActivity(intentMangeMovieTheaters);
    }

    @Override
    public void onSeeStatistics() {
        Intent intentSeeStatistics = new Intent(this, SeeStatisticsMainActivity.class);
        startActivity(intentSeeStatistics);
    }
}