package server.model;

public class ElectricityEmission {
    private double electricityUsage;

    public double getElectricityUsage() {
        return electricityUsage;
    }

    public void setElectricityUsage(double electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    public ElectricityEmission(double electricityUsage) {
        this.electricityUsage = electricityUsage;
    }

    @Override
    public String toString() {
        return "ElectricityEmission{"
                + "electricityUsage=" + electricityUsage
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ElectricityEmission that = (ElectricityEmission) object;
        return Double.compare(that.electricityUsage, electricityUsage) == 0;
    }
}
