package server.model;

import java.util.Objects;

public class SolarPanels {
    private float systemSize;
    private float annualSolarEnergyProduction;

    public float getAnnualSolarEnergyProduction() {
        return annualSolarEnergyProduction;
    }

    public void setAnnualSolarEnergyProduction(float annualSolarEnergyProduction) {
        this.annualSolarEnergyProduction = annualSolarEnergyProduction;
    }

    public float getSystemSize() {
        return systemSize;
    }

    public void setSystemSize(float systemSize) {
        this.systemSize = systemSize;
    }

    public SolarPanels(float systemSize) {
        this.systemSize = systemSize;
    }


    @Override
    public String toString() {
        return "SolarPanels{" +
                "systemSize=" + systemSize +
                ", annualSolarEnergyProduction=" + annualSolarEnergyProduction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolarPanels that = (SolarPanels) o;
        return Float.compare(that.systemSize, systemSize) == 0 &&
                Float.compare(that.annualSolarEnergyProduction, annualSolarEnergyProduction) == 0;
    }

    
}

