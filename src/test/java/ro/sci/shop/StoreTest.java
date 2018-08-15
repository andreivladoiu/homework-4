package ro.sci.shop;

import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    Store store = new Store();

    @Test
    public void testStoreForAddingAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0);

        //test
        store.addAnimProductToStock(animalProductToTest);

        //then
        Assert.assertEquals(store.getListOfAnimalProducts().contains(animalProductToTest), true);
    }

    @Test
    public void testStoreForAddingVegetableProduct() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C");

        //test
        store.addVegProductToStock(vegetableProduct);

        //then
        Assert.assertEquals(store.getListOfVegetableProducts().contains(vegetableProduct), true);
    }


    @Test
    public void testStoreProductIsOnStockAndIncrementionOfQuantityForAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0);
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean onStock =  store.increaseStockIfProdExists(1, 3.0);


        //then
        Assert.assertTrue(onStock);
        Assert.assertTrue(store.getListOfAnimalProducts().get(0).getQuantity() == 8.0);
    }


    @Test
    public void testStoreProductIsNotOnStockAndIncrementionOfQuantityForAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0);
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean onStock =  store.increaseStockIfProdExists(2, 3.0);


        //then
        Assert.assertFalse(onStock);
        Assert.assertTrue(store.getListOfAnimalProducts().get(0).getQuantity() == 5.0);
    }


    @Test
    public void testStoreProductIsOnStockAndIncrementationOfQuantityForVegetableProduct() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C");
        store.addVegProductToStock(vegetableProduct);

        //test
        boolean onStock = store.increaseStockIfProdExists(1,10);

        //then
        Assert.assertTrue(onStock);
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 15.0);
    }


    @Test
    public void testStoreProductIsNotOnStockAndIncrementationOfQuantityForVegetableProduct() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C");
        store.addVegProductToStock(vegetableProduct);

        //test
        boolean onStock = store.increaseStockIfProdExists(2,10);

        //then
        Assert.assertFalse(onStock);
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 5.0);
    }


    @Test
    public void testValidationIsTrueAndDecrementationOfQuantityForAnimalProducts() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0);
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean validated = store.validateOrder(1, 1.0);

        //then
        Assert.assertTrue(validated);
        Assert.assertTrue(store.getListOfAnimalProducts().get(0).getQuantity() == 4.0);
    }

    @Test
    public void testValidationIsFalseAndDecrementationOfQuantityForAnimalProducts() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0);
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean validated = store.validateOrder(1, 6.0);

        //then
        Assert.assertFalse(validated);
        Assert.assertTrue(store.getListOfAnimalProducts().get(0).getQuantity() == 5.0);
    }

    @Test
    public void testValidationIsTrueAndDecrementationOfQuantityForVegetableProducts() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C");
        store.addVegProductToStock(vegetableProduct);

        //test
        boolean validated = store.validateOrder(1, 1.0);

        //then
        Assert.assertTrue(validated);
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 4.0);
    }

    @Test
    public void testValidationIsFalseAndDecrementationOfQuantityForVegetableProducts() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C");
        store.addVegProductToStock(vegetableProduct);

        //test
        boolean validated = store.validateOrder(1, 6.0);

        //then
        Assert.assertFalse(validated);
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 5.0);
    }

    @Test
    public void testAddOrderToList() {
        //given
        Order order = new Order("yyyy-mm-dd", 1, 1.0);

        //test
        store.addOrderToList(order);

        //then
        Assert.assertTrue(store.getListOfOrders().contains(order));

    }

}
