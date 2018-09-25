package mangomax.demo.model;

public class Order {

    private int orderId;
    private int orderTotal;
    private int fkReservationId;

    public Order(int orderId, int orderTotal, int fkReservationId) {
        this.orderId = orderId;
        this.orderTotal = orderTotal;
        this.fkReservationId = fkReservationId;
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

    public int getFkReservationId() {
        return fkReservationId;
    }

    public void setFkReservationId(int fkReservationId) {
        this.fkReservationId = fkReservationId;
    }
}
