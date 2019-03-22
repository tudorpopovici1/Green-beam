package server.model;

public class SolarPanels {
    private float factorOfCO2Avoidance;
    private float annualSolarEnergyProduction;
    private int numberOfSolarPanels;

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

    public int getNumberOfSolarPanels() { return numberOfSolarPanels; }

    public void setNumberOfSolarPanels(int numberOfSolarPanels) {
        this.numberOfSolarPanels = numberOfSolarPanels;
    }

    public SolarPanels(float factorOfCO2Avoidance, float annualSolarEnergyProduction, int numberOfSolarPanels) {
        this.factorOfCO2Avoidance = factorOfCO2Avoidance;
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
        this.numberOfSolarPanels = numberOfSolarPanels;
    }

    @Override
    public String toString() {
        return "SolarPanels{" +
                "factorOfCO2Avoidance=" + factorOfCO2Avoidance +
                ", annualSolarEnergyProduction=" + annualSolarEnergyProduction +
                ", numberOfSolarPanels=" + numberOfSolarPanels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanels that = (SolarPanels) o;
        return Float.compare(that.factorOfCO2Avoidance, factorOfCO2Avoidance) == 0 &&
                Float.compare(that.annualSolarEnergyProduction, annualSolarEnergyProduction) == 0 &&
                numberOfSolarPanels == that.numberOfSolarPanels;
    }
}

