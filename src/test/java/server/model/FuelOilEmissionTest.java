package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FuelOilEmissionTest {

    FuelOilEmission fuelOilEmission = new FuelOilEmission(0.0);
    FuelOilEmission fuelOilEmission2 = new FuelOilEmission(0.0);


    @Test
    public void getFuelOilUsageTest() {
        double fuelOil = 1.2;
        fuelOilEmission.setFuelOilUsage(fuelOil);
        double expected = 1.2;
        Assert.assertEquals(expected, fuelOilEmission.getFuelOilUsage(), 0);
    }

    @Test
    public void setFuelOilUsageTest() {
        double fuelOil = 1.2;
        fuelOilEmission.setFuelOilUsage(fuelOil);
        double setFuelOil = fuelOilEmission.getFuelOilUsage();
        double expected = 1.2;
        Assert.assertEquals(expected, setFuelOil, 0);
    }

    @Test
    public void toStringTest() {
        FuelOilEmission fuelOilEmission = new FuelOilEmission(1.2);
        String expected = "FuelOilEmission{fuelOilUsage=1.2}";
        Assert.assertEquals(expected, fuelOilEmission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        fuelOilEmission.setFuelOilUsage(1.2);
        fuelOilEmission = fuelOilEmission2;
        Assert.assertEquals(fuelOilEmission, fuelOilEmission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        fuelOilEmission.setFuelOilUsage(1.2);
        fuelOilEmission2.setFuelOilUsage(1.2);
        Assert.assertEquals(fuelOilEmission, fuelOilEmission2);
    }

    @Test
    public void equalsMethodDifferentFuelOilUsageTest() {
        fuelOilEmission.setFuelOilUsage(1.2);
        fuelOilEmission2.setFuelOilUsage(3.4);
        Assert.assertNotEquals(fuelOilEmission, fuelOilEmission2);
    }

}