package com.example.cinemaapp.view.owner.addStaff;

import com.example.cinemaapp.dao.daostub.MovieTheaterDAO;
import com.example.cinemaapp.dao.daostub.UserDAO;
import com.example.cinemaapp.dao.memorydao.MovieTheaterDAOMemory;
import com.example.cinemaapp.dao.memorydao.UserDAOMemory;
import com.example.cinemaapp.model.Staff;

public class AddStaffPresenter {

    private AddStaffView view;
    private UserDAO users;
    private MovieTheaterDAO movieTheaters;
    private Staff staff;
    private String email, password, firstName, lastName, movieTheater;

    AddStaffPresenter(AddStaffView view, UserDAOMemory users, MovieTheaterDAOMemory movieTheaters){
        this.view = view;
        this.users = users;
        this.movieTheaters = movieTheaters;
    }

    public void addStaff() {
        email = view.getEmail();
        password = view.getPassword();
        firstName = view.getFirstName();
        lastName = view.getLastName();
        movieTheater = view.getMovieTheater();


        if(checkForEmptyFields()){
            view.showMessage("Please complete all fields");
        }else if(checkIfEmailExists()){
            view.showMessage("Email already used");
        }else{
            if(checkIfMovieTheaterExists()) {
                staff = new Staff(email, password, firstName, lastName, movieTheaters.find(movieTheater));
                users.save(staff);
                view.showMessage("Successfull addition!");
                view.onOwnerMain();

            }
            else{
                view.showMessage("Incorrect Movie Theater...");
            }
        }
    }

    private boolean checkIfMovieTheaterExists() {
        if (movieTheaters.find(movieTheater) != null) {
            return true;
        }else {
            return false;
        }
    }

    private boolean checkForEmptyFields() {
        return email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || movieTheater.isEmpty();
    }

    private boolean checkIfEmailExists(){
        if(users.find(email) != null){
            return true;
        }else{
            return false;
        }
    }
}
