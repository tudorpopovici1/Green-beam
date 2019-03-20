//package server.model;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class PublicTransportationTest {
//
//    PublicTransportation publicTransportation = new PublicTransportation(0f, "");
//    PublicTransportation publicTransportation2 = new PublicTransportation(0f, "");
//
//    @Test
//    public void getMilesTraveledTest() {
//        publicTransportation.setMilesTraveled(123);
//        float numberOfMiles = publicTransportation.getMilesTraveled();
//        float expected = 123;
//        Assert.assertEquals(expected, numberOfMiles, 0);
//    }
//
//    @Test
//    public void setMilesTraveledTest() {
//        publicTransportation.setMilesTraveled(123);
//        float numberOfMiles = publicTransportation.getMilesTraveled();
//        float expected = 123;
//        Assert.assertEquals(expected, numberOfMiles, 0);
//    }
//
//    @Test
//    public void getFuelTypeTest() {
//        publicTransportation.setFuelType("Diesel");
//        String fuelType = publicTransportation.getFuelType();
//        String expected = "Diesel";
//        Assert.assertEquals(expected, fuelType);
//    }
//
//    @Test
//    public void setFuelTypeTest() {
//        publicTransportation.setFuelType("Diesel");
//        String fuelType = publicTransportation.getFuelType();
//        String expected = "Diesel";
//        Assert.assertEquals(expected, fuelType);
//    }
//
//    @Test
//    public void equalsMethodSameObjectTest() {
//        publicTransportation.setMilesTraveled(123);
//        publicTransportation.setFuelType("Diesel");
//        publicTransportation2 = publicTransportation;
//        Assert.assertEquals(publicTransportation, publicTransportation2);
//    }
//
//    @Test
//    public void equalsMethodDifferentObjectTest() {
//        publicTransportation.setMilesTraveled(123);
//        publicTransportation.setFuelType("Diesel");
//        publicTransportation2.setMilesTraveled(123);
//        publicTransportation2.setFuelType("Diesel");
//        Assert.assertEquals(publicTransportation, publicTransportation2);
//    }
//
//    @Test
//    public void equalsMethodDifferentMilesTraveledTest() {
//        publicTransportation.setMilesTraveled(123);
//        publicTransportation.setFuelType("Diesel");
//        publicTransportation2.setMilesTraveled(12323);
//        publicTransportation2.setFuelType("Diesel");
//        Assert.assertNotEquals(publicTransportation, publicTransportation2);
//    }
//
//    @Test
//    public void equalsMethodDifferentFuelTypeTest() {
//        publicTransportation.setMilesTraveled(123);
//        publicTransportation.setFuelType("Diesel");
//        publicTransportation2.setMilesTraveled(123);
//        publicTransportation2.setFuelType("Benzine");
//        Assert.assertNotEquals(publicTransportation, publicTransportation2);
//    }
//
//    @Test
//    public void toStringTest() {
//        PublicTransportation publicTransportation = new PublicTransportation(123f, "abc");
//        String expected = "PublicTransportation{milesTraveled=123.0, fuelType='abc'}";
//        Assert.assertEquals(expected, publicTransportation.toString());
//    }
//}
