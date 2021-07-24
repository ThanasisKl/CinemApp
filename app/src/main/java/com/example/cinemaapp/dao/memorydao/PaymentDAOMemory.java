package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.PaymentDAO;
import com.example.cinemaapp.model.Payment;

import java.util.ArrayList;

public class PaymentDAOMemory implements PaymentDAO {
    
    protected static ArrayList<Payment> paymentsList = new ArrayList<>();
    protected static int autoIncrementId = 0;

    @Override
    public void save(Payment payment) {
        if(!checkIfExists(payment.getId())){
            payment.setId(nextId());
            paymentsList.add(payment);
            System.out.println("(SAVE) Payment: " + payment.getId());
        }else{
            System.out.println("(SAVE) Payment: " + payment.getId() + " already exists");
        }
        
    }
    

    @Override
    public Payment find(int amount, String creditCardNumber) {
        for (Payment p : paymentsList) {
            if (p.getAmount() == amount && p.getCardNum().equals(creditCardNumber)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Payment> list() {
        return paymentsList;
    }

    public int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int paymentId){
        return paymentId != -1;
    }
}
