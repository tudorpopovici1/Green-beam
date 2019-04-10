package server.model;

public class SolarPanels {
    private float factorOfCO2Avoidance;
    private float annualSolarEnergyProduction;
    private int numberOfSolarPanels;

    /**
     * Creates a new SolarPanel object.
     * @param factorOfCO2Avoidance co2 avoidance
     * @param annualSolarEnergyProduction energy production
     * @param numberOfSolarPanels no of solar panels
     */

    public SolarPanels(float factorOfCO2Avoidance, float
            annualSolarEnergyProduction, int numberOfSolarPanels) {
        this.factorOfCO2Avoidance = factorOfCO2Avoidance;
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
        this.numberOfSolarPanels = numberOfSolarPanels;
    }

    public float getFactorOfCO2Avoidance() {
        return factorOfCO2Avoidance;
    }

    public void setFactorOfCO2Avoidance(float factorOfCO2Avoidance) {
        this.factorOfCO2Avoidance = factorOfCO2Avoidance;
    }

    public float getAnnualSolarEnergyProduction() {
        return annualSolarEnergyProduction;
    }

    public void setAnnualSolarEnergyProduction(float annualSolarEnergyProduction) {
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
    }

    public int getNumberOfSolarPanels() {
        return numberOfSolarPanels;
    }

    public void setNumberOfSolarPanels(int numberOfSolarPanels) {
        this.numberOfSolarPanels = numberOfSolarPanels;
    }

    @Override
    public String toString() {
        return "SolarPanels{"
                + "factorOfCO2Avoidance=" + factorOfCO2Avoidance
                + ", annualSolarEnergyProduction=" + annualSolarEnergyProduction
                + ", numberOfSolarPanels=" + numberOfSolarPanels
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
        SolarPanels that = (SolarPanels) object;
        return Float.compare(that.factorOfCO2Avoidance, factorOfCO2Avoidance) == 0
                && Float.compare(that.annualSolarEnergyProduction,
                annualSolarEnergyProduction) == 0
                && numberOfSolarPanels == that.numberOfSolarPanels;
    }
}

