package com.codeup.fortran_movies_api.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {


    //    ***********PROPERTIES************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "movies_actor",
            joinColumns =
            @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )


    //    *******BRINGS IN THE MOVIE ACTORS********

    private List<Movie> movies;

//      ***********CONSTRUCTOR*************

    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }

//           ********EMPTY CONSTRUCTOR******

    public Actor() {
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
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
