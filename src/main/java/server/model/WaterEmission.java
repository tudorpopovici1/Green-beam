package server.model;

import java.util.Objects;

public class WaterEmission {
    private double waterEmission;

    public double getWaterEmission() {
        return waterEmission;
    }

    public void setWaterEmission(double waterEmission) {
        this.waterEmission = waterEmission;
    }

    public WaterEmission(double waterEmission) {
        this.waterEmission = waterEmission;
    }

    @Override
    public String toString() {
        return "WaterEmission{"
                + "waterEmission=" + waterEmission
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WaterEmission that = (WaterEmission) object;
        return Double.compare(that.waterEmission, waterEmission) == 0;
    }

}
