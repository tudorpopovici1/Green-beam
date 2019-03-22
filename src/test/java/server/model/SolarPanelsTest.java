package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        solarPanels.setSystemSize(123);
        float numberOfMiles = solarPanels.getSystemSize();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }
    @Test
    public void setSystemSize() {
        solarPanels.setSystemSize(123);
        float numberOfMiles = solarPanels.getSystemSize();
        float expected = 123;
        Assert.assertEquals(expected, solarPanels);
    }

}