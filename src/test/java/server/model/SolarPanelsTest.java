package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SolarPanelsTest {
    SolarPanels solarPanels = new SolarPanels(0f, 0f, 0);
    SolarPanels solarPanels2 = new SolarPanels(0f, 0f, 0);

    @Test
    public void getAnnualSolarEnergyProductionTest() {
        float annualSolarEnergy = 1234f;
        solarPanels.setAnnualSolarEnergyProduction(annualSolarEnergy);
        float expected = 1234f;
        Assert.assertEquals(expected, solarPanels.getAnnualSolarEnergyProduction(), 0);
    }

    @Test
    public void setAnnualSolarEnergyProductionTest() {
        float annualSolarEnergy = 1234f;
        solarPanels.setAnnualSolarEnergyProduction(annualSolarEnergy);
        float setAnnualSolarEnergyProduction = solarPanels.getAnnualSolarEnergyProduction();
        float expected = 1234f;
        Assert.assertEquals(expected, setAnnualSolarEnergyProduction, 0);
    }

    @Test
    public void getFactorOfCO2AvoidanceTest() {
        float systemSize = 1234f;
        solarPanels.setFactorOfCO2Avoidance(systemSize);
        float expected = 1234f;
        Assert.assertEquals(expected, solarPanels.getFactorOfCO2Avoidance(), 0);
    }

    @Test
    public void setFactorOfCO2AvoidanceTest() {
        float FactorOfCO2Avoidance = 1234f;
        solarPanels.setFactorOfCO2Avoidance(FactorOfCO2Avoidance);
        float setFactorOfCO2Avoidance = solarPanels.getFactorOfCO2Avoidance();
        float expected = 1234f;
        Assert.assertEquals(expected, setFactorOfCO2Avoidance, 0);
    }

    @Test
    public void getNumberOfSolarPanelsTest() {
        int numberOfSolarPanels = 1;
        solarPanels.setNumberOfSolarPanels(numberOfSolarPanels);
        int setNumberOfSolarPanels = solarPanels.getNumberOfSolarPanels();
        int expected = 1;
        Assert.assertEquals(expected, setNumberOfSolarPanels);
    }

    @Test
    public void setNumberOfSolarPanelsTest() {
        int numberOfSolarPanels = 1;
        solarPanels.setNumberOfSolarPanels(numberOfSolarPanels);
        int setNumberOfSolarPanels = solarPanels.getNumberOfSolarPanels();
        int expected = 1;
        Assert.assertEquals(expected, setNumberOfSolarPanels);
    }

    @Test
    public void toStringTest() {
        SolarPanels solarPanels = new SolarPanels(1234f, 5678f, 0);
        String expected = "SolarPanels{factorOfCO2Avoidance=1234.0, annualSolarEnergyProduction=5678.0, numberOfSolarPanels=0}";
        Assert.assertEquals(solarPanels.toString(), expected);
    }

    @Test
    public void equalsMethodSameObjectTest(){
        solarPanels.setAnnualSolarEnergyProduction(1234f);
        solarPanels.setFactorOfCO2Avoidance(5678f);
        solarPanels.setNumberOfSolarPanels(1);
        solarPanels = solarPanels2;
        Assert.assertEquals(solarPanels, solarPanels2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        solarPanels.setAnnualSolarEnergyProduction(1234f);
        solarPanels.setFactorOfCO2Avoidance(5678f);
        solarPanels.setNumberOfSolarPanels(1);
        solarPanels2.setAnnualSolarEnergyProduction(1234f);
        solarPanels2.setFactorOfCO2Avoidance(5678f);
        solarPanels2.setNumberOfSolarPanels(1);
        Assert.assertEquals(solarPanels, solarPanels2);
    }

    @Test
    public void equalsMethodDifferentAnnualSolarEnergyProductionTest() {
        solarPanels.setAnnualSolarEnergyProduction(1234f);
        solarPanels.setFactorOfCO2Avoidance(5678f);
        solarPanels.setNumberOfSolarPanels(1);
        solarPanels2.setAnnualSolarEnergyProduction(90f);
        solarPanels2.setFactorOfCO2Avoidance(5678f);
        solarPanels2.setNumberOfSolarPanels(1);
        Assert.assertNotEquals(solarPanels, solarPanels2);
    }

    @Test
    public void equalsMethodDifferentFactorOfCO2AvoidanceTest() {
        solarPanels.setAnnualSolarEnergyProduction(1234f);
        solarPanels.setFactorOfCO2Avoidance(5678f);
        solarPanels.setNumberOfSolarPanels(1);
        solarPanels2.setAnnualSolarEnergyProduction(1234f);
        solarPanels2.setFactorOfCO2Avoidance(90f);
        solarPanels2.setNumberOfSolarPanels(1);
        Assert.assertNotEquals(solarPanels, solarPanels2);
    }

    @Test
    public void equalsMethodDifferentNumberOfSolarPanelsTest() {
        solarPanels.setAnnualSolarEnergyProduction(1234f);
        solarPanels.setFactorOfCO2Avoidance(5678f);
        solarPanels.setNumberOfSolarPanels(1);
        solarPanels2.setAnnualSolarEnergyProduction(1234f);
        solarPanels2.setFactorOfCO2Avoidance(90f);
        solarPanels2.setNumberOfSolarPanels(2);
        Assert.assertNotEquals(solarPanels, solarPanels2);
    }
}