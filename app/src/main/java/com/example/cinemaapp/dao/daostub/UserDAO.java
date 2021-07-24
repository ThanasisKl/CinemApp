package com.example.cinemaapp.dao.daostub;

import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.Owner;
import com.example.cinemaapp.model.Staff;
import com.example.cinemaapp.model.User;

import java.util.ArrayList;

public interface UserDAO {

    /**
     //The method that saves users to the database
     * @param user
     */
    void save(User user);

    /**
     * The method that removes users from a database
     * @param userId
     */
    void delete(int userId);

    /**
     * The method that updates users from a database
     * @param user
     */
    void update(User user);

    /**
     * The method that finds users by their email
     * @param email
     * @return user or null
     */
    User find(String email);

    /**
     * The method that finds staff by their email
     * @param email
     * @return staff or null
     */
    Staff findStaff(String email);



    /**
     * The method that returns all users
     * @return all users or null
     */
    ArrayList<User> listUsers();

    /**
     * The method that returns all customers
     * @return all customers or null
     */
    ArrayList<Customer> listCustomers();

    /**
     * The method that returns all staff
     * @return all staff or null
     */
    ArrayList<Staff> listStaff();

    /**
     * The method that returns owner
     * @return owner
     */
    Owner getOwner();

    /**
     * The method that returns the premium customers
     * @return all customers that are premium
     */
    ArrayList<Customer> listAllPremiumCustomers();

    /**
     * The method that returns the no premium customers
     * @return all customers that are not premium
     */
    ArrayList<Customer> listAllNonPremiumCustomers();
}
