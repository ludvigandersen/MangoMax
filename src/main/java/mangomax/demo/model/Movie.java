package mangomax.demo.model;

public class Movie {

    private int movieId;
    private String movieName;
    private String movieDescription;
    private int moviePrice;
    private int movieAgeLimit;
    private Cinema cinema;

    public Movie(int movieId, String movieName, String movieDescription,
                 int moviePrice, int movieAgeLimit, Cinema cinema) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.moviePrice = moviePrice;
        this.movieAgeLimit = movieAgeLimit;
        this.cinema = cinema;
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
}
