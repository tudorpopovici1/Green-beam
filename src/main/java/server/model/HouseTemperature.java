package server.model;

import java.util.Objects;

public class HouseTemperature {
    private double houseTemperature;

    public HouseTemperature(double houseTemperature) {
        this.houseTemperature = houseTemperature;
    }

    public HouseTemperature(){}

    public double getHouseTemperature() {
        return houseTemperature;
    }

    public void setHouseTemperature(double houseTemperature) {
        this.houseTemperature = houseTemperature;
    }

    @Override
    public String toString() {
        return "HouseTemperature{"
                + "houseTemperature=" + houseTemperature
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseTemperature that = (HouseTemperature) o;
        return Double.compare(that.houseTemperature, houseTemperature) == 0;
    }
}
