package server.model;

public class MetroRide {
    private double distanceTraveled;
    private double emissionFactor;

    public MetroRide(double distanceTraveled, double emissionFactor) {
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
        return "MetroRide{"
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
        MetroRide metroRide = (MetroRide) object;
        return Double.compare(metroRide.distanceTraveled, distanceTraveled) == 0
                && Double.compare(metroRide.emissionFactor, emissionFactor) == 0;
    }
}
