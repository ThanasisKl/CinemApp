package com.example.cinemaapp.model;

import java.io.Serializable;

public class Auditorium implements Serializable {
    private int id;
    private int capacity;


    public Auditorium(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
