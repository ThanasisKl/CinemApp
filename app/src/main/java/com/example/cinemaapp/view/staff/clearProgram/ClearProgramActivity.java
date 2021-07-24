package com.example.cinemaapp.view.staff.clearProgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Auditorium;

public class ClearProgramActivity extends AppCompatActivity implements ClearProgramView {

    public static final String EMAIL = "email";
    private String email;
    private static final int duration = Toast.LENGTH_LONG;
    private ClearProgramPresenter presenter;
    private int day;
    private int start;
    private Auditorium auditorium;
    private String movieTheaterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new ClearProgramPresenter(this, new UserDAOMemory(), new MovieTheaterDAOMemory());
        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);

        setTitle(presenter.findMovieTheater());
        setContentView(R.layout.activity_staff_clear_program);


    }

    @Override
    public String getEmail() {
        return email;
    }


    public String getMovieTheater(){
        return presenter.findMovieTheater();
    }

    @Override
    public void onClearSlot(int day, int start, Auditorium auditorium, String movieTheaterName) {
        this.day = day;
        this.start= start;
        this.auditorium =auditorium;
        this.movieTheaterName = movieTheaterName;
        presenter.clearMovieSlot();
        this.finish();
        startActivity(getIntent());
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public String getMovieTheaterName() {
        return movieTheaterName;
    }

    public void setMovieTheaterName(String movieTheater) {
        this.movieTheaterName = movieTheater;
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

}