package com.example.cinemaapp.model;

import java.util.ArrayList;
import java.util.List;

public class DailySchedule {

    //a slot may be during the same hour but in different auditorium
    private ArrayList<Auditorium> auditoriums;
    private ArrayList<Slot> slots;
    private Day day;

    public DailySchedule(Day day, ArrayList<Auditorium> auditoriums){
        this.day = day;
        this.auditoriums = auditoriums;
        this.slots = new ArrayList<>();

        for(Auditorium auditorium : auditoriums){
            for(int i=9; i<16; i+=2){
                slots.add(new Slot(i, null, auditorium));
            }
        }
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }

    public Day getDay(){
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void reserveSlot(int start, Auditorium auditorium, Movie movie){
        for(Slot slot : slots){
            if(slot.getAuditorium().getId() == auditorium.getId() && slot.getStart() == start){
                slot.setMovie(movie);
            }
        }
    }

    public ArrayList<Slot> getAvailableSlots() {
        ArrayList<Slot> availableSlots = new ArrayList<>();
        for(Slot slot: slots){
            if(slot.getMovie() == null){
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }

    public ArrayList<Slot> getNonAvailableSlots() {
        ArrayList<Slot> nonAvailableSlots = new ArrayList<>();
        for(Slot slot: slots){
            if(slot.getMovie() != null){
                nonAvailableSlots.add(slot);
            }
        }
        return nonAvailableSlots;
    }
}
