package com.example.cinemaapp.view.staff.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemaapp.R;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.view.main.mainActivity.MainActivity;
import com.example.cinemaapp.view.staff.selectMovie.StaffSelectMovieActivity;
import com.example.cinemaapp.view.staff.clearProgram.ClearProgramActivity;

import java.util.Calendar;

public class StaffMainActivity extends AppCompatActivity implements  StaffMainView{

    public static final String EMAIL = "email";
    private Button addMovieButton;
    private Button manageProgramButton;
    private StaffMainPresenter presenter;
    private String email, welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new StaffMainPresenter(this, new UserDAOMemory());

        Intent receivedIntent = getIntent();
        email = receivedIntent.getStringExtra(EMAIL);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour < 12){
            welcome = getString(R.string.good_morning_welcome_message);
        }else{
            welcome = getString(R.string.good_evening_welcome_message);
        }

        setContentView(R.layout.activity_staff_main);
        setTitle(welcome + " " + presenter.getFirstName());


        addMovieButton = findViewById(R.id.staff_main_page_add_movie_button);
        addMovieButton.setOnClickListener(v -> {
            presenter.addMovie();
        });

        manageProgramButton = findViewById(R.id.staff_main_page_clear_program_button);
        manageProgramButton.setOnClickListener(v -> {
            presenter.ClearProgram();
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
    public void onSelectMovie() {
        Intent intentSelectMovie = new Intent(this, StaffSelectMovieActivity.class);
        intentSelectMovie.putExtra(EMAIL, getEmail());
        startActivity(intentSelectMovie);

    }

    @Override
    public void onClearProgram() {
        Intent intentManageProgram = new Intent(this, ClearProgramActivity.class);
        intentManageProgram.putExtra(EMAIL, getEmail());
        startActivity(intentManageProgram);
    }

    @Override
    public String getEmail() { return email; }

    @Override
    public String getMovieTheater() {
        return presenter.findMovieTheater();
    }


}