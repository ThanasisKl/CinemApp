package com.example.cinemaapp.util;

import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Slot;

import java.io.Serializable;

public class Slot_Day implements Serializable {
    private  Slot slot;
    private  Day day;

    public Slot_Day(Slot slot, Day day){
        this.slot = slot;
        this.day = day;
    }


    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }


}
