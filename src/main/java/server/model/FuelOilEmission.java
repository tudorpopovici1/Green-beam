package server.model;

public class FuelOilEmission {
    private double fuelOilUsage;

    public FuelOilEmission(double fuelOilUsage) {
        this.fuelOilUsage = fuelOilUsage;
    }

    public double getFuelOilUsage() {
        return fuelOilUsage;
    }

    public void setFuelOilUsage(double fuelOilUsage) {
        this.fuelOilUsage = fuelOilUsage;
    }

    @Override
    public String toString() {
        return "FuelOilEmission{"
                + "fuelOilUsage=" + fuelOilUsage
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
        FuelOilEmission that = (FuelOilEmission) object;
        return Double.compare(that.fuelOilUsage, fuelOilUsage) == 0;
    }
}
