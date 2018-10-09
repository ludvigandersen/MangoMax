package mangomax.demo.model;

public class Reservation {

    private int reservationId;
    private int reservationAmount;
    private int reservationTotalPrice;
    private Movie movie;
    private User user;

    public Reservation(int reservationId, int reservationAmount,
                       int reservationTotalPrice, Movie movie, User user) {
        this.reservationId = reservationId;
        this.reservationAmount = reservationAmount;
        this.reservationTotalPrice = reservationTotalPrice;
        this.movie = movie;
        this.user = user;
    }

<<<<<<< HEAD
    public Reservation() {
=======
    public Reservation(int reservationId, int reservationAmount, int reservationTotalPrice, Movie movie) {
        this.reservationId = reservationId;
        this.reservationAmount = reservationAmount;
        this.reservationTotalPrice = reservationTotalPrice;
        this.movie = movie;
>>>>>>> a56ae8042730e47f808aff9bfe2ef5ef8b316368
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(int reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public int getReservationTotalPrice() {


        return reservationTotalPrice;
    }

    public void setReservationTotalPrice(int reservationTotalPrice) {
        this.reservationTotalPrice = reservationTotalPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
