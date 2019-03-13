package server.model;

public class Meal {
    private String mealName;
    private int calories;
    private boolean isVegan;

    public Meal(String mealName, int calories, boolean isVegan) {
        this.mealName = mealName;
        this.calories = calories;
        this.isVegan = isVegan;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String toString() {
        return "Meal{"
                + "mealName='" + mealName + '\''
                + ", calories=" + calories
                + ", isVegan=" + isVegan
                + '}';
    }
}
