package com.example.cinemaapp.view.staff.clearProgram;

import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.MovieTheater;

public class ClearProgramViewStub implements ClearProgramView{


    private ClearProgramPresenter presenter;
    private int ClearSlotClicks;
    private String email;
    private String message;
    private String movieTheaterName;
    private MovieTheater movieTheater;
    private Auditorium auditorium;
    private int Start;
    private int day;

    public void setMovieTheaterName(String movieTheaterName){
        this.movieTheaterName = movieTheaterName;
    }

    @Override
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int getStart() {
        return Start;
    }

    @Override
    public void setStart(int start) {
        Start = start;
    }


    //AUDITORIUMS
    @Override
    public Auditorium getAuditorium() {
        return auditorium;
    }

    @Override
    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    //PRESENTER

    public ClearProgramPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(ClearProgramPresenter presenter) {
        this.presenter = presenter;
    }

    //EMAIL

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {return email; }

    @Override
    public String getMovieTheaterName() {
        return movieTheaterName;
    }


    //MOVIE THEATER
    public void setMovieTheater(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }
    public MovieTheater getMovieTheater(){return movieTheater;}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getClearSlotClicks(){return ClearSlotClicks;}

    public void showMessage(String message) {
        this.message = message;
    }

    @Override
    public void onClearSlot(int day, int start, Auditorium auditorium, String movieTheaterName) {

    }


}