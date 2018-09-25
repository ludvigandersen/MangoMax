package mangomax.demo.model;

public class Order {

    private int orderId;
    private int orderTotal;
    private Reservation reservation;

    public Order(int orderId, int orderTotal, Reservation reservation) {
        this.orderId = orderId;
        this.orderTotal = orderTotal;
        this.reservation = reservation;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
