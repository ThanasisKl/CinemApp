package com.example.cinemaapp.view.owner.signupOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.owner.mainActivity.OwnerMainActivity;

import static java.lang.Integer.parseInt;

public class SignUpOwnerActivity extends AppCompatActivity implements SignUpOwnerView{

    public static final String EMAIL = "email";
    private Button submitOwnerSignUp;
    private EditText edtEmail, edtPassword, edtFirstName, edtLastName, edtSSN, edtAMKA;
    private SignUpOwnerPresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_sign_up);
        setTitle(R.string.owner_sign_up_text_sign_up_owner);

        edtEmail = findViewById(R.id.email_sign_up_owner);
        edtPassword = findViewById(R.id.password_sign_up_owner);
        edtFirstName = findViewById(R.id.first_name_sign_up_owner);
        edtLastName = findViewById(R.id.last_name_sign_up_owner);
        edtSSN = findViewById(R.id.ssn_sign_up_owner);
        edtAMKA = findViewById(R.id.amka_sign_up_owner);

        presenter = new SignUpOwnerPresenter(this, new UserDAOMemory());

        submitOwnerSignUp = findViewById(R.id.submit_sign_up_owner);
        submitOwnerSignUp.setOnClickListener((v) -> {
            presenter.signUpOwner();
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
    public String getSSN() {
        return edtSSN.getText().toString();
    }

    @Override
    public String getAMKA() {
        return edtAMKA.getText().toString();
    }

    @Override
    public void onOwnerMain() {
        finish();
        Intent intentOwnerMain = new Intent(this, OwnerMainActivity.class);
        intentOwnerMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentOwnerMain.putExtra(EMAIL, getEmail());
        startActivity(intentOwnerMain);
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }
}