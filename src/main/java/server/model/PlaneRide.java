package server.model;

public class PlaneRide {
    private double distanceTraveled;
    private double emissionFactor;

    public PlaneRide(double distanceTraveled, double emissionFactor) {
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
        return "PlaneRide{"
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
        PlaneRide planeRide = (PlaneRide) object;
        return Double.compare(planeRide.distanceTraveled, distanceTraveled) == 0
                && Double.compare(planeRide.emissionFactor, emissionFactor) == 0;
    }
}
