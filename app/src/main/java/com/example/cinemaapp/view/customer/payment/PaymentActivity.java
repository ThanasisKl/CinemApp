package com.example.cinemaapp.view.customer.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.PaymentDAOMemory;
import com.example.cinemaapp.dao.memorydao.ReservationDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.util.Slot_Day;
import com.example.cinemaapp.view.customer.mainActivity.CustomerMainActivity;

public class PaymentActivity extends AppCompatActivity implements PaymentView{

    public static final String AMOUNT = "amount";
    public static final String EMAIL = "email";
    public static final String SLOT = "slot";
    public static final String SEATS = "seats";
    public static final String MOVIE_THEATER = "movie_theater";
    public static final int PREMIUMPRICE = 50;

    private PaymentPresenter presenter;
    private EditText edtCreditCardNumber;
    private TextView edtAmount;
    private Button paymentButton;
    private float amount;
    private String email;
    private Slot_Day slot_day;
    private int seats;

    private String movieTheaterName;

    private Boolean signUpPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customer_payment);
        setTitle(getString(R.string.payment));

        presenter = new PaymentPresenter(this, new PaymentDAOMemory(),new UserDAOMemory(),new ReservationDAOMemory(), new MovieTheaterDAOMemory());

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        amount = receivedIntent.getFloatExtra(AMOUNT,0);

        if(amount != PREMIUMPRICE){
            signUpPayment = false;
            slot_day = (Slot_Day) receivedIntent.getSerializableExtra(SLOT);
            seats = receivedIntent.getIntExtra(SEATS,0);
            movieTheaterName = receivedIntent.getStringExtra(MOVIE_THEATER);
        }else{
            signUpPayment = true;
        }

        edtAmount = findViewById(R.id.payment_amount);
        edtAmount.setText(String.valueOf(amount)+"$");
        edtCreditCardNumber = findViewById(R.id.payment_credit_card_number);
        paymentButton = findViewById(R.id.payment_pay_button);
        paymentButton.setOnClickListener(v -> {
            if(signUpPayment){
                presenter.executePaymentSignUp();
            }else{
                presenter.executePaymentBookSeats();
            }
        });
        }

    @Override
    public float getAmount() {
        return amount;
    }

    @Override
    public String getCreditCardNumber() {
        return edtCreditCardNumber.getText().toString();
    }

    @Override
    public Slot_Day getSlot_Day() {
        return slot_day;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getMovieTheaterName() {
        return movieTheaterName;
    }

    @Override
    public void onCustomerMain() {
        finish();
        Intent intentCustomerMainActivity = new Intent(this, CustomerMainActivity.class);
        intentCustomerMainActivity.putExtra(EMAIL, email);
        startActivity(intentCustomerMainActivity);
    }

    @Override
    public void showMessage(String message) {
        Toast toast=Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.show();
    }


}