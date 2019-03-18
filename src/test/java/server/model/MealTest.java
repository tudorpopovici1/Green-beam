package server.model;

import org.junit.Assert;
import org.junit.Test;

public class MealTest {

    Meal meal = new Meal (0L, 0L, 0L, 0L);
    Meal meal2 = new Meal (0L, 0L, 0L, 0L);

    @Test
    public void getFruitVegetableCaloriesTest() {
        meal.setFruitVegetablesCalories(10);
        float mealCalories = meal.getFruitVegetablesCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void setFruitVegetableCaloriesTest() {
        meal.setFruitVegetablesCalories(10);
        float mealCalories = meal.getFruitVegetablesCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void getCerealCaloriesTest() {
        meal.setCerealCalories(10);
        float mealCalories = meal.getCerealCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void setCerealCaloriesTest() {
        meal.setCerealCalories(10);
        float mealCalories = meal.getCerealCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void getDairyCaloriesTest() {
        meal.setDairyCalories(10);
        float mealCalories = meal.getDairyCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void setDairyCaloriesTest() {
        meal.setDairyCalories(10);
        float mealCalories = meal.getDairyCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void getOtherFoodCaloriesTest() {
        meal.setOtherFoodCalories(10);
        float mealCalories = meal.getOtherFoodCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void setOtherFoodCaloriesTest() {
        meal.setOtherFoodCalories(10);
        float mealCalories = meal.getOtherFoodCalories();
        float expected = 10;
        Assert.assertEquals(mealCalories, expected, 0);
    }

    @Test
    public void toStringTest() {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(15);
        String expected = "Meal{dairyCalories=13.0, otherFoodCalories=12.0, fruitVegetablesCalories=14.0, cerealCalories=15.0}";
        Assert.assertEquals(expected, meal.toString());
    }

    @Test
    public void equalsMethodSameObjectTest()  {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(15);
        meal2 = meal;
        Assert.assertEquals(meal, meal2);
    }

    @Test
    public void equalsMethodDifferentObjectTest()  {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(15);
        meal2.setOtherFoodCalories(12);
        meal2.setDairyCalories(13);
        meal2.setFruitVegetablesCalories(14);
        meal2.setCerealCalories(15);
        Assert.assertEquals(meal, meal2);
    }

    @Test
    public void equalsMethodDifferentOtherFoodCaloriesTest()  {
        meal.setOtherFoodCalories(13);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(15);
        meal2.setOtherFoodCalories(12);
        meal2.setDairyCalories(13);
        meal2.setFruitVegetablesCalories(14);
        meal2.setCerealCalories(15);
        Assert.assertNotEquals(meal, meal2);
    }

    @Test
    public void equalsMethodDifferentDairyCaloriesTest()  {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(133);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(15);
        meal2.setOtherFoodCalories(12);
        meal2.setDairyCalories(13);
        meal2.setFruitVegetablesCalories(14);
        meal2.setCerealCalories(15);
        Assert.assertNotEquals(meal, meal2);
    }

    @Test
    public void equalsMethodDifferentFruitVegetablesCaloriesTest()  {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(144);
        meal.setCerealCalories(15);
        meal2.setOtherFoodCalories(12);
        meal2.setDairyCalories(13);
        meal2.setFruitVegetablesCalories(14);
        meal2.setCerealCalories(15);
        Assert.assertNotEquals(meal, meal2);
    }

    @Test
    public void equalsMethodDifferentCerealCaloriesTest() {
        meal.setOtherFoodCalories(12);
        meal.setDairyCalories(13);
        meal.setFruitVegetablesCalories(14);
        meal.setCerealCalories(154);
        meal2.setOtherFoodCalories(12);
        meal2.setDairyCalories(13);
        meal2.setFruitVegetablesCalories(14);
        meal2.setCerealCalories(15);
        Assert.assertNotEquals(meal, meal2);
    }
}