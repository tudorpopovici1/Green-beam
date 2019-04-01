package server.model;

public class TaxiRide {
    private double distanceTraveled;
    private double emissionFactor;

    public TaxiRide(double distanceTraveled, double emissionFactor) {
        this.distanceTraveled = distanceTraveled;
        this.emissionFactor = emissionFactor;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getEmissionFactor() {
        return emissionFactor;
    }

    public void setEmissionFactor(double emissionFactor) {
        this.emissionFactor = emissionFactor;
    }

    @Override
    public String toString() {
        return "TaxiRide{"
                + "distanceTraveled=" + distanceTraveled
                + ", emissionFactor=" + emissionFactor
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
        TaxiRide taxiRide = (TaxiRide) object;
        return Double.compare(taxiRide.distanceTraveled, distanceTraveled) == 0
                && Double.compare(taxiRide.emissionFactor, emissionFactor) == 0;
    }
}
