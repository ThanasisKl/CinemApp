package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.RatingsDAO;
import com.example.cinemaapp.model.Rating;
import java.util.ArrayList;

public class RatingsDAOMemory implements RatingsDAO {
    protected static ArrayList<Rating> ratingsList = new ArrayList<>();
    protected static int autoIncrementId = 0;


    @Override
    public void save(Rating rating) {
        if(!checkIfExists(rating.getId())){
            rating.setId(nextId());
            ratingsList.add(rating);
            System.out.println("(SAVE) Rating: " + rating.getId());
        }else{
            System.out.println("(SAVE) Rating: " + rating.getId() + " already exists");
        }
    }

    @Override
    public void delete(int ratingsId) {
        if(checkIfExists(ratingsId)){
            for (Rating r : ratingsList) {
                if (r.getId() == ratingsId) {
                    ratingsList.remove(r);
                    break;
                }
            }
            System.out.println("(DELETE) Rating: " + ratingsId);
        }else{
            System.out.println("(DELETE) Rating: " + ratingsId + " doesn't exist");
        }

    }

    @Override
    public void update(Rating rating) {
        if(checkIfExists(rating.getId())){
            ratingsList.set(rating.getId(), rating);
            System.out.println("(UPDATE) Rating: " + rating.getId());
        }else{
            System.out.println("(UPDATE) Rating: " + rating.getId() + " doesn't exist");
        }

    }

    @Override
    public Rating find(int ratingId) {
        for (Rating r : ratingsList) {
            if (r.getId() == ratingId) {
                return r;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Rating> listRatings() {
        return new ArrayList<>(ratingsList);
    }

    public int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int ratingId){
        return ratingId != -1;
    }
}
