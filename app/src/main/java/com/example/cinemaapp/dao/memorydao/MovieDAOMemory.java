package com.example.cinemaapp.dao.memorydao;

import com.example.cinemaapp.dao.daostub.MovieDAO;
import com.example.cinemaapp.model.Movie;
import com.example.cinemaapp.model.MovieTheater;
import com.example.cinemaapp.model.TypeOfUser;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOMemory implements MovieDAO {
    protected static List<Movie> movieList = new ArrayList<>();
    protected static int autoIncrementId = 0;





    @Override
    public void save(Movie movie) {
        if(!checkIfExists(movie.getId())){
            movie.setId(nextId());
            movieList.add(movie);
            System.out.println("(SAVE) Movie: " + movie.getId());
        }else{
            System.out.println("(SAVE) Movie: " + movie.getId() + " already exists");
        }
    }

    @Override
    public void delete(int movieId) {
        if(checkIfExists(movieId)){
            for (Movie m : movieList) {
                if (m.getId() == movieId) {
                    movieList.remove(m);
                    break;
                }
            }
            System.out.println("(DELETE) Movie: " + movieId);
        }else{
            System.out.println("(DELETE) Movie: " + movieId + " doesn't exist");
        }

    }
    @Override
    public void update(Movie movie) {
        if(checkIfExists(movie.getId())){
            movieList.set(movie.getId(), movie);
            System.out.println("(UPDATE) Movie: " + movie.getId());
        }else{
            System.out.println("(UPDATE) Movie: " + movie.getId() + " doesn't exist");
        }

    }

    @Override
    public Movie find(String movieTitle) {
        for (Movie m : movieList) {
            if (m.getTitle().equals(movieTitle)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Movie> listMovies() {
        return new ArrayList<>(movieList);
    }

    public int nextId() {
        autoIncrementId++;
        return autoIncrementId;
    }

    private boolean checkIfExists(int movieId){
        return movieId != -1;
    }
}
