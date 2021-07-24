package com.example.cinemaapp.view.staff.addMovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.MovieDAOMemory;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.view.staff.mainActivity.StaffMainActivity;
import com.example.cinemaapp.view.staff.selectMovie.StaffSelectMovieActivity;

public class AddMovieActivity extends AppCompatActivity implements AddMovieView{

    private static final String MOVIE_TITLE = "MovieTitle";
    public static final String MOVIE_THEATER = "MovieTheater";
    private static final String EMAIL = "email";
    private String movieTitle, movieTheater, email;
    private AddMoviePresenter presenter;
    private static final int duration = Toast.LENGTH_LONG;
    private int day;
    private int start;
    private Movie movie;
    private Auditorium auditorium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        movieTitle = receivedIntent.getStringExtra(MOVIE_TITLE);
        movieTheater = receivedIntent.getStringExtra(MOVIE_THEATER);
        email = receivedIntent.getStringExtra(EMAIL);

        setTitle(movieTitle);
        setContentView(R.layout.activity_staff_add_movie);

        presenter = new AddMoviePresenter(this, new MovieTheaterDAOMemory(), new MovieDAOMemory());
        findMovie(movieTitle);

    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Movie getMovie() {
        return movie;
    }

    public void findMovie(String movieTitle){movie = presenter.findMovie();}

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(String movieTheaterName){this.movieTheater = movieTheaterName;}

    public String getEmail() {
        return email;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public void onAddMovie(int day, int start, Auditorium auditorium, String movieTheaterName) {
        this.day = day;
        this.start = start;
        this.auditorium = auditorium;
        this.movieTheater = movieTheaterName;
        presenter.selectMovieSlot();
        finish();
    }

    @Override
    public void showMessage(String message) {
        Toast notification = Toast.makeText(getApplicationContext(),message,duration);
        notification.show();
    }

}