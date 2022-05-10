package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {


    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }


    @GetMapping("all") //Path becomes: api/movies/all
    public List<Movie> getAll(){
//        return new ArrayList<>();
//        return sampleMovies;
        return moviesRepository.findAll();
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
//        return sampleMovies.stream().filter((movie) -> {
//                    return movie.getId() == id;
//                })
//                .findFirst()
//                .orElse(null);
        return moviesRepository.findById(id).orElse(null);

    }

    @GetMapping("{title}") // /api/movies/search?title=<movieTitle>&id=<movieId>
    public List<Movie> getByTitle(@PathVariable String title){

        return moviesRepository.findByTitle(title);
    }

    @PostMapping
    public void create(@RequestBody Movie movie){
//        System.out.println(movie);
//        add to our movies list
//        sampleMovies.add(movie);
        moviesRepository.save(movie);
    }


    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd){
        moviesRepository.saveAll(moviesToAdd);
        System.out.println(moviesToAdd);
    }

//    @PutMapping("{id}")
//    public void updateMovie(@ResponseBody Movie movie, @PathVariable int id){
//        movie.setTitle();
//        movie.setYear();
//        movie.setPlot();
//
//        moviesRepository.save(movie);
//    }





    private List<Movie> setMovies(){
        List<Movie> movies = new ArrayList<>();
//        movies.add(new Movie(1, "Pulp Fiction", "1994","Quentin Tarantino",
//                "Samuel L. Jackson, Uma Therman", "action, drama", "Plot"));
//
//        movies.add(new Movie(2,"test title","1996","test director",
//                "test actor", "drama","test plot"));
        movies.add(new Movie(1, "Pulp Fiction", "1994", "Plot"));

        movies.add(new Movie(2,"test title","1996","test plot"));
        return movies;
    }


}
