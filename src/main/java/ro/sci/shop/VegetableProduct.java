package ro.sci.shop;

/**
 * Class used for the vegetable products of the store
 */
public class VegetableProduct extends Product{
    private String listOfVitamins;

    public VegetableProduct(int id, String name, double quantity, double price, double weight, String validityDate, String listOfVitamins) {
        super(id, name, quantity, price, weight, validityDate);
        this.listOfVitamins = listOfVitamins;
    }

    public String getListOfVitamins() {
        return listOfVitamins;
    }
}
