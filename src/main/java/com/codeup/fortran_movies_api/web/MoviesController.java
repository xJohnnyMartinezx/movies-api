package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private List<Movie> sampleMovies = setMovies();


//    @GetMapping
//    public Movie one(){
////        return new Movie(1,"test title","1996","test director", "test actor", "45", "drama","test plot");
//        return sampleMovies.get(1);
//    }


    @GetMapping("all") //Path becomes: api/movies/all
    public List<Movie> getAll(){
//        return new ArrayList<>();
        return sampleMovies;
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return sampleMovies.stream().filter((movie) -> {
                    return movie.getId() == id;
                })
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void create(@RequestBody Movie movie){
//        System.out.println(movie);
//        add to our movies list
        sampleMovies.add(movie);
    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd){
        sampleMovies.addAll(moviesToAdd);
        System.out.println(moviesToAdd);
    }





    private List<Movie> setMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Pulp Fiction", "1994","Quentin Tarantino",
                "Samuel L. Jackson, Uma Therman", "15", "action, drama", "Plot"));

        movies.add(new Movie(2,"test title","1996","test director",
                "test actor", "45", "drama","test plot"));
        return movies;
    }


}
