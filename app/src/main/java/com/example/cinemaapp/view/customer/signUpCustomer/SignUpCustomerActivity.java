package com.example.cinemaapp.view.customer.signUpCustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.view.customer.mainActivity.CustomerMainActivity;
import com.example.cinemaapp.view.customer.payment.PaymentActivity;

public class SignUpCustomerActivity extends AppCompatActivity implements SignUpCustomerView{

    public static final String EMAIL = "email";
    public static final String AMOUNT = "amount";
    private Button submitCustomerSignUp;
    private EditText edtEmail, edtPassword, edtFirstName, edtLastName;
    private RadioButton premiumButton, normalButton;
    private SignUpCustomerPresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;
    private float amount = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);
        setTitle(R.string.customer_sign_up_text_sign_up);

        edtEmail = findViewById(R.id.email_sign_up_customer);
        edtPassword = findViewById(R.id.password_sign_up_customer);
        edtFirstName = findViewById(R.id.first_name_sign_up_customer);
        edtLastName = findViewById(R.id.last_name_sign_up_customer);
        premiumButton = findViewById(R.id.premium_selection_sign_up_customer);
        normalButton = findViewById(R.id.normal_selection_sign_up_customer);

        premiumButton.setOnClickListener((v) -> {
            presenter.setTypeCustomer(TypeOfUser.PREMIUM);
            if(normalButton.isChecked()) {
                normalButton.setChecked(false);
            }
        });

        normalButton.setOnClickListener((v) -> {
            presenter.setTypeCustomer(TypeOfUser.NORMAL);
            if (premiumButton.isChecked()) {
                premiumButton.setChecked(false);
            }
        });


        presenter = new SignUpCustomerPresenter(this, new UserDAOMemory());

        submitCustomerSignUp = findViewById(R.id.submit_sign_up_customer);
        submitCustomerSignUp.setOnClickListener((v) -> {
            presenter.signUpCustomer();
        });
    }

    @Override
    public String getEmail() {
        return edtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public String getFirstName() {
        return edtFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return edtLastName.getText().toString();
    }

    @Override
    public void onCustomerMain() {
        finish();
        Intent intentCustomerMain = new Intent(this, CustomerMainActivity.class);
        intentCustomerMain.putExtra(EMAIL, getEmail());
        startActivity(intentCustomerMain);
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

    @Override
    public void onPayment() {
        Intent intentPayment = new Intent(this, PaymentActivity.class);
        intentPayment.putExtra(EMAIL, getEmail());
        intentPayment.putExtra(AMOUNT, amount);
        startActivity(intentPayment);
    }
}