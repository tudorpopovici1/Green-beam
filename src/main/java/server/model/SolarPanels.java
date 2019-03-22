package server.model;

public class SolarPanels {
    private float factorOfCO2Avoidance;
    private float annualSolarEnergyProduction;

    public float getAnnualSolarEnergyProduction() {
        return annualSolarEnergyProduction;
    }

    public void setAnnualSolarEnergyProduction(float annualSolarEnergyProduction) {
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
    }

    public float getFactorOfCO2Avoidance() {
        return factorOfCO2Avoidance;
    }

    public void setFactorOfCO2Avoidance(float factorOfCO2Avoidance) {
        this.factorOfCO2Avoidance = factorOfCO2Avoidance;
    }

    public SolarPanels(float factorOfCO2Avoidance, float annualSolarEnergyProduction) {
        this.factorOfCO2Avoidance = factorOfCO2Avoidance;
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
    }


    @Override
    public String toString() {
        return "SolarPanels{" +
                "factorOfCO2Avoidance=" + factorOfCO2Avoidance +
                ", annualSolarEnergyProduction=" + annualSolarEnergyProduction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanels that = (SolarPanels) o;
        return Float.compare(that.factorOfCO2Avoidance, factorOfCO2Avoidance) == 0 &&
                Float.compare(that.annualSolarEnergyProduction, annualSolarEnergyProduction) == 0;
    }


}

