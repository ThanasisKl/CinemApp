package com.example.cinemaapp.dao.daostub;

import com.example.cinemaapp.model.Auditorium;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.Day;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.Owner;
import com.example.cinemaapp.model.Rating;
import com.example.cinemaapp.model.Reservation;
import com.example.cinemaapp.model.Slot;
import com.example.cinemaapp.model.Staff;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.model.User;

import java.util.ArrayList;

public abstract class Initialiser {

    /**
     * Removes all data
     */
    public abstract void eraseAllData();

    /**
     * Prepare some fake testing objects and add them in DAOs
     */
    public void prepareData() {
        eraseAllData();
        addMovies();
        addMovieTheaters();
        addUsers();
        addRatings();
        addReservations();
    }

    private void addUsers(){

        //Customers
        Customer customer0 = new Customer("c","1","Thanasis","Klettas");
        customer0.setTypeOfUser(TypeOfUser.PREMIUM);
        Customer customer1 = new Customer("thanasis@gmail.com","password","Thanasis","Klettas");
        customer1.setTypeOfUser(TypeOfUser.PREMIUM);
        Customer customer2 = new Customer("stelios@gmail.com","password","Stelios","Pantelopoulos");
        customer2.setTypeOfUser(TypeOfUser.NORMAL);
        Customer customer3 = new Customer("themis@gmail.com","password","Themis","Apostolopoulos");
        customer3.setTypeOfUser(TypeOfUser.PREMIUM);
        Customer customer4 = new Customer("iasonas@gmail.com","password","Iasonas","Ziogas");
        customer4.setTypeOfUser(TypeOfUser.NORMAL);

        getUserDAO().save(customer0);
        getUserDAO().save(customer1);
        getUserDAO().save(customer2);
        getUserDAO().save(customer3);
        getUserDAO().save(customer4);

        //Owner
        Owner owner = new Owner("owner@aueb.gr", "password", "George", "Papadopoulos", "0805", "1234567890");
        owner.setMovieTheaters(getMovieTheaterDAO().listMovieTheaters());
        owner.setMovies(getMovieDAO().listMovies());

        getUserDAO().save(owner);

        //Staff
        Staff staff1 = new Staff("s","1","Themistoklis","Papadopoulos",getMovieTheaterDAO().listMovieTheaters().get(0));
        Staff staff2 = new Staff("stest2@gmail.com","password","Nikolaos","Papastathopulos",getMovieTheaterDAO().listMovieTheaters().get(0));
        Staff staff3 = new Staff("stest3@gmail.com","password","Lionel","Messi",getMovieTheaterDAO().listMovieTheaters().get(1));
        Staff staff4 = new Staff("stest4@gmail.com","password","Dolores","Umbridge",getMovieTheaterDAO().listMovieTheaters().get(2));

        getUserDAO().save(staff1);
        getUserDAO().save(staff2);
        getUserDAO().save(staff3);
        getUserDAO().save(staff4);
    }

    private void addMovieTheaters(){

        //Movies
        ArrayList<Movie> list_movies = getMovieDAO().listMovies();

        //Audidoriums for cinema1
        ArrayList<Auditorium> audidoriums_list1 = new ArrayList<>();

        Auditorium auditorium1 = new Auditorium(1,30);
        Auditorium auditorium2 = new Auditorium(2,30);
        audidoriums_list1.add(auditorium1);
        audidoriums_list1.add(auditorium2);

        //Movie Theater 1
        MovieTheater movieTheater1 = new MovieTheater("Village", "Athens", audidoriums_list1 );

        //Slots for cinema1
        Slot slot1_1 = new Slot(9,list_movies.get(0),auditorium1);
        Slot slot2_1 = new Slot(11,list_movies.get(1),auditorium1);
        Slot slot3_1 = new Slot(9,list_movies.get(2),auditorium2);
        Slot slot4_1= new Slot(13,list_movies.get(3),auditorium2);
        Slot slot5_1= new Slot(15,list_movies.get(4),auditorium2);
        movieTheater1.reserveSlot(slot1_1, Day.MONDAY);
        movieTheater1.reserveSlot(slot2_1, Day.MONDAY);
        movieTheater1.reserveSlot(slot3_1, Day.FRIDAY);
        movieTheater1.reserveSlot(slot4_1, Day.SATURDAY);
        movieTheater1.reserveSlot(slot5_1, Day.SATURDAY);

        //------------------

        //Audidoriums for cinema2
        ArrayList<Auditorium> audidoriums_list2 = new ArrayList<>();
        Auditorium auditorium3 = new Auditorium(3,30);
        Auditorium auditorium4 = new Auditorium(4,30);
        audidoriums_list2.add(auditorium3);
        audidoriums_list2.add(auditorium4);

        //Movie Theater 2
        MovieTheater movieTheater2 = new MovieTheater("Cinemax", "Laurio", audidoriums_list2 );

        //Slots for cinema2
        Slot slot1_2 = new Slot(9,list_movies.get(0),auditorium4);
        Slot slot2_2 = new Slot(9,list_movies.get(1),auditorium3);
        Slot slot3_2 = new Slot(11,list_movies.get(2),auditorium3);
        Slot slot4_2= new Slot(13,list_movies.get(3),auditorium4);
        Slot slot5_2= new Slot(15,list_movies.get(4),auditorium3);
        Slot slot6_2= new Slot(11,list_movies.get(1),auditorium4);
        movieTheater2.reserveSlot(slot1_2, Day.MONDAY);
        movieTheater2.reserveSlot(slot2_2, Day.MONDAY);
        movieTheater2.reserveSlot(slot3_2, Day.FRIDAY);
        movieTheater2.reserveSlot(slot4_2, Day.SATURDAY);
        movieTheater2.reserveSlot(slot5_2, Day.SATURDAY);
        movieTheater2.reserveSlot(slot6_2, Day.SATURDAY);

        //------------------

        //Audidoriums for cinema3
        ArrayList<Auditorium> audidoriums_list3 = new ArrayList<>();
        Auditorium auditorium5 = new Auditorium(5,30);
        Auditorium auditorium6 = new Auditorium(6,30);
        audidoriums_list3.add(auditorium5);
        audidoriums_list3.add(auditorium6);

        //Movie Theater 3
        MovieTheater movieTheater3 = new MovieTheater("Flisvos", "Korinthos", audidoriums_list3);


        //Slots for cinema2
        Slot slot1_3 = new Slot(9,list_movies.get(0),auditorium5);
        Slot slot2_3 = new Slot(11,list_movies.get(1),auditorium6);
        Slot slot3_3 = new Slot(13,list_movies.get(2),auditorium6);
        Slot slot4_3 = new Slot(15,list_movies.get(3),auditorium5);
        Slot slot5_3 = new Slot(15,list_movies.get(4),auditorium6);
        movieTheater3.reserveSlot(slot1_3, Day.MONDAY);
        movieTheater3.reserveSlot(slot2_3, Day.MONDAY);
        movieTheater3.reserveSlot(slot3_3, Day.FRIDAY);
        movieTheater3.reserveSlot(slot4_3, Day.SATURDAY);
        movieTheater3.reserveSlot(slot5_3, Day.SATURDAY);

        //save Movie Theaters
        getMovieTheaterDAO().save(movieTheater1);
        getMovieTheaterDAO().save(movieTheater2);
        getMovieTheaterDAO().save(movieTheater3);
    }

