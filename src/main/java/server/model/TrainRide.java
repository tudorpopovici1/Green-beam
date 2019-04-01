package server.model;

public class TrainRide {
    private double distanceTraveled;
    private double emissionFactor;

    public TrainRide(double distanceTraveled, double emissionFactor) {
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
        return "TrainRide{"
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
        TrainRide trainRide = (TrainRide) object;
        return Double.compare(trainRide.distanceTraveled, distanceTraveled) == 0
                && Double.compare(trainRide.emissionFactor, emissionFactor) == 0;
    }

}
