package ro.sci.shop;

import org.junit.Assert;
import org.junit.Test;

public class StoreTest {

    Store store = new Store();

    @Test
    public void testStoreForAddingAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );

        //test
        store.addAnimProductToStock(animalProductToTest);

        //then
        Assert.assertEquals(store.getListOfAnimalProducts().contains(animalProductToTest), true);
    }

    @Test
    public void testStoreForAddingVegetableProduct() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C" );

        //test
        store.addVegProductToStock(vegetableProduct);

        //then
        Assert.assertEquals(store.getListOfVegetableProducts().contains(vegetableProduct), true);
    }


    @Test
    public void testStoreIncrementingQuantityForAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );
        store.addAnimProductToStock(animalProductToTest);

        //test
        store.addAnimProductToStock(animalProductToTest);


        //then
        Assert.assertTrue(store.getListOfAnimalProducts().get(0).getQuantity() == 10.0);
    }

    @Test
    public void testStoreIncrementingQuantityForVegetableProduct() {
        //given
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Apple", 5.0, 1.0, 1.0, "2018-08-14", "C" );
        store.addVegProductToStock(vegetableProduct);

        //test
        store.addVegProductToStock(vegetableProduct);

        //then
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 10.0);
    }

    @Test
    public void testValidationIsTrueAndDecrementationOfQuantityForAnimalProducts() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );
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
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );
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
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", "C" );
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
        VegetableProduct vegetableProduct = new VegetableProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", "C" );
        store.addVegProductToStock(vegetableProduct);

        //test
        boolean validated = store.validateOrder(1, 6.0);

        //then
        Assert.assertFalse(validated);
        Assert.assertTrue(store.getListOfVegetableProducts().get(0).getQuantity() == 5.0);
    }

    @Test
    public void testAddOrderToList(){
        //given
        Order order = new Order("yyyy", 1, 1.0);

        //test
        store.addOrderToList(order);

        //then
        Assert.assertTrue(store.getListOfOrders().contains(order));

    }

    @Test
    public void testIfIdExistsForAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean validated = store.productAnimalExist(1);

        //then
        Assert.assertTrue(validated);

    }

    @Test
    public void testIfIdNotExistsForAnimalProduct() {
        //given
        AnimalProduct animalProductToTest = new AnimalProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", 5.0 );
        store.addAnimProductToStock(animalProductToTest);

        //test
        boolean validated = store.productAnimalExist(2);

        //then
        Assert.assertFalse(validated);

    }

    @Test
    public void testIfIdExistsForVegetableProduct() {
        //given
        VegetableProduct vegetableProductToTest = new VegetableProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", "d" );
        store.addVegProductToStock(vegetableProductToTest);

        //test
        boolean validated = store.productVegetableExist(1);

        //then
        Assert.assertTrue(validated);

    }

    @Test
    public void testIfIdNotExistsForVegetableProduct() {
        //given
        VegetableProduct vegetableProductToTest = new VegetableProduct(1, "Egg", 5.0, 1.0, 1.0, "2018-08-14", "d" );
        store.addVegProductToStock(vegetableProductToTest);

        //test
        boolean validated = store.productVegetableExist(2);

        //then
        Assert.assertFalse(validated);

    }

}
