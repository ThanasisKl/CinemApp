package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.ReservationDAO;
import com.example.cinemaapp.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAOMemory implements ReservationDAO {
    protected static List<Reservation> reservationList = new ArrayList<>();
    protected static int autoIncrementId = 0;

    @Override
    public void save(Reservation reservation) {
        if(!checkIfExists(reservation.getId())){
            reservation.setId(nextId());
            reservationList.add(reservation);
            System.out.println("(SAVE) Reservation: " + reservation.getId());
        }else{
            System.out.println("(SAVE) Reservation: " + reservation.getId() + " already exists");
        }

    }

    @Override
    public void delete(int reservationId) {
        if(checkIfExists(reservationId)){
            for (Reservation r : reservationList) {
                if (r.getId() == reservationId) {
                    reservationList.remove(r);
                    break;
                }
            }
            System.out.println("(DELETE) Reservation: " + reservationId);
        }else{
            System.out.println("(DELETE) Reservation: " + reservationId + " doesn't exist");
        }

    }

    @Override
    public void update(Reservation reservation) {
        if(checkIfExists(reservation.getId())){
            reservationList.set(reservation.getId(), reservation);
            System.out.println("(UPDATE) Reservation: " + reservation.getId());
        }else{
            System.out.println("(UPDATE) Reservation: " + reservation.getId() + " doesn't exist");
        }

    }

    @Override
    public Reservation find(int reservationId) {
        for (Reservation r : reservationList) {
            if (r.getId() == reservationId) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Reservation> listReservations() {
        return new ArrayList<>(reservationList);
    }


    public int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int userId){
        return userId != -1;
    }
}
