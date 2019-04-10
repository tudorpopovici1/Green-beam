package server.model;

public class HouseTemperature {
    private double houseTemperatureBefore;
    private double getHouseTemperatureAfter;

    public HouseTemperature(double houseTemperatureBefore, double getHouseTemperatureAfter) {
        this.houseTemperatureBefore = houseTemperatureBefore;
        this.getHouseTemperatureAfter = getHouseTemperatureAfter;
    }

    public HouseTemperature(){}

    public double getHouseTemperatureBefore() {
        return houseTemperatureBefore;
    }

    public void setHouseTemperatureBefore(double houseTemperatureBefore) {
        this.houseTemperatureBefore = houseTemperatureBefore;
    }

    public double getGetHouseTemperatureAfter() {
        return getHouseTemperatureAfter;
    }

    public void setGetHouseTemperatureAfter(double getHouseTemperatureAfter) {
        this.getHouseTemperatureAfter = getHouseTemperatureAfter;
    }

    @Override
    public String toString() {
        return "HouseTemperature{"
                + "houseTemperatureBefore=" + houseTemperatureBefore
                + ", getHouseTemperatureAfter=" + getHouseTemperatureAfter
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
        HouseTemperature that = (HouseTemperature) object;
        return Double.compare(that.houseTemperatureBefore, houseTemperatureBefore) == 0
                && Double.compare(that.getHouseTemperatureAfter, getHouseTemperatureAfter) == 0;
    }
}