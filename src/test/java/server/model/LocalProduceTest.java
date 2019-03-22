//package server.model;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class LocalProduceTest {
//
//    LocalProduce localProduce = new LocalProduce("", "");
//    LocalProduce localProduce2 = new LocalProduce("", "");
//
//    @Test
//    public void getFoodProducedLocallyTest() {
//        String producedLocally = "abc";
//        localProduce.setFoodProducedLocally(producedLocally);
//        String expected = "abc";
//        Assert.assertEquals(expected, localProduce.getFoodProducedLocally());
//    }
//
//    @Test
//    public void setFoodProducedLocallyTest() {
//        String producedLocally = "abc";
//        localProduce.setFoodProducedLocally(producedLocally);
//        String setProducedLocally = localProduce.getFoodProducedLocally();
//        String expected = "abc";
//        Assert.assertEquals(expected, setProducedLocally);
//    }
//
//    @Test
//    public void getPackagedFoodTest() {
//        String packagedFood = "abc";
//        localProduce.setPackagedFood(packagedFood);
//        String expected = "abc";
//        Assert.assertEquals(expected, localProduce.getPackagedFood());
//    }
//
//    @Test
//    public void setPackagedFoodTest() {
//        String packagedFood = "abc";
//        localProduce.setPackagedFood(packagedFood);
//        String setPackagedFood = localProduce.getPackagedFood();
//        String expected = "abc";
//        Assert.assertEquals(expected, setPackagedFood);
//    }
//
//    @Test
//    public void toStringTest() {
//        LocalProduce localProduce = new LocalProduce("abc", "def");
//        String expected = "LocalProduce{foodProducedLocally='def', packagedFood='abc'}";
//        Assert.assertEquals(localProduce.toString(), expected);
//    }
//
//    @Test
//    public void equalsMethodSameObjectTest() {
//        localProduce.setPackagedFood("abc");
//        localProduce.setFoodProducedLocally("def");
//        localProduce2 = localProduce;
//        Assert.assertEquals(localProduce, localProduce2);
//    }
//
//    @Test
//    public void equalsMethodDifferentObjectTest() {
//        localProduce.setFoodProducedLocally("abc");
//        localProduce.setPackagedFood("def");
//        localProduce2.setFoodProducedLocally("abc");
//        localProduce2.setPackagedFood("def");
//        Assert.assertEquals(localProduce, localProduce2);
//    }
//
//    @Test
//    public void equalsMethodDifferentOtherFoodProducedLocallyTest() {
//        localProduce.setPackagedFood("abc");
//        localProduce.setFoodProducedLocally("def");
//        localProduce2.setPackagedFood("abc");
//        localProduce2.setFoodProducedLocally("ghi");
//        Assert.assertNotEquals(localProduce, localProduce2);
//    }
//
//    @Test
//    public void equalsMethodDifferentPackagedFoodTest() {
//        localProduce.setPackagedFood("abc");
//        localProduce.setFoodProducedLocally("def");
//        localProduce2.setPackagedFood("ghi");
//        localProduce2.setFoodProducedLocally("def");
//        Assert.assertNotEquals(localProduce, localProduce2);
//    }
//}