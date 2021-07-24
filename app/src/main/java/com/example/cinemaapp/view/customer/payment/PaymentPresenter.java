package com.example.cinemaapp.view.customer.payment;

import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.PaymentDAOMemory;
import com.example.cinemaapp.dao.memorydao.ReservationDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.DailySchedule;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.Payment;
import com.example.cinemaapp.model.Reservation;
import com.example.cinemaapp.model.Slot;

public class PaymentPresenter {

    private PaymentView view;
    private PaymentDAOMemory payments;
    private UserDAOMemory users;
    private ReservationDAOMemory reservations;
    private MovieTheaterDAOMemory movieTheaters;

    public PaymentPresenter(PaymentView view, PaymentDAOMemory payments, UserDAOMemory users, ReservationDAOMemory reservations, MovieTheaterDAOMemory movieTheaters) {
        this.view = view;
        this.payments = payments;
        this.users = users;
        this.reservations = reservations;
        this.movieTheaters = movieTheaters;
    }

    public void executePaymentBookSeats() {
        payments.save(new Payment(view.getAmount(), view.getCreditCardNumber()));
        Customer customer = (Customer) users.find(view.getEmail());

        Reservation reservation = new Reservation(customer, view.getSeats(), findSlot(), view.getCreditCardNumber());
        saveReservation(reservation);
        view.showMessage("Reservation Completed");
        view.onCustomerMain();
    }

    public void executePaymentSignUp(){
        payments.save(new Payment(view.getAmount(), view.getCreditCardNumber()));
        view.showMessage("Successfull Sign up, Welcome!");
        view.onCustomerMain();
    }



    public Slot findSlot(){
        for(MovieTheater movie_theater :movieTheaters.listMovieTheaters()){
            if(movie_theater.getName().equals(view.getMovieTheaterName())){
                for (DailySchedule daily :movie_theater.getDailySchedules()){
                    for(Slot slot : daily.getNonAvailableSlots()){
                        if(slot.getStart()==view.getSlot_Day().getSlot().getStart() && slot.getAuditorium().getId()==view.getSlot_Day().getSlot().getAuditorium().getId()
                                && slot.getMovie().getId()==view.getSlot_Day().getSlot().getMovie().getId() && daily.getDay() == view.getSlot_Day().getDay()) {
                            return slot;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void saveReservation(Reservation reservation){
        reservations.save(reservation);
    }


}
