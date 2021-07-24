package com.example.cinemaapp.model;

public class Reservation {
    private int id;
    private Customer customer;
    private int numOfSeats;
    private Slot slot;
    private Payment payment;

    public Reservation(Customer customer, int numOfSeats, Slot slot, String cardNumber) {
        this.customer = customer;
        this.numOfSeats = numOfSeats;
        this.slot = slot;
        slot.reserveSeats(numOfSeats, customer.getTypeOfUser());
        if(cardNumber != ""){
            payment = new Payment(numOfSeats*30, cardNumber);
        }else{
            System.out.println("Please pay to counter...");
        }
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }

    public void setCustomerEmail(String email) {
        this.customer.setEmail(email);
    }

    public float getPayment(){
        return payment.getAmount();
    }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

}
