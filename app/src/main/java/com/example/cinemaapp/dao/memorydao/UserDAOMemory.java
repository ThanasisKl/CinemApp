package com.example.cinemaapp.dao.memorydao;


import com.example.cinemaapp.dao.daostub.UserDAO;
import com.example.cinemaapp.model.Customer;
import com.example.cinemaapp.model.Owner;
import com.example.cinemaapp.model.Staff;
import com.example.cinemaapp.model.TypeOfUser;
import com.example.cinemaapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMemory implements UserDAO {
    protected static List<User> usersList = new ArrayList<>();
    protected static int autoIncrementId = 0;



    @Override
    public void save(User user) {
        if(!checkIfExists(user.getId())){
            user.setId(nextId());
            usersList.add(user);
            System.out.println("(SAVE) User: " + user.getId());
        }else{
            System.out.println("(SAVE) User: " + user.getId() + " already exists");
        }

    }

    @Override
    public void delete(int userId) {
        if(checkIfExists(userId)){
            for (User u : usersList) {
                if (u.getId() == userId) {
                    usersList.remove(u);
                    break;
                }
            }
            System.out.println("(DELETE) User: " + userId);
        }else{
            System.out.println("(DELETE) User: " + userId + " doesn't exist");
        }

    }

    @Override
    public void update(User user) {
        if(checkIfExists(user.getId())){
            usersList.set(user.getId(), user);
            System.out.println("(UPDATE) User: " + user.getId());
        }else{
            System.out.println("(UPDATE) User: " + user.getId() + " doesn't exist");
        }

    }

    @Override
    public User find(String email) {
        for (User u : usersList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Staff findStaff(String email) {
        for (User u : usersList) {
            if (u instanceof Staff && u.getEmail().equals(email)) {
                return (Staff) u;
            }
        }
        return null;
    }

    @Override
    public ArrayList<User> listUsers() {
        return new ArrayList<>(usersList);
    }

    @Override
    public ArrayList<Customer> listCustomers() {
        ArrayList<Customer> customersList = new ArrayList<>();
        for(User u : usersList){
            if( u instanceof Customer){
                customersList.add((Customer)u);
            }
        }
        return customersList;
    }

    @Override
    public ArrayList<Staff> listStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();
        for(User u : usersList){
            if( u instanceof Staff){
                staffList.add((Staff)u);
            }
        }
        return staffList;
    }

    @Override
    public Owner getOwner() {
        for(User u : usersList){
            if( u instanceof Owner){
                return (Owner)u;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Customer> listAllPremiumCustomers() {
        ArrayList<Customer> customersList = listCustomers();
        ArrayList<Customer> premiumCustomersList = new ArrayList<>();
        for(Customer c : customersList){
            if(c.getTypeOfUser() == TypeOfUser.PREMIUM){
                premiumCustomersList.add(c);
            }
        }
        return premiumCustomersList;
    }

    @Override
    public ArrayList<Customer> listAllNonPremiumCustomers() {
        ArrayList<Customer> customersList = listCustomers();
        ArrayList<Customer> nonPremiumCustomersList = new ArrayList<>();
        for(Customer c : customersList){
            if(c.getTypeOfUser() == TypeOfUser.NORMAL){
                nonPremiumCustomersList.add(c);
            }
        }
        return nonPremiumCustomersList;
    }

    private int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int userId){
        return userId != -1;
    }
}
