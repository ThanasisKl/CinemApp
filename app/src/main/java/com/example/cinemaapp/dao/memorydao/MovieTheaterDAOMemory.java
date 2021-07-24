package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.MovieTheaterDAO;
import com.example.cinemaapp.model.MovieTheater;

import java.util.ArrayList;

public class MovieTheaterDAOMemory implements MovieTheaterDAO {
    protected static ArrayList<MovieTheater> movieTheaterList = new ArrayList<>();
    protected static int autoIncrementId = 0;


    @Override
    public void save(MovieTheater movieTheater) {
        if(!checkIfExists(movieTheater.getId())){
            movieTheater.setId(nextId());
            movieTheaterList.add(movieTheater);
            System.out.println("(SAVE) Movie theater: " + movieTheater.getId());
        }else{
            System.out.println("(SAVE) Movie theater: " + movieTheater.getId() + " already exists");
        }


    }

    @Override
    public void delete(int movieTheaterId) {
        if(checkIfExists(movieTheaterId)){
            for (MovieTheater m : movieTheaterList) {
                if (m.getId() == movieTheaterId) {
                    movieTheaterList.remove(m);
                    break;
                }
            }
            System.out.println("(DELETE) Movie theater: " + movieTheaterId);
        }else{
            System.out.println("(DELETE) Movie theater: " + movieTheaterId + " doesn't exist");
        }

    }

    @Override
    public void update(MovieTheater movieTheater) {
        if(checkIfExists(movieTheater.getId())){
            movieTheaterList.set(movieTheater.getId(), movieTheater);
            System.out.println("(UPDATE) Movie theater: " + movieTheater.getId());
        }else{
            System.out.println("(UPDATE) Movie theater: " + movieTheater.getId() + " doesn't exist");
        }

    }

    @Override
    public MovieTheater find(String movieTheaterName) {
        for (MovieTheater m : movieTheaterList) {
            if (m.getName().equals(movieTheaterName)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public ArrayList<MovieTheater> listMovieTheaters() {
        return movieTheaterList;
    }

    public int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int movieTheaterId){
        return movieTheaterId != -1;
    }
}
