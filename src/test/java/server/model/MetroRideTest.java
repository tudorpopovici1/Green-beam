package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetroRideTest {

    MetroRide metroRide = new MetroRide(0.0, 0.0);
    MetroRide metroRide2 = new MetroRide(0.0, 0.0);

    @Test
    public void getDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        metroRide.setDistanceTraveled(distanceTraveled);
        double expected = 1.2;
        Assert.assertEquals(expected, metroRide.getDistanceTraveled(), 0);
    }

    @Test
    public void setDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        metroRide.setDistanceTraveled(distanceTraveled);
        double setDistanceTraveled = metroRide.getDistanceTraveled();
        double expected = 1.2;
        Assert.assertEquals(expected, setDistanceTraveled, 0);
    }

    @Test
    public void getEmissionFactorTest() {
        double emissionFactor = 1.2;
        metroRide.setEmissionFactor(emissionFactor);
        double expected = 1.2;
        Assert.assertEquals(expected, metroRide.getEmissionFactor(), 0);
    }

    @Test
    public void setEmissionFactorTest() {
        double emissionFactor = 1.2;
        metroRide.setEmissionFactor(emissionFactor);
        double setEmissionFactor = metroRide.getEmissionFactor();
        double expected = 1.2;
        Assert.assertEquals(expected, setEmissionFactor, 0);
    }

    @Test
    public void toStringTest() {
        MetroRide metroRide = new MetroRide(1.2, 3.4);
        String expected = "MetroRide{distanceTraveled=1.2, emissionFactor=3.4}";
        Assert.assertEquals(expected, metroRide.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide = metroRide2;
        Assert.assertEquals(metroRide, metroRide2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2.setDistanceTraveled(1.2);
        metroRide2.setEmissionFactor(3.4);
        Assert.assertEquals(metroRide, metroRide2);
    }

    @Test
    public void equalsMethodDifferentDistanceTraveledTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2.setDistanceTraveled(5.6);
        metroRide2.setEmissionFactor(3.4);
        Assert.assertNotEquals(metroRide, metroRide2);
    }

    @Test
    public void equalsMethodDifferentEmissionFactorTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2.setDistanceTraveled(1.2);
        metroRide2.setEmissionFactor(5.6);
        Assert.assertNotEquals(metroRide, metroRide2);
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(metroRide.equals(2L));
    }

    @Test
    public void equalsFalseTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2.setDistanceTraveled(1.2);
        metroRide2.setEmissionFactor(5.6);
        Assert.assertEquals(false, metroRide.equals(metroRide2));
    }

    @Test
    public void equalsTrueTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2.setDistanceTraveled(1.2);
        metroRide2.setEmissionFactor(3.4);
        Assert.assertEquals(true, metroRide.equals(metroRide2));
    }

    @Test
    public void equalsNullTest() {
        metroRide.setDistanceTraveled(1.2);
        metroRide.setEmissionFactor(3.4);
        metroRide2 = null;
        Assert.assertEquals(false, metroRide.equals(metroRide2));
    }

}