package com.codeup.fortran_movies_api.data;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    //    ***********PROPERTIES************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name="movie_genre",
            joinColumns =
            @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )


//    *******BRINGS IN THE MOVIE LIST********

    private List<Movie> movies;


    //      ***********CONSTRUCTOR*************
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }



    //           ********EMPTY CONSTRUCTOR******
    public Genre() {

    }
    public Genre(String name){
        this.name = name;
    }

    //    ****************GETTERS AND SETTERS*************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




//    *****NEED GETMOVIES GETTER FOR JACKSON TO SERIALIZE LIST OF MOVIES*****
    public List<Movie> getMovies() {
        return movies;
    }


    //    ************TOSTRING OVERRIDE************
    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
