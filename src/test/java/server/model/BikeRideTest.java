//package server.model;
//
//import org.junit.Assert;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class BikeRideTest {
//
//    BikeRide bike = new BikeRide(0f, 0f, 0);
//    BikeRide bike2 = new BikeRide(0f, 0f, 0);
//
//    @Test
//    public void getNumberOfMilesTest() {
//        bike.setNumberOfMiles(123);
//        float numberOfMiles = bike.getNumberOfMiles();
//        float expected = 123;
//        Assert.assertEquals(expected, numberOfMiles, 0);
//    }
//
//    @Test
//    public void setNumberOfMilesTest() {
//        bike.setNumberOfMiles(123);
//        float numberOfMiles = bike.getNumberOfMiles();
//        float expected = 123;
//        Assert.assertEquals(expected, numberOfMiles, 0);
//    }
//
//    @Test
//    public void getCarMileageTest() {
//        bike.setCarMileage(123);
//        float carMileage = bike.getCarMileage();
//        float expected = 123;
//        Assert.assertEquals(expected, carMileage, 0);
//    }
//
//    @Test
//    public void setCarMileageTest() {
//        bike.setCarMileage(123);
//        float carMileage = bike.getCarMileage();
//        float expected = 123;
//        Assert.assertEquals(expected, carMileage, 0);
//    }
//
//    @Test
//    public void getFuelTypeTest() {
//        bike.setFuelType(");
//        String fuelType = bike.getFuelType();
//        String expected = "Diesel";
//        Assert.assertEquals(expected, fuelType);
//    }
//
//    @Test
//    public void setFuelTypeTest() {
//        bike.setFuelType("Diesel");
//        String fuelType = bike.getFuelType();
//        String expected = "Diesel";
//        Assert.assertEquals(expected, fuelType);
//    }
//
//    @Test
//    public void equalsMethodSameObjectTest() {
//        bike.setCarMileage(100);
//        bike.setNumberOfMiles(100);
//        bike.setFuelType("Diesel");
//        bike2 = bike;
//        Assert.assertEquals(bike, bike2);
//    }
//
//    @Test
//    public void equalsMethodDifferentObjectTest() {
//        bike.setCarMileage(100);
//        bike.setNumberOfMiles(100);
//        bike.setFuelType("Diesel");
//        bike2.setCarMileage(100);
//        bike2.setNumberOfMiles(100);
//        bike2.setFuelType("Diesel");
//        Assert.assertEquals(bike, bike2);
//    }
//
//    @Test
//    public void equalsMethodDifferentCarMileageTest() {
//        bike.setCarMileage(200);
//        bike.setNumberOfMiles(100);
//        bike.setFuelType("Diesel");
//        bike2.setCarMileage(100);
//        bike2.setNumberOfMiles(100);
//        bike2.setFuelType("Diesel");
//        Assert.assertNotEquals(bike, bike2);
//    }
//
//    @Test
//    public void equalsMethodDifferentNumberOfMilesTest() {
//        bike.setCarMileage(100);
//        bike.setNumberOfMiles(200);
//        bike.setFuelType("Diesel");
//        bike2.setCarMileage(100);
//        bike2.setNumberOfMiles(100);
//        bike2.setFuelType("Diesel");
//        Assert.assertNotEquals(bike, bike2);
//    }
//
//    @Test
//    public void equalsMethodDifferentFuelTypeTest() {
//        bike.setCarMileage(100);
//        bike.setNumberOfMiles(100);
//        bike.setFuelType("Benzine");
//        bike2.setCarMileage(100);
//        bike2.setNumberOfMiles(100);
//        bike2.setFuelType("Diesel");
//        Assert.assertNotEquals(bike, bike2);
//    }
//
//    @Test
//    public void toStringTest() {
//        BikeRide bikeRide = new BikeRide(123f, 456f, "abc");
//        String expected = "bikeRide{numberOfMiles=123.0, carMileage=456.0, fuelType='abc'}";
//        Assert.assertEquals(expected, bikeRide.toString());
//    }
//}

