package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalProduceTest {

    LocalProduce localProduce = new LocalProduce(0.0, 0.0);
    LocalProduce localProduce2 = new LocalProduce(0.0, 0.0);

    @Test
    public void getFoodProducedLocallyTest() {
        Double producedLocally = 1.2;
        localProduce.setFoodProducedLocally(producedLocally);
        Double setFoodProducedLocally = localProduce.getFoodProducedLocally();
        Double expected = 1.2;
        Assert.assertEquals(expected, setFoodProducedLocally);
    }

    @Test
    public void setFoodProducedLocallyTest() {
        Double producedLocally = 1.2;
        localProduce.setFoodProducedLocally(producedLocally);
        Double setProducedLocally = localProduce.getFoodProducedLocally();
        Double expected = 1.2;
        Assert.assertEquals(expected, setProducedLocally);
    }

    @Test
    public void getPackagedFoodTest() {
        Double packaged = 1.2;
        localProduce.setPackagedFood(packaged);
        Double setPackaged = localProduce.getPackagedFood();
        Double expected = 1.2;
        Assert.assertEquals(expected, setPackaged);
    }

    @Test
    public void setPackagedFoodTest() {
        Double packaged = 1.2;
        localProduce.setPackagedFood(packaged);
        Double setPackaged = localProduce.getPackagedFood();
        Double expected = 1.2;
        Assert.assertEquals(expected, setPackaged);
    }

    @Test
    public void toStringTest() {
        LocalProduce localProduce = new LocalProduce(1.2, 3.4);
        String expected = "LocalProduce{foodProducedLocally=1.2, packagedFood=3.4}";
        Assert.assertEquals(localProduce.toString(), expected);
    }

    @Test
    public void equalsMethodSameObjectTest() {
        localProduce.setPackagedFood(1.2);
        localProduce.setFoodProducedLocally(3.4);
        localProduce2 = localProduce;
        Assert.assertEquals(localProduce, localProduce2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        localProduce.setFoodProducedLocally(1.2);
        localProduce.setPackagedFood(3.4);
        localProduce2.setFoodProducedLocally(1.2);
        localProduce2.setPackagedFood(3.4);
        Assert.assertEquals(localProduce, localProduce2);
    }

    @Test
    public void equalsMethodDifferentOtherFoodProducedLocallyTest() {
        localProduce.setPackagedFood(1.2);
        localProduce.setFoodProducedLocally(3.4);
        localProduce2.setPackagedFood(1.2);
        localProduce2.setFoodProducedLocally(5.6);
        Assert.assertNotEquals(localProduce, localProduce2);
    }

    @Test
    public void equalsMethodDifferentPackagedFoodTest() {
        localProduce.setPackagedFood(1.2);
        localProduce.setFoodProducedLocally(3.4);
        localProduce2.setPackagedFood(5.6);
        localProduce2.setFoodProducedLocally(3.4);
        Assert.assertNotEquals(localProduce, localProduce2);
    }
}