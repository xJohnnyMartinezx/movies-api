package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MoviesController {


    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;
    private final ActorsRepository actorsRepository;
    private final GenresRepository genresRepository;


    public MoviesController(MoviesRepository moviesRepository, DirectorsRepository directorsRepository,
                            ActorsRepository actorsRepository, GenresRepository genresRepository) {
        this.directorsRepository = directorsRepository;
        this.moviesRepository = moviesRepository;
        this.actorsRepository = actorsRepository;
        this.genresRepository = genresRepository;
    }

//************** GET ALL MOVIES ****************
//    @GetMapping("all") //Path becomes: api/movies/all
//    public List<Movie> getAll(){
//        return moviesRepository.findAll();
//    }

    @GetMapping("all")
    public List<MovieDto> getAll(){
        List<Movie> movieEntities = moviesRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieEntities) {
            movieDtos.add(new MovieDto(movie.getId(),
                    movie.getTitle(),
                    movie.getYear(),
                    movie.getPlot(),
                    movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", ")),
                    movie.getPoster(),
                    movie.getRating(),
                    movie.getDirector().getName(),
                    movie.getActors().stream().map(Actor::getName).collect(Collectors.joining(", "))
            ));
        }
        return movieDtos;
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
    @GetMapping("search/actor")
    public List<Actor> getByActor(@RequestParam("name") String actorName){
        System.out.println(actorName);
        return actorsRepository.findByName(actorName);
    }

    //    ********** GET MOVIES BY DIRECTOR *****************
    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName){
        System.out.println(directorName);
        return directorsRepository.findByName(directorName);
    }

//    ************* GET MOVIES BY GENRE ***************
    @GetMapping("search/genre")
    public List<Genre> getByGenre(@RequestParam("name") String genreName){
        System.out.println(genreName);
        return genresRepository.findByName(genreName);
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
