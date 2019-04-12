package server.model;

import org.junit.Assert;
import org.junit.Test;

public class PublicTransportationTest {

    PublicTransportation publicTransportation = new PublicTransportation(0f, 0f, 0);
    PublicTransportation publicTransportation2 = new PublicTransportation(0f, 0f, 0);

    @Test
    public void getMilesTraveledTest() {
        publicTransportation.setMilesTraveled(123);
        float numberOfMiles = publicTransportation.getMilesTraveled();
        float expected = 123;
        Assert.assertEquals(expected, numberOfMiles, 0);
    }

    @Test
    public void setMilesTraveledTest() {
        publicTransportation.setMilesTraveled(123);
        float numberOfMiles = publicTransportation.getMilesTraveled();
        float expected = 123;
        Assert.assertEquals(expected, numberOfMiles, 0);
    }

    @Test
    public void getCarMileageTest() {
        publicTransportation.setCarMileage(123);
        float carMileage = publicTransportation.getCarMileage();
        float expected = 123;
        Assert.assertEquals(expected, carMileage, 0);
    }

    @Test
    public void setCarMileageTest() {
        publicTransportation.setCarMileage(123);
        float carMileage = publicTransportation.getCarMileage();
        float expected = 123;
        Assert.assertEquals(expected, carMileage, 0);
    }

    @Test
    public void getFuelTypeTest() {
        publicTransportation.setFuelType('1');
        int fuelType = publicTransportation.getFuelType();
        int expected = '1';
        Assert.assertEquals(expected, fuelType);
    }

    @Test
    public void setFuelTypeTest() {
        publicTransportation.setFuelType('1');
        int fuelType = publicTransportation.getFuelType();
        int expected = '1';
        Assert.assertEquals(expected, fuelType);
    }

    @Test
    public void equalsMethodSameObjectTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2 = publicTransportation;
        Assert.assertEquals(publicTransportation, publicTransportation2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2.setMilesTraveled(123);
        publicTransportation2.setFuelType('1');
        Assert.assertEquals(publicTransportation, publicTransportation2);
    }

    @Test
    public void equalsMethodDifferentMilesTraveledTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2.setMilesTraveled(12323);
        publicTransportation2.setFuelType('1');
        Assert.assertNotEquals(publicTransportation, publicTransportation2);
    }

    @Test
    public void equalsMethodDifferentFuelTypeTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2.setMilesTraveled(123);
        publicTransportation2.setFuelType('0');
        Assert.assertNotEquals(publicTransportation, publicTransportation2);
    }

    @Test
    public void toStringTest() {
        PublicTransportation publicTransportation = new PublicTransportation(123f, 456f, 789);
        String expected = "PublicTransportation{carMileage=123.0, milesTraveled=456.0, fuelType=789}";
        Assert.assertEquals(expected, publicTransportation.toString());
    }

    @Test
    public void equalsFalseTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2.setMilesTraveled(123);
        publicTransportation2.setFuelType('0');
        Assert.assertEquals(false, publicTransportation.equals(publicTransportation2));
    }

    @Test
    public void equalsTrueTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2.setMilesTraveled(123);
        publicTransportation2.setFuelType('1');
        Assert.assertEquals(true, publicTransportation.equals(publicTransportation2));
    }

    @Test
    public void equalsNullTest() {
        publicTransportation.setMilesTraveled(123);
        publicTransportation.setFuelType('1');
        publicTransportation2 = null;
        Assert.assertEquals(false, publicTransportation.equals(publicTransportation2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(publicTransportation.equals(2L));
    }
}
