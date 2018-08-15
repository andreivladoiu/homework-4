package ro.sci.shop;

/**
 * Class used for the orders generated in case of sale
 */
public class Order {
    private String orderDate;
    private int id;
    private double quantity;

    public Order(String orderDate, int id, double quantity) {
        this.orderDate = orderDate;
        this.id = id;
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }
}
