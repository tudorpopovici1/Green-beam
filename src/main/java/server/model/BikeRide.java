package server.model;

import java.util.Objects;

public class BikeRide {

    private float numberOfMiles;
    private float carMileage;
    private int fuelType;

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

    public BikeRide(float numberOfMiles, float carMileage, int fuelType) {
        this.numberOfMiles = numberOfMiles;
        this.carMileage = carMileage;
        this.fuelType = fuelType;
    }

    public BikeRide() {}

    @Override
    public String toString() {
        return "bikeRide{" +
                "numberOfMiles=" + numberOfMiles +
                ", carMileage=" + carMileage +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeRide bikeRide = (BikeRide) o;
        return Float.compare(bikeRide.numberOfMiles, numberOfMiles) == 0 &&
                Float.compare(bikeRide.carMileage, carMileage) == 0 &&
                fuelType == bikeRide.fuelType;
    }
}
