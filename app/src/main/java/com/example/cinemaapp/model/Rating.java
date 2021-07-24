package com.example.cinemaapp.model;

import java.io.Serializable;

public class Rating implements Serializable {
    private float score;
    private String text;
    private String firstName;
    private String lastName;
    private Movie movie;
    private int id=-1;

    public Rating(float score, String text, String firstName, String lastName, Movie movie) {
        this.score = score;
        this.text = text;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movie = movie;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
