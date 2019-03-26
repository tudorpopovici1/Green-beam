package server.model;

import java.util.Objects;

public class LPGEmission {
    private double lpgEmission;

    public double getLpgEmission() {
        return lpgEmission;
    }

    public void setLpgEmission(double lpgEmission) {
        this.lpgEmission = lpgEmission;
    }

    public LPGEmission(double lpgEmission) {
        this.lpgEmission = lpgEmission;
    }

    @Override
    public String toString() {
        return "LPGEmission{"
                + "lpgEmission=" + lpgEmission
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LPGEmission that = (LPGEmission) object;
        return Double.compare(that.lpgEmission, lpgEmission) == 0;
    }

}
