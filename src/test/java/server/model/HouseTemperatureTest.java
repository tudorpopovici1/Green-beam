package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTemperatureTest {

    HouseTemperature houseTemperature = new HouseTemperature();
    HouseTemperature houseTemperature2 = new HouseTemperature();

    @Test
    public void getHouseTemperatureBeforeTest() {
        double temperature = 1.2;
        houseTemperature.setHouseTemperatureBefore(temperature);
        double expected = 1.2;
        Assert.assertEquals(expected, houseTemperature.getHouseTemperatureBefore(), 0);
    }

    @Test
    public void setHouseTemperatureBeforeTest() {
        double temperature = 1.2;
        houseTemperature.setHouseTemperatureBefore(temperature);
        double setTemperature = houseTemperature.getHouseTemperatureBefore();
        double expected = 1.2;
        Assert.assertEquals(expected, setTemperature, 0);
    }

    @Test
    public void getGetHouseTemperatureAfterTest() {
        double temperature = 1.2;
        houseTemperature.setGetHouseTemperatureAfter(temperature);
        double expected = 1.2;
        Assert.assertEquals(expected, houseTemperature.getGetHouseTemperatureAfter(), 0);
    }

    @Test
    public void setGetHouseTemperatureAfterTest() {
        double temperature = 1.2;
        houseTemperature.setGetHouseTemperatureAfter(temperature);
        double setTemperature = houseTemperature.getGetHouseTemperatureAfter();
        double expected = 1.2;
        Assert.assertEquals(expected, setTemperature, 0);
    }

    @Test
    public void toStringTest() {
        HouseTemperature houseTemperature = new HouseTemperature(1.2, 3.4);
        String expected = "HouseTemperature{houseTemperatureBefore=1.2, getHouseTemperatureAfter=3.4}";
        Assert.assertEquals(expected, houseTemperature.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2 = houseTemperature;
        Assert.assertEquals(houseTemperature, houseTemperature2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2.setHouseTemperatureBefore(1.2);
        houseTemperature2.setGetHouseTemperatureAfter(3.4);
        Assert.assertEquals(houseTemperature, houseTemperature2);
    }

    @Test
    public void equalsMethodDifferentBeforeTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2.setHouseTemperatureBefore(5.6);
        houseTemperature2.setGetHouseTemperatureAfter(3.4);
        Assert.assertNotEquals(houseTemperature, houseTemperature2);
    }

    @Test
    public void equalsMethodDifferentAfterTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2.setHouseTemperatureBefore(1.2);
        houseTemperature2.setGetHouseTemperatureAfter(5.6);
        Assert.assertNotEquals(houseTemperature, houseTemperature2);
    }

    @Test
    public void equalsFalseTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2.setHouseTemperatureBefore(1.2);
        houseTemperature2.setGetHouseTemperatureAfter(5.6);
        Assert.assertEquals(false, houseTemperature.equals(houseTemperature2));
    }

    @Test
    public void equalsTrueTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2.setHouseTemperatureBefore(1.2);
        houseTemperature2.setGetHouseTemperatureAfter(3.4);
        Assert.assertEquals(true, houseTemperature.equals(houseTemperature2));
    }

    @Test
    public void equalsNullTest() {
        houseTemperature.setHouseTemperatureBefore(1.2);
        houseTemperature.setGetHouseTemperatureAfter(3.4);
        houseTemperature2 = null;
        Assert.assertEquals(false, houseTemperature.equals(houseTemperature2));
    }

}