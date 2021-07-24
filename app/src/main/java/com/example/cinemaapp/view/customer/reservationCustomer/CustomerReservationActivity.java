package com.example.cinemaapp.view.customer.reservationCustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.util.Slot_Day;
import com.example.cinemaapp.view.customer.payment.PaymentActivity;

import java.io.Serializable;

import static java.lang.Integer.parseInt;

public class CustomerReservationActivity extends AppCompatActivity implements Serializable, CustomerReservationView {

    private CustomerReservationPresenter presenter;
    public static final String  AMOUNT = "amount",
                                SLOT = "slot",
                                SEATS = "seats",
                                MOVIE_THEATER = "movie_theater",
                                EMAIL = "email",
                                SLOT_DAY = "slot day";
    private TextView numberOfSeats;
    private Button button;
    private Slot_Day slotDay;
    private String movie_theater, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new CustomerReservationPresenter(this,new MovieTheaterDAOMemory(),new UserDAOMemory());

        Intent receivedIntent = getIntent();
        slotDay = (Slot_Day) receivedIntent.getSerializableExtra(SLOT_DAY);
        movie_theater = receivedIntent.getStringExtra(MOVIE_THEATER);
        email = receivedIntent.getStringExtra(EMAIL);

        setContentView(R.layout.activity_customer_reservation);
        setTitle(getString(R.string.reserve_seats));

        numberOfSeats = findViewById(R.id.txtSeatsReserve);
        button = findViewById(R.id.button4seats);

        button.setOnClickListener((v) -> {

            if(!presenter.findAvailability2(email)){
                showMessage("There are not that many available seats");
            }else{
                showMessage("There are available seats");

                Intent intent = new Intent(this, PaymentActivity.class);
                intent.putExtra(EMAIL, email);
                intent.putExtra(AMOUNT,getSeats()* 30f);
                intent.putExtra(SLOT, slotDay);
                intent.putExtra(SEATS, getSeats());
                intent.putExtra(MOVIE_THEATER, getMovieTheaterName());
                startActivity(intent);
            }
        });
    }

    @Override
    public int getSeats() {
        return parseInt(numberOfSeats.getText().toString());
    }

    @Override
    public String getMovieTheaterName() {
        return movie_theater;
    }

    @Override
    public Slot getSelectedSlot() {
        return slotDay.getSlot();
    }

    @Override
    public Day getSelectedDay() {
        return slotDay.getDay();
    }

    @Override
    public void showMessage(String message) {
        Toast toast=Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.show();
    }


}