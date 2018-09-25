package mangomax.demo.model;

public class Reservation {

    private int reservationId;
    private int reservationAmount;
    private int reservationTotalPrice;

    private int fkMovieDateId;
    private int fkCustomerId;


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

    public int getFkMovieDateId() {
        return fkMovieDateId;
    }

    public void setFkMovieDateId(int fkMovieDateId) {
        this.fkMovieDateId = fkMovieDateId;
    }

    public int getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(int fkCustomerId) {
        this.fkCustomerId = fkCustomerId;
    }
}
