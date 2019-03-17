package server.model;

import org.junit.Assert;
import org.junit.Test;

public class MealTest {

    Meal meal = new Meal (0L, 0L, 0L, 0L);

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




}