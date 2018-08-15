package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for the lists of products/orders and related methods
 */
public class Store {
    private List<AnimalProduct> listOfAnimalProducts = new ArrayList<>();
    private List<VegetableProduct> listOfVegetableProducts = new ArrayList<>();
    private List<Order> listOfOrders = new ArrayList<>();

    public List<AnimalProduct> getListOfAnimalProducts() {
        return listOfAnimalProducts;
    }

    public List<VegetableProduct> getListOfVegetableProducts() {
        return listOfVegetableProducts;
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    /**
     * In case of existing id i, increments stock with the quantity q and does not create a new product
     */
    public boolean increaseStockIfProdExists(int i, double q) {
        boolean onStock = false;
        for (AnimalProduct p :
                listOfAnimalProducts) {
            if (p.getId() == i) {
                onStock = true;
                System.out.println("The product with id " + i + " already exists. We will increment quantity with value " + q);
                p.addQuantity(q);
                break;
            }
        }
        if (onStock == false) {
            for (VegetableProduct p :
                    listOfVegetableProducts) {
                if (p.getId() == i) {
                    onStock = true;
                    System.out.println("The product with id " + i + " already exists. We will increment quantity with value " + q);
                    p.addQuantity(q);
                    break;
                }
            }
        }
        return onStock;
    }

    /**
     * Adds new animal product to the list
     */
    public void addAnimProductToStock(AnimalProduct product) {
        listOfAnimalProducts.add(product);
    }

    /**
     * Adds new vegetable product to the list
     */
    public void addVegProductToStock(VegetableProduct product) {
        listOfVegetableProducts.add(product);
    }

    /**
     * Displays a table of the animal products in stock
     */
    public void displayAnimalTable() {
        System.out.println("\nID\tName\tQuantity\tPrice\tWeight\tValidity date\tStorage temperature");
        for (AnimalProduct p :
                listOfAnimalProducts) {
            displayProdProperties(p);
            System.out.print(p.getStorageTemperature());
        }
    }


    /**
     * Displays a table of the vegetable products in stock
     */
    public void displayVegetableTable() {
        System.out.println("\n\nID\tName\tQuantity\tPrice\tWeight\tValidity date\tList of vitamins");
        for (VegetableProduct p :
                listOfVegetableProducts) {
            displayProdProperties(p);
            System.out.print(p.getListOfVitamins());
        }
    }

    /**
     * Checks if the requested product is on stock in the requested quantity and if it is, decrements the stock with the quantity
     */
    public boolean validateOrder(int i, double q) {
        boolean onStock = false;
        for (AnimalProduct p :
                listOfAnimalProducts) {
            if (p.getId() == i) {
                if (p.getQuantity() >= q) {
                    onStock = true;
                    p.removeSoldQuantity(q);
                    break;
                }
            }
        }
        if (onStock == false) {
            for (VegetableProduct p :
                    listOfVegetableProducts) {
                if (p.getId() == i) {
                    if (p.getQuantity() >= q) {
                        onStock = true;
                        p.removeSoldQuantity(q);
                        break;
                    }
                }
            }
        }
        return onStock;
    }

    /**
     * Adds orders to the list
     */
    public void addOrderToList(Order order) {
        listOfOrders.add(order);
    }

    /**
     * Displays a table of the orders from a certain date
     */
    public void displayOrderList(String date) {
        System.out.println("Order date\tID\tQuantity");
        for (Order o :
                listOfOrders) {
            if (date.equals(o.getOrderDate())) {
                System.out.print("\n");
                System.out.print(o.getOrderDate());
                System.out.print("\t");
                System.out.print(o.getId());
                System.out.print("\t");
                System.out.print(o.getQuantity());
            }
        }
    }

    /**
     * Displays the table of the animal/ vegetable products without the last field (storageTemperature/ listOfVitamins)
     */
    public void displayProdProperties(Product product) {
        System.out.print("\n");
        System.out.print(product.getId());
        System.out.print("\t");
        System.out.print(product.getName());
        System.out.print("\t");
        System.out.print(product.getQuantity());
        System.out.print("\t");
        System.out.print(product.getPrice());
        System.out.print("\t");
        System.out.print(product.getWeight());
        System.out.print("\t");
        System.out.print(product.getValidityDate());
        System.out.print("\t");
    }
}
