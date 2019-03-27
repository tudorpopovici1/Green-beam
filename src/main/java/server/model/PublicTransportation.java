package server.model;

public class PublicTransportation {
    private float carMileage;
    private float milesTraveled;
    private int fuelType;

    /**
     * Creates a new PublicTransportation object.
     * @param carMileage car mileage
     * @param milesTraveled miles traveled
     * @param fuelType fueltype.
     */

    public PublicTransportation(float carMileage, float milesTraveled, int fuelType) {
        this.carMileage = carMileage;
        this.milesTraveled = milesTraveled;
        this.fuelType = fuelType;
    }

    public float getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(float milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public float getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(float carMileage) {
        this.carMileage = carMileage;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }


    @Override
    public String toString() {
        return "PublicTransportation{"
                + "carMileage=" + carMileage
                + ", milesTraveled=" + milesTraveled
                + ", fuelType=" + fuelType
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
        PublicTransportation that = (PublicTransportation) object;
        return Float.compare(that.carMileage, carMileage) == 0
                && Float.compare(that.milesTraveled, milesTraveled) == 0
                && fuelType == that.fuelType;
    }
}

