package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private List<Movie> sampleMovies = setMovies();


    @GetMapping
    public Movie one(){
//        return new Movie(1,"test title","1996","test director", "test actor", "45", "drama","test plot");
        return sampleMovies.get(1);
    }


    @GetMapping("all") //Path becomes: api/movies/all
    public List<Movie> getAll(){
//        return new ArrayList<>();
        return sampleMovies;
    }


    private List<Movie> setMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(2, "Pulp Fiction", "1994","Quentin Tarantino", "Samule L. Jackson, Uma Therman", "15", "action, drama", "Plot"));
    }



}
