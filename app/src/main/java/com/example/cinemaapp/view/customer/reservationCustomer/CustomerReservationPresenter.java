package com.example.cinemaapp.view.customer.reservationCustomer;

import android.util.Log;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.DailySchedule;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.model.User;
import com.example.cinemaapp.view.customer.CustomerSelectSlot.CustomerSelectSlotView;

import java.util.ArrayList;

public class CustomerReservationPresenter {

    CustomerReservationView view;
    MovieTheaterDAOMemory movieTheaters;
    private int seats;
    private String movieTheater;
    private Slot slotSelected;
    private Day selectedDay;
    private UserDAOMemory users;

    public CustomerReservationPresenter(CustomerReservationView view, MovieTheaterDAOMemory movieTheaters, UserDAOMemory users) {
        this.view = view;
        this.movieTheaters = movieTheaters;
        this.users = users;
    }

    public Boolean findAvailability2(String email) {
        seats = view.getSeats();
        movieTheater = view.getMovieTheaterName();
        slotSelected = view.getSelectedSlot();
        selectedDay = view.getSelectedDay();
        ArrayList<MovieTheater> allMovieTheaters = movieTheaters.listMovieTheaters();

        for(MovieTheater theater :allMovieTheaters){
            if(theater.getName().equals(movieTheater)){
                for (DailySchedule daily :theater.getDailySchedules()){
                    for(Slot slot : daily.getNonAvailableSlots()){
                        if(slot.getStart()==slotSelected.getStart() && slot.getAuditorium().getId()==slotSelected.getAuditorium().getId() && slot.getMovie().getId()==slotSelected.getMovie().getId()){
                            if(findTypeOfUserFromEmail(email)){//premium
                                if(seats > slot.getAvailablePremium()+slot.getAvailable()){
                                    return false;
                                }else{
                                    return true;
                                }
                            }else {
                                if (seats > slot.getAvailable()) {//not premium
                                    return false;
                                } else {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean findTypeOfUserFromEmail(String email){
        ArrayList<Customer> allPremiums = users.listAllPremiumCustomers();
        for(Customer customer :allPremiums){
            if(customer.getEmail().equals(email)){
                if(customer.getTypeOfUser().toString().equals(TypeOfUser.PREMIUM.toString())){
                    return true;//premium
                }
            }
        }
        return false;//not premium
    }
}
