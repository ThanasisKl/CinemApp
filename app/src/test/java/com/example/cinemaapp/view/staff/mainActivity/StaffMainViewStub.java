package com.example.cinemaapp.view.staff.mainActivity;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaffMainViewStub implements StaffMainView {

    private int SelectMovieActivityClicks;
    private int ClearProgramActivityClicks;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String  getEmail() {return email;
    }

    public void onSelectMovie() {SelectMovieActivityClicks++;
    }

    public void onClearProgram() {ClearProgramActivityClicks++;
    }

    public int getSelectMovieActivityClicks(){return SelectMovieActivityClicks;}

    public int getClearProgramActivityClicks(){return ClearProgramActivityClicks;}

    public String getMovieTheater() {return null;
    }

}