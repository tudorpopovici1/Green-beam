package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocalProduceTest {

    LocalProduce localProduce = new LocalProduce("", "");

    @Test
    public void getFoodProducedLocallyTest() {
        String producedLocally = "abc";
        localProduce.setFoodProducedLocally(producedLocally);
        String expected = "abc";
        Assert.assertEquals(expected, localProduce.getFoodProducedLocally());
    }

    @Test
    public void setFoodProducedLocallyTest() {
        String producedLocally = "abc";
        localProduce.setFoodProducedLocally(producedLocally);
        String setProducedLocally = localProduce.getFoodProducedLocally();
        String expected = "abc";
        Assert.assertEquals(expected, setProducedLocally);
    }

    @Test
    public void getPackagedFoodTest() {
        String packagedFood = "abc";
        localProduce.setPackagedFood(packagedFood);
        String expected = "abc";
        Assert.assertEquals(expected, localProduce.getPackagedFood());
    }

    @Test
    public void setPackagedFoodTest() {
        String packagedFood = "abc";
        localProduce.setPackagedFood(packagedFood);
        String setPackagedFood = localProduce.getPackagedFood();
        String expected = "abc";
        Assert.assertEquals(expected, setPackagedFood);
    }
}