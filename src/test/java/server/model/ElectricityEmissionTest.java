package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricityEmissionTest {

    ElectricityEmission electricityEmission = new ElectricityEmission(0.0);
    ElectricityEmission electricityEmission2 = new ElectricityEmission(0.0);

    @Test
    public void getElectricityUsageTest() {
        double electricity = 1.2;
        electricityEmission.setElectricityUsage(electricity);
        double expected = 1.2;
        Assert.assertEquals(expected, electricityEmission.getElectricityUsage(), 0);
    }

    @Test
    public void setElectricityUsageTest() {
        double electricity = 1.2;
        electricityEmission.setElectricityUsage(electricity);
        double setElectricity = electricityEmission.getElectricityUsage();
        double expected = 1.2;
        Assert.assertEquals(expected, setElectricity, 0);
    }

    @Test
    public void toStringTest() {
        ElectricityEmission electricityEmission = new ElectricityEmission(1.2);
        String expected = "ElectricityEmission{electricityUsage=1.2}";
        Assert.assertEquals(expected, electricityEmission.toString());
    }

    @Test
    public void equalsMethodSameObject() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission = electricityEmission2;
        Assert.assertEquals(electricityEmission, electricityEmission2);
    }

    @Test
    public void equalsMethodDifferentObject() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission2.setElectricityUsage(1.2);
        Assert.assertEquals(electricityEmission, electricityEmission2);
    }

    @Test
    public void equalsMethodDifferentElectricityUsageTest() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission2.setElectricityUsage(3.4);
        Assert.assertNotEquals(electricityEmission, electricityEmission2);
    }

    @Test
    public void equalsFalseTest() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission2.setElectricityUsage(3.4);
        Assert.assertEquals(false, electricityEmission.equals(electricityEmission2));
    }

    @Test
    public void equalsTrueTest() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission2.setElectricityUsage(1.2);
        Assert.assertEquals(true, electricityEmission.equals(electricityEmission2));
    }

    @Test
    public void equalsNullTest() {
        electricityEmission.setElectricityUsage(1.2);
        electricityEmission2 = null;
        Assert.assertEquals(false, electricityEmission.equals(electricityEmission2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(electricityEmission.equals(2L));
    }
}