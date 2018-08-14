package ro.sci.shop;

public class Product {

    private double price;
    private String validityDate;
    private double weight;
    private int id;
    private double quantity;
    private String name;

    public Product (int id, String name, double quantity, double price, double weight, String validityDate) {
        this.name = name;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.id = id;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void removeSoldQuantity(double quantity) {
        this.quantity = this.quantity - quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity = this.quantity + quantity;
    }

}
