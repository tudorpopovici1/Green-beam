package server.model;

import java.util.Objects;

public class TaxiRide {
    private double distanceTravled;
    private double emissionFactor;

    public double getDistanceTravled() {
        return distanceTravled;
    }

    public void setDistanceTravled(double distanceTravled) {
        this.distanceTravled = distanceTravled;
    }

    public double getEmissionFactor() {
        return emissionFactor;
    }

    public void setEmissionFactor(double emissionFactor) {
        this.emissionFactor = emissionFactor;
    }

    public TaxiRide(double distanceTravled, double emissionFactor) {
        this.distanceTravled = distanceTravled;
        this.emissionFactor = emissionFactor;
    }

    @Override
    public String toString() {
        return "TaxiRide{"
                +  + distanceTravled
                + ", emissionFactor=" + emissionFactor
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TaxiRide taxiRide = (TaxiRide) object;
        return Double.compare(taxiRide.distanceTravled, distanceTravled) == 0 &&
                Double.compare(taxiRide.emissionFactor, emissionFactor) == 0;
    }
}