    private void addMovies(){
        Movie movie1 = new Movie("Avengers Endgame", 2f);
        Movie movie2 = new Movie("Harry Potter And The Half Blood Prince ", 2f);
        Movie movie3 = new Movie("Dark Knight", 2f);
        Movie movie4 = new Movie("Inception", 2f);
        Movie movie5 = new Movie("The Pursuit Of Happiness", 2f);

        getMovieDAO().save(movie1);
        getMovieDAO().save(movie2);
        getMovieDAO().save(movie3);
        getMovieDAO().save(movie4);
        getMovieDAO().save(movie5);

    }

    private void addRatings(){

        ArrayList<Customer> customers = getUserDAO().listCustomers();

        ArrayList<Movie> list_movies = getMovieDAO().listMovies();
        Rating rating1 = new Rating((float)2.5, "Amazing movie!", customers.get(0).getFirstName(), customers.get(0).getLastName(), list_movies.get(1));
        getRatingsDAO().save(rating1);
        getMovieDAO().find(list_movies.get(1).getTitle()).addRating(rating1);

        Rating rating2 = new Rating(3, "Avengers is the best movie", customers.get(1).getFirstName(), customers.get(1).getLastName(),list_movies.get(0));
        getRatingsDAO().save(rating2);
        getMovieDAO().find(list_movies.get(0).getTitle()).addRating(rating2);

        Rating rating3 = new Rating(1, "Very nice movies i recommend", customers.get(3).getFirstName(), customers.get(3).getLastName(),list_movies.get(0));
        getRatingsDAO().save(rating3);
        getMovieDAO().find(list_movies.get(0).getTitle()).addRating(rating3);

        Rating rating4 = new Rating(0, "Nice Movie", customers.get(1).getFirstName(), customers.get(1).getLastName(),list_movies.get(2));
        getRatingsDAO().save(rating4);
        getMovieDAO().find(list_movies.get(2).getTitle()).addRating(rating4);

        Rating rating5 = new Rating(5,null, customers.get(2).getFirstName(), customers.get(4).getLastName(),list_movies.get(3));
        getRatingsDAO().save(rating5);
        getMovieDAO().find(list_movies.get(3).getTitle()).addRating(rating5);

        Rating rating6 = new Rating((float)3.5 ,null, customers.get(4).getFirstName(), customers.get(4).getLastName(),list_movies.get(4));
        getRatingsDAO().save(rating6);
        getMovieDAO().find(list_movies.get(4).getTitle()).addRating(rating6);
    }

    private void addReservations(){
        //Reservations
        ArrayList<MovieTheater> movieTheaters = getMovieTheaterDAO().listMovieTheaters();
        ArrayList<Customer> customers = getUserDAO().listCustomers();

        Reservation reservation1 = new Reservation(customers.get(2), 20, movieTheaters.get(0).getDailySchedules().get(0).getSlots().get(0), "mastercard1234");
        getReservationDAO().save(reservation1);

        Reservation reservation2 = new Reservation(customers.get(1), 10, movieTheaters.get(2).getDailySchedules().get(0).getSlots().get(1), "visa1234");
        getReservationDAO().save(reservation2);

        Reservation reservation3 = new Reservation(customers.get(2), 5, movieTheaters.get(1).getDailySchedules().get(0).getSlots().get(0), "paypal1234");
        getReservationDAO().save(reservation3);
    }

    /**
     * @return {@link User} DAO
     */
    public abstract UserDAO getUserDAO();

    /**
     * @return {@link Movie} DAO
     */
    public abstract MovieDAO getMovieDAO();

    /**
     * @return {@link MovieTheater} DAO
     */
    public abstract MovieTheaterDAO getMovieTheaterDAO();

    /**
     * @return {@link Reservation} DAO
     */
    public abstract ReservationDAO getReservationDAO();

    /**
     * @return {@link Rating} DAO
     */
    public abstract RatingsDAO getRatingsDAO();
}
