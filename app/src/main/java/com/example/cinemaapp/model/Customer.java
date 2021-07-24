package com.example.cinemaapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends User implements Serializable {

    private TypeOfUser typeOfUser;
    private ArrayList<Rating> ratings = new ArrayList();

    public Customer(String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName);
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }



//
//    public Rating addRating(Movie movie, int score, String text){
//        Rating rating = new Rating(score, text, movie);
//        movie.addRating(rating);
//        ratings.add(rating);
//        return rating;
//    };
//
//
//
//    //after the clients finds seats we can proceed with the reservation
//    public Reservation makeReservation(Slots slotInterested, int numberOfSeats, String cardNumber){
//        Reservation reservation = new Reservation(this, numberOfSeats, slotInterested, cardNumber);
//        return reservation;
//       }
//
//
//
//
//    //returns the slots which our movie is being played by the movie theater the user selected
//    public ArrayList<Slots> searchMovieBySlot(MovieTheater movieTheater, Movie movie){
//        ArrayList<Slots> slots = new ArrayList<Slots>();
//
//        for (Slots i: movieTheater.getDailySchedule().getSlots()){
//            if(i.getMovie().getId() == movie.getId()){
//                slots.add(i);
//            }
//        }
//        return slots;
//    };
//
//    //returns a list with the movie theaters that the movie the user is interested in is being played
//    public ArrayList<MovieTheater> searchMovieByLocation(Movie movie, ArrayList<MovieTheater> movieTheaters){
//        ArrayList<MovieTheater> availableMovieTheaters = new ArrayList<>();
//        for(MovieTheater x: movieTheaters){
//            for(Slots y: x.getDailySchedule().getSlots()){
//                if(y.getMovie().getId() == movie.getId()){
//                    availableMovieTheaters.add(x);
//                    break; //if a movie theater has a slot for that particular movie then we dont need to check the other slots:go to the next movie theater
//
//                }
//            }
//        }
//        if(availableMovieTheaters.size()==0){
//            System.out.println("The movie is not played in our theaters");
//            return null;
//        }
//        return  availableMovieTheaters;
//    };
//
//
//
//    //return a faisafe list(which contains the seats number the user will book) that if the user backs out of the reservation we can make the seats avaialble again
//    //we make the assumption that a user can only book at most 5 seats and those seats are located at the same row
//    public ArrayList<Integer> searchByRow(int numOfSeats, int row, Slots slot){
//        ArrayList<Integer> failsafe = new ArrayList<>(); // index with the rented seats
//        if(numOfSeats>5){
//            return null;
//        }
//        if(typeOfUser == TypeOfUser.NORMAL) {
//            //for normal user
//            if (row == 3 || row == 4) {
//                //normal users cant sit on those rows
//                System.out.println("You cant seat there");
//                return null;
//            }else{
//                int availableSeats = slot.findAvailableSeatsByRow(row);
//                if(availableSeats>=numOfSeats){
//                    slot.removeAvailable(numOfSeats);
//                    int rentedSeats = 0;
//                    for(int i=(row-1)*5; i<(row-1)*5 + 5; i++ ){
//                        if(slot.getSeats(i)==true){
//                            slot.removeSeat(i);
//                            failsafe.add(i);
//                            rentedSeats++;
//                        }
//                        if(rentedSeats == numOfSeats){
//                            return failsafe;
//                        }
//                    }
//                }else{
//                    return null; //no available seats for that row
//                }
//            }
//        }else{
//            //for premium
//            int availableSeats = slot.findAvailableSeatsByRow(row);
//            if(availableSeats>=numOfSeats){
//                slot.removeAvailablePremium(numOfSeats);
//                int rentedSeats = 0;
//                for(int i=(row-1)*5; i<(row-1)*5 + 5; i++ ){
//                    if(slot.getSeats(i)==true){
//                        slot.removeSeat(i);
//                        failsafe.add(i);
//                        rentedSeats++;
//                    }
//                    if(rentedSeats == numOfSeats){
//                        return failsafe;
//                    }
//                }
//            }else{
//                return null; //no available seats for that row
//            }
//
//        }
//        return null;
//    }

    //    public void removeAvailablePremium(int number){
//        availablePremium -= number;
//    }
//
//    public void removeSeat(int numOfSeat){
//        seats[numOfSeat] = false;
//    }
//
//    //finds the number of available seats in a specific row
//    public int findAvailableSeatsByRow(int row){
//        int start = (row - 1)* 5;
//        int count = 0;
//        for(int i = start; i < start+ 5; i++ ){
//            if(seats[i]==true){
//                count++;
//            }
//        }
//        return count;
//
//    }
//
//    public Boolean getSeats(int i) {
//        return seats[i];
//    }
//
//    //restore our seats if the client backs out of the transaction
//    public void restoreSeats(ArrayList<Integer> failsafe){
//
//        for(int x: failsafe ){
//            seats[x]=true;
//        }
//    }

}
