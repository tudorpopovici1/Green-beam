package server.model;

import java.util.Objects;

public class LocalProduce {
    private String foodProducedLocally;
    private String packagedFood;

    public String getFoodProducedLocally() {
        return foodProducedLocally;
    }

    public void setFoodProducedLocally(String foodProducedLocally) {
        this.foodProducedLocally = foodProducedLocally;
    }

    public String getPackagedFood() {
        return packagedFood;
    }

    public void setPackagedFood(String packagedFood) {
        this.packagedFood = packagedFood;
    }

    public LocalProduce(String producedLocally, String foodProducedLocally) {
        this.packagedFood = packagedFood;
        this.foodProducedLocally = foodProducedLocally;
    }

    @Override
    public String toString() {
        return "LocalProduce{" +
                "foodProducedLocally='" + foodProducedLocally + '\'' +
                ", packagedFood='" + packagedFood + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalProduce that = (LocalProduce) o;
        return Objects.equals(foodProducedLocally, that.foodProducedLocally) &&
                Objects.equals(packagedFood, that.packagedFood);
    }
}
