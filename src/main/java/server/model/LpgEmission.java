package server.model;

public class LpgEmission {
    private double lpgEmission;

    public LpgEmission(double lpgEmission) {
        this.lpgEmission = lpgEmission;
    }

    public double getLpgEmission() {
        return lpgEmission;
    }

    public void setLpgEmission(double lpgEmission) {
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
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LpgEmission that = (LpgEmission) object;
        return Double.compare(that.lpgEmission, lpgEmission) == 0;
    }

}
