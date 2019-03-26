package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaterEmissionTest {

    WaterEmission waterEmission = new WaterEmission(0.0);
    WaterEmission waterEmission2 = new WaterEmission(0.0);

    @Test
    public void getWaterEmissionTest() {
        double waterEmission1 = 1.2;
        waterEmission.setWaterEmission(waterEmission1);
        double expected = 1.2;
        Assert.assertEquals(expected, waterEmission.getWaterEmission(), 0);
    }

    @Test
    public void setWaterEmissionTest() {
        double waterEmission1 = 1.2;
        waterEmission.setWaterEmission(waterEmission1);
        double setWaterEmission = waterEmission.getWaterEmission();
        double expected = 1.2;
        Assert.assertEquals(expected, setWaterEmission, 0);
    }

    @Test
    public void toStringTest() {
        WaterEmission waterEmission = new WaterEmission(1.2);
        String expected = "WaterEmission{waterEmission=1.2}";
        Assert.assertEquals(expected, waterEmission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        waterEmission.setWaterEmission(1.2);
        waterEmission = waterEmission2;
        Assert.assertEquals(waterEmission, waterEmission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        waterEmission.setWaterEmission(1.2);
        waterEmission2.setWaterEmission(1.2);
        Assert.assertEquals(waterEmission, waterEmission2);
    }

    @Test
    public void equalsMethodDifferentWaterEmissionTest() {
        waterEmission.setWaterEmission(1.2);
        waterEmission2.setWaterEmission(3.4);
        Assert.assertNotEquals(waterEmission, waterEmission2);
    }
    
}