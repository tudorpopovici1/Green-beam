package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainRideTest {

    TrainRide trainRide = new TrainRide(0.0, 0.0);
    TrainRide trainRide2 = new TrainRide(0.0, 0.0);

    @Test
    public void getDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        trainRide.setDistanceTraveled(distanceTraveled);
        double expected = 1.2;
        Assert.assertEquals(expected, trainRide.getDistanceTraveled(), 0);
    }

    @Test
    public void setDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        trainRide.setDistanceTraveled(distanceTraveled);
        double setDistanceTraveled = trainRide.getDistanceTraveled();
        double expected = 1.2;
        Assert.assertEquals(expected, setDistanceTraveled, 0);
    }

    @Test
    public void getEmissionFactorTest() {
        double emissionFactor = 1.2;
        trainRide.setEmissionFactor(emissionFactor);
        double expected = 1.2;
        Assert.assertEquals(expected, trainRide.getEmissionFactor(), 0);
    }

    @Test
    public void setEmissionFactorTest() {
        double emissionFactor = 1.2;
        trainRide.setEmissionFactor(emissionFactor);
        double setEmissionFactor = trainRide.getEmissionFactor();
        double expected = 1.2;
        Assert.assertEquals(expected, setEmissionFactor, 0);
    }

    @Test
    public void toStringTest() {
        TrainRide trainRide = new TrainRide(1.2, 3.4);
        String expected = "TrainRide{distanceTraveled=1.2, emissionFactor=3.4}";
        Assert.assertEquals(expected, trainRide.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide = trainRide2;
        Assert.assertEquals(trainRide, trainRide2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2.setDistanceTraveled(1.2);
        trainRide2.setEmissionFactor(3.4);
        Assert.assertEquals(trainRide, trainRide2);
    }

    @Test
    public void equalsMethodDifferentDistanceTraveledTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2.setDistanceTraveled(5.6);
        trainRide2.setEmissionFactor(3.4);
        Assert.assertNotEquals(trainRide, trainRide2);
    }

    @Test
    public void equalsMethodDifferentEmissionFactorTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2.setDistanceTraveled(1.2);
        trainRide2.setEmissionFactor(5.6);
        Assert.assertNotEquals(trainRide, trainRide2);
    }

    @Test
    public void equalsFalseTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2.setDistanceTraveled(1.2);
        trainRide2.setEmissionFactor(5.6);
        Assert.assertEquals(false, trainRide.equals(trainRide2));
    }

    @Test
    public void equalsTrueTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2.setDistanceTraveled(1.2);
        trainRide2.setEmissionFactor(3.4);
        Assert.assertEquals(true, trainRide.equals(trainRide2));
    }

    @Test
    public void equalsNullTest() {
        trainRide.setDistanceTraveled(1.2);
        trainRide.setEmissionFactor(3.4);
        trainRide2 = null;
        Assert.assertEquals(false, trainRide.equals(trainRide2));
    }
}