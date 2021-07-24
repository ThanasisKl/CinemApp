package com.example.cinemaapp.model;

import java.util.ArrayList;

public class MovieTheater {
    private String name;
    private String address;
    private int id = -1;
    private ArrayList<Auditorium> auditoriums;
    private ArrayList<DailySchedule> dailySchedules;

    public MovieTheater(String name, String address, ArrayList<Auditorium> auditoriums) {
        this.name = name;
        this.address = address;
        this.auditoriums = auditoriums;
        this.dailySchedules = new ArrayList<>();

        dailySchedules.add(new DailySchedule(Day.MONDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.TUESDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.WEDNESDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.THURSDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.FRIDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.SATURDAY, auditoriums));
        dailySchedules.add(new DailySchedule(Day.SUNDAY, auditoriums));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(ArrayList<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public ArrayList<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(ArrayList<DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }

    public void reserveSlot(Slot slot, Day day){

        switch (day){
            case MONDAY:
                dailySchedules.get(0).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case TUESDAY:
                dailySchedules.get(1).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case WEDNESDAY:
                dailySchedules.get(2).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case THURSDAY:
                dailySchedules.get(3).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case FRIDAY:
                dailySchedules.get(4).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case SATURDAY :
                dailySchedules.get(5).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
            case SUNDAY:
                dailySchedules.get(6).reserveSlot(slot.getStart(), slot.getAuditorium(), slot.getMovie());
                break;
        }
    }
}
