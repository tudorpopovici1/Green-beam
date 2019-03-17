package server.model;

public class Meal {

    private float dairyCalories;
    private float otherFoodCalories;
    private float fruitVegetablesCalories;
    private float cerealCalories;

    /**
     * Meal of object constructor.
     * @param dairyCalories - calories (parameter)
     * @param otherFoodCalories - calories (parameter)
     * @param fruitVegetablesCalories - calories (parameter)
     * @param cerealCalories - calories (parameter)
     */
    public Meal(float dairyCalories, float otherFoodCalories,
                float fruitVegetablesCalories, float cerealCalories) {
        this.dairyCalories = dairyCalories;
        this.otherFoodCalories = otherFoodCalories;
        this.fruitVegetablesCalories = fruitVegetablesCalories;
        this.cerealCalories = cerealCalories;
    }


    /**
     * Sets new fruitVegetablesCalories.
     *
     * @param fruitVegetablesCalories New value of fruitVegetablesCalories.
     */
    public void setFruitVegetablesCalories(float fruitVegetablesCalories) {
        this.fruitVegetablesCalories = fruitVegetablesCalories;
    }

    /**
     * Gets dairyCalories.
     *
     * @return Value of dairyCalories.
     */
    public float getDairyCalories() {
        return dairyCalories;
    }

    /**
     * Gets otherFoodCalories.
     *
     * @return Value of otherFoodCalories.
     */
    public float getOtherFoodCalories() {
        return otherFoodCalories;
    }

    /**
     * Sets new cerealCalories.
     *
     * @param cerealCalories New value of cerealCalories.
     */
    public void setCerealCalories(float cerealCalories) {
        this.cerealCalories = cerealCalories;
    }

    /**
     * Sets new otherFoodCalories.
     *
     * @param otherFoodCalories New value of otherFoodCalories.
     */
    public void setOtherFoodCalories(float otherFoodCalories) {
        this.otherFoodCalories = otherFoodCalories;
    }

    /**
     * Gets fruitVegetablesCalories.
     *
     * @return Value of fruitVegetablesCalories.
     */
    public float getFruitVegetablesCalories() {
        return fruitVegetablesCalories;
    }

    /**
     * Sets new dairyCalories.
     *
     * @param dairyCalories New value of dairyCalories.
     */
    public void setDairyCalories(float dairyCalories) {
        this.dairyCalories = dairyCalories;
    }

    /**
     * Gets cerealCalories.
     *
     * @return Value of cerealCalories.
     */
    public float getCerealCalories() {
        return cerealCalories;
    }
}
