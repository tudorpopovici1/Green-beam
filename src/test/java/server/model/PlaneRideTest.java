package server.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;

public class PlaneRideTest {

    PlaneRide planeRide = new PlaneRide(0.0, 0.0);
    PlaneRide planeRide2 = new PlaneRide(0.0, 0.0);

    @Test
    public void getDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        planeRide.setDistanceTraveled(distanceTraveled);
        double expected = 1.2;
        Assert.assertEquals(expected, planeRide.getDistanceTraveled(), 0);
    }

    @Test
    public void setDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        planeRide.setDistanceTraveled(distanceTraveled);
        double setDisistanceTraveled = planeRide.getDistanceTraveled();
        double expected = 1.2;
        Assert.assertEquals(expected, setDisistanceTraveled, 0);
    }

    @Test
    public void getEmissionFactorTest() {
        double emissionFactor = 1.2;
        planeRide.setEmissionFactor(emissionFactor);
        double expected = 1.2;
        Assert.assertEquals(expected, planeRide.getEmissionFactor(), 0);
    }

    @Test
    public void setEmissionFactorTest() {
        double emissionFactor = 1.2;
        planeRide.setEmissionFactor(emissionFactor);
        double setEmissionFactor = planeRide.getEmissionFactor();
        double expected = 1.2;
        Assert.assertEquals(expected, setEmissionFactor, 0);
    }

    @Test
    public void toStringTest() {
        PlaneRide planeRide = new PlaneRide(1.2, 3.4);
        String expected = "PlaneRide{distanceTraveled=1.2, emissionFactor=3.4}";
        Assert.assertEquals(expected, planeRide.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setDistanceTraveled(3.4);
        planeRide = planeRide2;
        Assert.assertEquals(planeRide, planeRide2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2.setDistanceTraveled(1.2);
        planeRide2.setEmissionFactor(3.4);
        Assert.assertEquals(planeRide, planeRide2);
    }

    @Test
    public void equalsMethodDifferentDistanceTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2.setDistanceTraveled(5.6);
        planeRide2.setEmissionFactor(3.4);
        Assert.assertNotEquals(planeRide, planeRide2);
    }

    @Test
    public void equalsMethodDifferentEmissionTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2.setDistanceTraveled(1.2);
        planeRide2.setEmissionFactor(5.6);
        Assert.assertNotEquals(planeRide, planeRide2);
    }

    @Test
    public void equalsFalseTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2.setDistanceTraveled(1.2);
        planeRide2.setEmissionFactor(5.6);
        Assert.assertEquals(false, planeRide.equals(planeRide2));
    }

    @Test
    public void equalsTrueTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2.setDistanceTraveled(1.2);
        planeRide2.setEmissionFactor(3.4);
        Assert.assertEquals(true, planeRide.equals(planeRide2));
    }

    @Test
    public void equalsNullTest() {
        planeRide.setDistanceTraveled(1.2);
        planeRide.setEmissionFactor(3.4);
        planeRide2 = null;
        Assert.assertEquals(false, planeRide.equals(planeRide2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(planeRide.equals(2L));
    }
}