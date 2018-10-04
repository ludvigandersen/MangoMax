package mangomax.demo.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Movie {

    private int movieId;
    private int movieDatesId;

    private String movieName;

    private String movieDescription;
    private int moviePrice;
    private int movieAgeLimit;
    private Date movieDate;
    private Cinema cinema;
    private int movieDateId;

    public Movie(int movieId, String movieName, String movieDescription, int moviePrice, int movieAgeLimit, Date movieDate, Cinema cinema, int movieDateId) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.moviePrice = moviePrice;
        this.movieAgeLimit = movieAgeLimit;
        this.movieDate = movieDate;
        this.cinema = cinema;
        this.movieDateId = movieDateId;
    }

    public Movie(int movieId, String movieName, String movieDescription, int moviePrice, int movieAgeLimit, Date movieDate, Cinema cinema) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.moviePrice = moviePrice;
        this.movieAgeLimit = movieAgeLimit;
        this.movieDate = movieDate;
        this.cinema = cinema;

    }

    public Movie(int movieDatesId) {
        this.movieDatesId = movieDatesId;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
    public int getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }
    public int getMovieAgeLimit() {
        return movieAgeLimit;
    }

    public void setMovieAgeLimit(int movieAgeLimit) {
        this.movieAgeLimit = movieAgeLimit;
    }
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public int getMovieDateId() {
        return movieDateId;
    }

    public void setMovieDateId(int movieDateId) {
        this.movieDateId = movieDateId;

    }
}
