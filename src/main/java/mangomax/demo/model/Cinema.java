package mangomax.demo.model;

public class Cinema {

    private int cinemaId;
    private String cinemaName;
    private int cinemaSeats;

    public Cinema(int cinemaId, String cinemaName, int cinemaSeats) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaSeats = cinemaSeats;
    }

    public int getCinemaId() {
        return cinemaId;
    }
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public int getCinemaSeats() {
        return cinemaSeats;
    }
    public void setCinemaSeats(int cinemaSeats) {
        this.cinemaSeats = cinemaSeats;
    }
}
