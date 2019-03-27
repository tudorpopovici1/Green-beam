package server.model;

public class LocalProduce {
    private double foodProducedLocally;
    private double packagedFood;

    public LocalProduce(double foodProducedLocally, double packagedFood) {
        this.foodProducedLocally = foodProducedLocally;
        this.packagedFood = packagedFood;
    }

    public double getFoodProducedLocally() {
        return foodProducedLocally;
    }

    public void setFoodProducedLocally(double foodProducedLocally) {
        this.foodProducedLocally = foodProducedLocally;
    }

    public double getPackagedFood() {
        return packagedFood;
    }

    public void setPackagedFood(double packagedFood) {
        this.packagedFood = packagedFood;
    }

    @Override
    public String toString() {
        return "LocalProduce{"
                + "foodProducedLocally=" + foodProducedLocally
                + ", packagedFood=" + packagedFood
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LocalProduce that = (LocalProduce) object;
        return Double.compare(that.foodProducedLocally, foodProducedLocally) == 0
                && Double.compare(that.packagedFood, packagedFood) == 0;
    }
}
