package com.example.cinemaapp.view.customer.CustomerSelectSlot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.util.Slot_Day;
import com.example.cinemaapp.view.customer.reservationCustomer.CustomerReservationActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerSelectSlotActivity extends AppCompatActivity implements CustomerSelectSlotView, Serializable {
    public static final String  MOVIE_TITLE = "movie title",
                                MOVIE_THEATER = "movie_theater",
                                EMAIL = "email",
                                SLOT_DAY = "slot day";

    private String movieTitle, movieTheaterName, email;
    private CustomerSelectSlotPresenter presenter;
    private Slot_Day slot_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new CustomerSelectSlotPresenter(this, new MovieTheaterDAOMemory());

        Intent receivedIntent = getIntent();
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);
        movieTheaterName = receivedIntent.getStringExtra(MOVIE_THEATER);
        email = receivedIntent.getStringExtra(EMAIL);

        setContentView(R.layout.activity_customer_select_slot);
        setTitle(getString(R.string.select_auditorium_and_date));
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
    public String getMovieTheaterTitle() {
        return movieTheaterName;
    }

    @Override
    public ArrayList<Slot_Day> onFindMovieSlots() {
       return presenter.findMovieSlots();
    }

    @Override
    public void onSelectMovie(Slot_Day slot_day) {
        this.slot_day = slot_day;
        Intent intent = new Intent( CustomerSelectSlotActivity.this , CustomerReservationActivity.class);
        intent.putExtra(SLOT_DAY, slot_day);
        intent.putExtra(MOVIE_THEATER, getMovieTheaterTitle());
        intent.putExtra(EMAIL, getEmail());
        startActivity(intent);
    }
}