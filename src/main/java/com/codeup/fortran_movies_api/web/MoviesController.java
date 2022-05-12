package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Director;
import com.codeup.fortran_movies_api.data.DirectorsRepository;
import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/movies")
public class MoviesController {


    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;


    public MoviesController(MoviesRepository moviesRepository, DirectorsRepository directorsRepository) {
        this.directorsRepository = directorsRepository;
        this.moviesRepository = moviesRepository;
    }

//************** GET ALL MOVIES ****************
    @GetMapping("all") //Path becomes: api/movies/all
    public List<Movie> getAll(){
        return moviesRepository.findAll();
    }

    //************** GET MOVIE BY ID ****************
    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        return moviesRepository.findById(id).orElse(null);

    }

    //************** GET MOVIE BY TITLE ****************
    @GetMapping("search") // /api/movies/search?title=<movieTitle>&id=<movieId>
    public List<Movie> getByTitle(@RequestParam("title") String title){
//            throws IOException{
//        try{
//            moviesRepository.findByTitle(title);
//        }catch(Exception ex){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No movie matching the title : " + title);
//        }

        return moviesRepository.findByTitle(title);
    }

    //************** GET MOVIES BY YEAR RANGE ****************
    @GetMapping("search/year") // api/movies/search/year
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear){
        return moviesRepository.findByYearRange(startYear, endYear);
    }

//    ********** GET MOVIES BY ACTORS *****************

    //    ********** GET MOVIES BY DIRECTOR *****************
    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName){
        System.out.println(directorName);
        return directorsRepository.findByName(directorName);
    }

    //************** CREATE A MOVIE ****************
    @PostMapping
    public void create(@RequestBody Movie movie){
        moviesRepository.save(movie);
    }

    //************** CREATE MULTIPLE MOVIES ****************
    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd){
        moviesRepository.saveAll(moviesToAdd);
        System.out.println(moviesToAdd);
    }

    //************** DELETE MOVIE BY ID ****************
    @DeleteMapping("{id}") /*api/movies/{id} -> api/movies/3 DELETE*/
    public void deleteById(@PathVariable int id) throws IOException {
        try {
            moviesRepository.deleteById(id);
        }catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No movie matching ID: " + id);
        }

    }

//    @PutMapping("{id}")
//    public void updateMovie(@ResponseBody Movie movie, @PathVariable int id){
//        movie.setTitle();
//        movie.setYear();
//        movie.setPlot();
//
//        moviesRepository.save(movie);
//    }



}
