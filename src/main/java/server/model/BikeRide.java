package server.model;

import java.util.Objects;

public class BikeRide {

    private float numberOfMiles;
    private float carMileage;
    private String fuelType;

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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public BikeRide(float numberOfMiles, float carMileage, String fuelType) {
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
        if (!(o instanceof BikeRide)) return false;
        BikeRide bikeRide = (BikeRide) o;
        return Float.compare(bikeRide.getNumberOfMiles(), getNumberOfMiles()) == 0 &&
                Float.compare(bikeRide.getCarMileage(), getCarMileage()) == 0 &&
                Objects.equals(getFuelType(), bikeRide.getFuelType());
    }
}
