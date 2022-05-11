package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Integer> {


    List<Movie> findByTitle(String title);

    @Query(nativeQuery = true, // nativeQuery = true indicates that you want to write raw SQL
            value = "SELECT * FROM movies m WHERE m.year >= ? AND m.year <= ?;") // question marks (?) indicate that Spring should draw the actual value from your method parameters
    List<Movie> findByYearRange(Integer startYear, Integer endYear); // Order matters!

}
