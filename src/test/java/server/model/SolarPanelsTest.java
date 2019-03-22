package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolarPanelsTest {
SolarPanels solarPanels=new SolarPanels(0f, 0f);

    @Test
    public void getAnnualSolarEnergyProduction() {
        solarPanels.setAnnualSolarEnergyProduction(123);
        float numberOfMiles = solarPanels.getAnnualSolarEnergyProduction();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }

    @Test
    public void setAnnualSolarEnergyProduction() {
        solarPanels.setAnnualSolarEnergyProduction(123);
        float numberOfMiles = solarPanels.getAnnualSolarEnergyProduction();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }
    @Test
    public void getSystemSize() {
        solarPanels.setFactorOfCO2Avoidance(123);
        float numberOfMiles = solarPanels.getFactorOfCO2Avoidance();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }
    @Test
    public void setSystemSize() {
        solarPanels.setFactorOfCO2Avoidance(123);
        float numberOfMiles = solarPanels.getFactorOfCO2Avoidance();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }


}