package server.model;

import java.util.Objects;

public class PublicTransportation {
    private float milesTraveled;
    private String fuelType;

    public float getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(float milesTraveled) {
        this.milesTraveled = milesTraveled;
    }


    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "PublicTransportation{" +
                "milesTraveled=" + milesTraveled +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicTransportation that = (PublicTransportation) o;
        return Float.compare(that.milesTraveled, milesTraveled) == 0 &&
                Objects.equals(fuelType, that.fuelType);
    }
}

