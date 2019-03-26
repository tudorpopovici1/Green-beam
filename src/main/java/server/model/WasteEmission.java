package server.model;

import java.util.Objects;

public class WasteEmission {
    private double wasteEmission;

    public double getWasteEmission() {
        return wasteEmission;
    }

    public void setWasteEmission(double wasteEmission) {
        this.wasteEmission = wasteEmission;
    }

    public WasteEmission(double wasteEmission) {
        this.wasteEmission = wasteEmission;
    }

    @Override
    public String toString() {
        return "WasteEmission{"
                + "wasteEmission=" + wasteEmission
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WasteEmission that = (WasteEmission) object;
        return Double.compare(that.wasteEmission, wasteEmission) == 0;
    }

}
