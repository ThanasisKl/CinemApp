package com.example.cinemaapp.view.customer.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.customer.rating.mainRating.MainRatingActivity;
import com.example.cinemaapp.view.customer.selectMovie.CustomerSelectMovieActivity;
import com.example.cinemaapp.view.main.mainActivity.MainActivity;

import java.util.Calendar;

public class CustomerMainActivity extends AppCompatActivity implements CustomerMainView{
    public static final String CUSTOMER = "customer";
    public static final String EMAIL = "email";
    private Button bookTicketButton, makeReviewButton;
    private CustomerMainPresenter presenter;
    private String email, welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CustomerMainPresenter(this, new UserDAOMemory());

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour < 12){
            welcome = getString(R.string.good_morning_welcome_message);
        }else{
            welcome = getString(R.string.good_evening_welcome_message);
        }

        setContentView(R.layout.activity_customer_main);
        setTitle(welcome + " " + presenter.getFirstName());



        bookTicketButton = findViewById(R.id.customer_main_page_book_ticket_button);
        bookTicketButton.setOnClickListener(v -> {
            presenter.bookTickets();
        });

        makeReviewButton = findViewById(R.id.customer_main_page_make_rating_button);
        makeReviewButton.setOnClickListener(v -> {
            presenter.makeReview();
        });
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();

        Intent intentMainActivity = new Intent(CustomerMainActivity.this, MainActivity.class);
        intentMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentMainActivity);
    }


    @Override
    public void onBookTicket() {
        Intent intentBookTickets = new Intent(CustomerMainActivity.this, CustomerSelectMovieActivity.class);
        intentBookTickets.putExtra(EMAIL, email);
        startActivity(intentBookTickets);
    }

    @Override
    public void onMakeReview() {
        Intent intentAddStaff = new Intent(CustomerMainActivity.this, MainRatingActivity.class);
        intentAddStaff.putExtra(EMAIL, email);
        startActivity(intentAddStaff);
    }

    @Override
    public String getEmail() {
        return email;
    }
}