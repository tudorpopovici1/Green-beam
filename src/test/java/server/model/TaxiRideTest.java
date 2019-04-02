package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaxiRideTest {

    TaxiRide taxiRide = new TaxiRide(0.0, 0.0);
    TaxiRide taxiRide2 = new TaxiRide(0.0, 0.0);

    @Test
    public void getDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        taxiRide.setDistanceTraveled(distanceTraveled);
        double expected = 1.2;
        Assert.assertEquals(expected, taxiRide.getDistanceTraveled(), 0);
    }

    @Test
    public void setDistanceTraveledTest() {
        double distanceTraveled = 1.2;
        taxiRide.setDistanceTraveled(distanceTraveled);
        double setDistanceTraveled = taxiRide.getDistanceTraveled();
        double expected = 1.2;
        Assert.assertEquals(expected, setDistanceTraveled, 0);
    }

    @Test
    public void getEmissionFactorTest() {
        double emissionFactor = 1.2;
        taxiRide.setEmissionFactor(emissionFactor);
        double expected = 1.2;
        Assert.assertEquals(expected, taxiRide.getEmissionFactor(), 0);
    }

    @Test
    public void setEmissionFactorTest() {
        double emissionFactor = 1.2;
        taxiRide.setEmissionFactor(emissionFactor);
        double setEmissionFactor = taxiRide.getEmissionFactor();
        double expected = 1.2;
        Assert.assertEquals(expected, setEmissionFactor, 0);
    }

    @Test
    public void toStringTest() {
        TaxiRide taxiRide = new TaxiRide(1.2, 3.4);
        String expected = "TaxiRide{distanceTraveled=1.2, emissionFactor=3.4}";
        Assert.assertEquals(expected, taxiRide.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide = taxiRide2;
        Assert.assertEquals(taxiRide, taxiRide2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2.setDistanceTraveled(1.2);
        taxiRide2.setEmissionFactor(3.4);
        Assert.assertEquals(taxiRide, taxiRide2);
    }

    @Test
    public void equalsMethodDifferentDistanceTraveledTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2.setDistanceTraveled(5.6);
        taxiRide2.setEmissionFactor(3.4);
        Assert.assertNotEquals(taxiRide, taxiRide2);
    }

    @Test
    public void equalsMethodDifferentEmissionFactorTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2.setDistanceTraveled(1.2);
        taxiRide2.setEmissionFactor(5.6);
        Assert.assertNotEquals(taxiRide, taxiRide2);
    }

    @Test
    public void equalsFalseTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2.setDistanceTraveled(1.2);
        taxiRide2.setEmissionFactor(5.6);
        Assert.assertEquals(false, taxiRide.equals(taxiRide2));
    }

    @Test
    public void equalsTrueTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2.setDistanceTraveled(1.2);
        taxiRide2.setEmissionFactor(3.4);
        Assert.assertEquals(true, taxiRide.equals(taxiRide2));
    }

    @Test
    public void equalsNullTest() {
        taxiRide.setDistanceTraveled(1.2);
        taxiRide.setEmissionFactor(3.4);
        taxiRide2 = null;
        Assert.assertEquals(false, taxiRide.equals(taxiRide2));
    }

}