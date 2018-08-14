package ro.sci.shop;

public class AnimalProduct extends Product {
    private double storageTemperature;

    public AnimalProduct(int id, String name, double quantity, double price, double weight, String validityDate, double storageTemperature) {
        super(id, name, quantity, price, weight, validityDate);
        this.storageTemperature = storageTemperature;
    }

    public double getStorageTemperature() {
        return storageTemperature;
    }
}
