package com.codeup.fortran_movies_api.web;

public class MovieDto {


//    ****PROPERTIES*******

    private int id;
    private String title;
    private String year;
    private String plot;
    private String genre;
    private String poster;
    private String rating;
    private String director;
    private String actor;

// ********CONSTRUCTOR********
 public MovieDto(int id, String title, String year, String plot, String genre, String poster, String rating, String director, String actor) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.genre = genre;
        this.poster = poster;
        this.rating = rating;
        this.director = director;
        this.actor = actor;
    }


//    ********GETTERS AND SETTERS*********


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    //    **********TO STRING**********


    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", plot='" + plot + '\'' +
                ", genre='" + genre + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}
