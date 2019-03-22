//package server.model;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//public class SolarPanelsTest {
//    SolarPanels solarPanels = new SolarPanels(0f, 0f);
//    SolarPanels solarPanels2 = new SolarPanels(0f, 0f);
//
//    @Test
//    public void getAnnualSolarEnergyProductionTest() {
//        float annualSolarEnergy = 1234f;
//        solarPanels.setAnnualSolarEnergyProduction(annualSolarEnergy);
//        float expected = 1234f;
//        Assert.assertEquals(expected, solarPanels.getAnnualSolarEnergyProduction(), 0);
//    }
//
//    @Test
//    public void setAnnualSolarEnergyProductionTest() {
//        float annualSolarEnergy = 1234f;
//        solarPanels.setAnnualSolarEnergyProduction(annualSolarEnergy);
//        float setAnnualSolarEnergyProduction = solarPanels.getAnnualSolarEnergyProduction();
//        float expected = 1234f;
//        Assert.assertEquals(expected, setAnnualSolarEnergyProduction, 0);
//    }
//
//    @Test
//    public void getFactorOfCO2AvoidanceTest() {
//        float systemSize = 1234f;
//        solarPanels.setFactorOfCO2Avoidance(systemSize);
//        float expected = 1234f;
//        Assert.assertEquals(expected, solarPanels.getFactorOfCO2Avoidance(), 0);
//    }
//
//    @Test
//    public void setSystemSize() {
//        float systemSize = 1234f;
//        solarPanels.setSystemSize(systemSize);
//        float setSystemSize = solarPanels.getSystemSize();
//        float expected = 1234f;
//        Assert.assertEquals(expected, setSystemSize, 0);
//    }
//
//    @Test
//    public void toStringTest() {
//        SolarPanels solarPanels = new SolarPanels(1234f, 5678f);
//        String expected = "SolarPanels{systemSize=1234.0, annualSolarEnergyProduction=5678.0}";
//        Assert.assertEquals(solarPanels.toString(), expected);
//    }
//
//    @Test
//    public void equalsMethodSameObjectTest(){
//        solarPanels.setAnnualSolarEnergyProduction(1234f);
//        solarPanels.setSystemSize(5678f);
//        solarPanels = solarPanels2;
//        Assert.assertEquals(solarPanels, solarPanels2);
//    }
//
//    @Test
//    public void equalsMethodDifferentObjectTest() {
//        solarPanels.setAnnualSolarEnergyProduction(1234f);
//        solarPanels.setSystemSize(5678f);
//        solarPanels2.setAnnualSolarEnergyProduction(1234f);
//        solarPanels2.setSystemSize(5678f);
//        Assert.assertEquals(solarPanels, solarPanels2);
//    }
//
//    @Test
//    public void equalsMethodDifferentAnnualSolarEnergyProductionTest() {
//        solarPanels.setAnnualSolarEnergyProduction(1234f);
//        solarPanels.setSystemSize(5678f);
//        solarPanels2.setAnnualSolarEnergyProduction(90f);
//        solarPanels2.setSystemSize(5678f);
//        Assert.assertNotEquals(solarPanels, solarPanels2);
//    }
//
//    @Test
//    public void equalsMethodDifferentSystemSizeTest() {
//        solarPanels.setAnnualSolarEnergyProduction(1234f);
//        solarPanels.setSystemSize(5678f);
//        solarPanels2.setAnnualSolarEnergyProduction(1234f);
//        solarPanels2.setSystemSize(90f);
//        Assert.assertNotEquals(solarPanels, solarPanels2);
//    }
//
//}