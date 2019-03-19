package server.model;

import org.junit.Assert;

import org.junit.Assert;
import org.junit.Test;

public class BikeRideTest {

    BikeRide bike = new BikeRide(0f, 0f, "");

    @Test
    public void getNumberOfMilesTest() {
        bike.setNumberOfMiles(123);
        float numberOfMiles = bike.getNumberOfMiles();
        float expected = 123;
        Assert.assertEquals(expected, numberOfMiles, 0);
    }

    @Test
    public void setNumberOfMilesTest() {
        bike.setNumberOfMiles(123);
        float numberOfMiles = bike.getNumberOfMiles();
        float expected = 123;
        Assert.assertEquals(expected, numberOfMiles, 0);
    }

    @Test
    public void getCarMileageTest() {
        bike.setCarMileage(123);
        float carMileage = bike.getCarMileage();
        float expected = 123;
        Assert.assertEquals(expected, carMileage, 0);
    }

    @Test
    public void setCarMileageTest() {
        bike.setCarMileage(123);
        float carMileage = bike.getCarMileage();
        float expected = 123;
        Assert.assertEquals(expected, carMileage, 0);
    }

    @Test
    public void getFuelTypeTest() {
        bike.setFuelType("Diesel");
        String fuelType = bike.getFuelType();
        String expected = "Diesel";
        Assert.assertEquals(expected, fuelType);
    }

    @Test
    public void setFuelTypeTest() {
        bike.setFuelType("Diesel");
        String fuelType = bike.getFuelType();
        String expected = "Diesel";
        Assert.assertEquals(expected, fuelType);
    }
}

