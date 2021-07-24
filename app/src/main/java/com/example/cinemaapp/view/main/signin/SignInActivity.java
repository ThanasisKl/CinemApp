package com.example.cinemaapp.view.main.signin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.customer.mainActivity.CustomerMainActivity;
import com.example.cinemaapp.view.owner.mainActivity.OwnerMainActivity;
import com.example.cinemaapp.view.staff.mainActivity.StaffMainActivity;

public class SignInActivity extends AppCompatActivity implements SignInView{

    public static final String EMAIL = "email";
    private Button submitOwnerSignUp;
    private EditText edtEmail, edtPassword;
    private SignInPresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_in);
        setTitle(R.string.sign_in_text);

        edtEmail = findViewById(R.id.email_sign_in);
        edtPassword = findViewById(R.id.password_sign_in);

        presenter = new SignInPresenter(this, new UserDAOMemory());

        submitOwnerSignUp = findViewById(R.id.submit_sign_in);
        submitOwnerSignUp.setOnClickListener((v) -> {
            presenter.signIn();
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
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

    @Override
    public void onStaffMain() {
        finish();
        Intent intentStaffMain = new Intent(this, StaffMainActivity.class);
        intentStaffMain.putExtra(EMAIL, getEmail());
        startActivity(intentStaffMain);
    }

    @Override
    public void onCustomerMain() {
        finish();
        Intent intentCustomerMain = new Intent(this, CustomerMainActivity.class);
        intentCustomerMain.putExtra(EMAIL, getEmail());
        startActivity(intentCustomerMain);
    }

    @Override
    public void onOwnerMain() {
        finish();
        Intent intentOwnerMain = new Intent(this, OwnerMainActivity.class);
        intentOwnerMain.putExtra(EMAIL, getEmail());
        startActivity(intentOwnerMain);
    }
}