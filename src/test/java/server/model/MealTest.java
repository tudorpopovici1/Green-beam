package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    Meal meal = new Meal("", 0, true);

    @Test
    public void getMealNameTest() {
        String mealName = "abc";
        meal.setMealName(mealName);
        String expected = "abc";
        Assert.assertEquals(meal.getMealName(), expected);
    }

    @Test
    public void setMealNameTest() {
        String mealName = "abc";
        meal.setMealName(mealName);
        String setmealName = meal.getMealName();
        String expected = "abc";
        Assert.assertEquals(setmealName, expected);
    }

    @Test
    public void getCalories() {
        int calories = '1';
        meal.setCalories(calories);
        int expected = '1';
        Assert.assertEquals(meal.getCalories(), expected);
    }

    @Test
    public void setCalories() {
        int calories = '1';
        meal.setCalories(calories);
        int setCalories = meal.getCalories();
        int expected = '1';
        Assert.assertEquals(setCalories, expected);
    }

    @Test
    public void isVeganTest() {
        boolean vegan = true;

    }

    @Test
    public void setVeganTest() {
        meal.setVegan(true);
        boolean expected = true;
        Assert.assertEquals(meal.isVegan(), expected);
    }
}