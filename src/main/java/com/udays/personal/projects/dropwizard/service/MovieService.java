package com.udays.personal.projects.dropwizard.service;

import com.udays.personal.projects.dropwizard.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"movie1","director1",2000));
        return movies;
    }

}
