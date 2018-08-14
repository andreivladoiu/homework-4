package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;

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

    public void addAnimProductToStock(AnimalProduct product) {
        boolean exists = false;

        for(AnimalProduct animalProduct : listOfAnimalProducts) {
            if(product.getId() == animalProduct.getId()) {
                animalProduct.addQuantity(product.getQuantity());
                exists = true;
            }
        }
        if(!exists) {
            listOfAnimalProducts.add(product);
        }
    }

    public void addVegProductToStock(VegetableProduct product) {
        boolean exists = false;

        for(VegetableProduct vegetableProduct : listOfVegetableProducts) {
            if(product.getId() == vegetableProduct.getId()) {
                vegetableProduct.addQuantity(product.getQuantity());
                exists = true;
           }
        }
        if(!exists) {
            listOfVegetableProducts.add(product);
        }
    }

    public void displayAnimalTable() {
        System.out.println("\nID\tName\tQuantity\tPrice\tWeight\tValidity date\tStorage temperature");
        for (AnimalProduct p :
                listOfAnimalProducts) {
            displayProdProperties(p);
            System.out.print(p.getStorageTemperature());
        }
    }

    public void displayVegetableTable() {
        System.out.println("\nID\tName\tQuantity\tPrice\tWeight\tValidity date\tList of vitamins");
        for (VegetableProduct p :
                listOfVegetableProducts) {
            displayProdProperties(p);
            System.out.print(p.getListOfVitamins());
        }
    }

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


    public void addOrderToList(Order order) {
        listOfOrders.add(order);
    }


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

    public boolean productAnimalExist(int id) {
        boolean exists = false;
        for(AnimalProduct animalProduct : listOfAnimalProducts) {
            if(id == animalProduct.getId()) {
                exists = true;
            }
        }

        return exists;
    }

    public boolean productVegetableExist(int id) {
        boolean exists = false;
        for(VegetableProduct vegetableProduct : listOfVegetableProducts) {
            if(id == vegetableProduct.getId()) {
                exists = true;
            }
        }

        return exists;
    }
}
