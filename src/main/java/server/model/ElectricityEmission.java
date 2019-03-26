package server.model;

public class ElectricityEmission {
    private double electrictyUsage;

    public double getElectrictyUsage() {
        return electrictyUsage;
    }

    public void setElectrictyUsage(double electrictyUsage) {
        this.electrictyUsage = electrictyUsage;
    }

    public ElectricityEmission(double electrictyUsage) {
        this.electrictyUsage = electrictyUsage;
    }

    @Override
    public String toString() {
        return "ElectricityEmission{"
                + "electrictyUsage=" + electrictyUsage
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ElectricityEmission that = (ElectricityEmission) object;
        return Double.compare(that.electrictyUsage, electrictyUsage) == 0;
    }
}
