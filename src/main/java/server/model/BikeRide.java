package server.model;

public class BikeRide {

    private float numberOfMiles;
    private float carMileage;
    private int fuelType;

    /**
     * Creates a new BikeRide object.
     * @param numberOfMiles number of miles of car
     * @param carMileage car mileage
     * @param fuelType fuel type of car
     */

    public BikeRide(float numberOfMiles, float carMileage, int fuelType) {
        this.numberOfMiles = numberOfMiles;
        this.carMileage = carMileage;
        this.fuelType = fuelType;
    }

    public BikeRide() {}

    public float getNumberOfMiles() {
        return numberOfMiles;
    }

    public void setNumberOfMiles(float numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    public float getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(float carMileage) {
        this.carMileage = carMileage;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "bikeRide{"
                + "numberOfMiles=" + numberOfMiles
                + ", carMileage=" + carMileage
                + ", fuelType='" + fuelType + '\''
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
        BikeRide bikeRide = (BikeRide) object;
        return Float.compare(bikeRide.numberOfMiles, numberOfMiles) == 0
                && Float.compare(bikeRide.carMileage, carMileage) == 0
                && fuelType == bikeRide.fuelType;
    }
}
