package server.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;

public class PublicTransportationTest {

    PublicTransportation publicTransportation = new PublicTransportation(0f, "");

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
    public void getFuelTypeTest() {
        publicTransportation.setFuelType("Diesel");
        String fuelType = publicTransportation.getFuelType();
        String expected = "Diesel";
        Assert.assertEquals(expected, fuelType);
    }

    @Test
    public void setFuelTypeTest() {
        publicTransportation.setFuelType("Diesel");
        String fuelType = publicTransportation.getFuelType();
        String expected = "Diesel";
        Assert.assertEquals(expected, fuelType);
    }
}
