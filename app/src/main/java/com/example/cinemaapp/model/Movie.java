package com.example.cinemaapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {

    private String title;
    private float duration;
    private int id = -1;
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Movie(String title, float duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addRating(Rating rating) {ratings.add(rating); }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

}
