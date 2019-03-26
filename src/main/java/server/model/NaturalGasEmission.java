package server.model;

public class NaturalGasEmission {
    private double naturalGasUsage;

    public double getNaturalGasUsage() {
        return naturalGasUsage;
    }

    public void setNaturalGasUsage(double naturalGasUsage) {
        this.naturalGasUsage = naturalGasUsage;
    }

    public NaturalGasEmission(double naturalGasUsage) {
        this.naturalGasUsage = naturalGasUsage;
    }

    @Override
    public String toString() {
        return "NaturalGasEmission{"
                + "naturalGasUsage=" + naturalGasUsage
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        NaturalGasEmission that = (NaturalGasEmission) object;
        return Double.compare(that.naturalGasUsage, naturalGasUsage) == 0;
    }
}
