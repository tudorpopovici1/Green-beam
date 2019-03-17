package server.model;

public class Meal {

    private float dairyCalories;
    private float otherfoodCalories;
    private float fruitVegetablesCalories;
    private float cerealCalories;

    public Meal(float dairyCalories, float otherfoodCalories, float fruitVegetablesCalories, float cerealCalories) {
        this.dairyCalories = dairyCalories;
        this.otherfoodCalories = otherfoodCalories;
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
     * Gets otherfoodCalories.
     *
     * @return Value of otherfoodCalories.
     */
    public float getOtherfoodCalories() {
        return otherfoodCalories;
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
     * Sets new otherfoodCalories.
     *
     * @param otherfoodCalories New value of otherfoodCalories.
     */
    public void setOtherfoodCalories(float otherfoodCalories) {
        this.otherfoodCalories = otherfoodCalories;
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
