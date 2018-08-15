package ro.sci.shop;

import java.util.Scanner;

/**
 * Program which simulates the operations at a store
 */

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        initialStock(store);

        boolean doAgain = true;

        do {
            System.out.println("\n");
            System.out.println("1. Create product and add it to stock");
            System.out.println("2. Sell product");
            System.out.println("3. Display daily sales report");
            System.out.println("4. Exit");
            System.out.println("Choose option (1/2/3/4):");
            Scanner keyboard = new Scanner(System.in);
            int option = keyboard.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Input product ID:");
                    int id = keyboard.nextInt();

                    System.out.println("Input quantity:");
                    Double quantity = keyboard.nextDouble();

                    if (store.increaseStockIfProdExists(id, quantity))
                        break;

                    keyboard.nextLine();
                    System.out.println("Input product name:");
                    String name = keyboard.nextLine();


                    System.out.println("Input price:");
                    Double price = keyboard.nextDouble();

                    System.out.println("Input weight:");
                    Double weight = keyboard.nextDouble();

                    keyboard.nextLine();
                    System.out.println("Input validity date (yyyy-mm-dd):");
                    String validityDate = keyboard.nextLine();

                    System.out.println("Input product type (1 - animal; 2 - vegetable):");
                    int type = keyboard.nextInt();

                    if (type == 1) {
                        System.out.println("Input storage temperature:");
                        Double storageTemperature = keyboard.nextDouble();
                        AnimalProduct prod = new AnimalProduct(id, name, quantity, price, weight, validityDate, storageTemperature);
                        store.addAnimProductToStock(prod);
                    } else if (type == 2) {
                        System.out.println("Input list of vitamins:");
                        keyboard.nextLine();
                        String listOfVitamins = keyboard.nextLine();
                        VegetableProduct prod = new VegetableProduct(id, name, quantity, price, weight, validityDate, listOfVitamins);
                        store.addVegProductToStock(prod);
                    } else
                        System.out.println("There is no such product type");
                    break;
                case 2:
                    store.displayAnimalTable();
                    store.displayVegetableTable();
                    System.out.println("\n");
                    System.out.println("Input product ID:");
                    int i = keyboard.nextInt();
                    System.out.println("Input quantity:");
                    Double q = keyboard.nextDouble();
                    if (store.validateOrder(i, q)) {
                        System.out.println("The product is on stock. Input order date (yyyy-mm-dd):");
                        keyboard.nextLine();
                        String orderDate = keyboard.nextLine();
                        Order ord = new Order(orderDate, i, q);
                        store.addOrderToList(ord);
                    } else
                        System.out.println("The requested product/quantity is not on stock");
                    break;
                case 3:
                    System.out.println("Input sales date (yyyy-mm-dd):");
                    keyboard.nextLine();
                    String salesDate = keyboard.nextLine();
                    store.displayOrderList(salesDate);
                    break;
                case 4:
                    System.out.println("You selected exit");
                    doAgain = false;
                    break;
                default:
                    System.out.println("There is no such option");

            }
        } while (doAgain);
    }

    /**
     * Initialises the stock with the products mentioned in the project requirements
     */
    private static void initialStock(Store store) {
        AnimalProduct milk = new AnimalProduct(375, "milk", 30.0, 2.0, 1.0, "2018-08-20", 4.0);
        store.addAnimProductToStock(milk);
        AnimalProduct egg = new AnimalProduct(224, "egg", 100.0, 0.50, 0.050, "2018-08-18", 5.0);
        store.addAnimProductToStock(egg);
        AnimalProduct cheese = new AnimalProduct(173, "cheese", 5.7, 22.0, 1.0, "2018-09-15", 7.0);
        store.addAnimProductToStock(cheese);
        AnimalProduct yogurt = new AnimalProduct(582, "yogurt", 24, 3.25, 0.2, "2018-09-10", 4.0);
        store.addAnimProductToStock(yogurt);
        AnimalProduct sourCream = new AnimalProduct(829, "sour cream", 12.0, 5.0, 0.150, "2018-09-12", 4.0);
        store.addAnimProductToStock(sourCream);
    }
}