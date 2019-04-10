package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NaturalGasEmissionTest {

    NaturalGasEmission naturalGasEmission = new NaturalGasEmission(0.0);
    NaturalGasEmission naturalGasEmission2 = new NaturalGasEmission(0.0);

    @Test
    public void getNaturalGasUsageTest() {
        double naturalGasUsage = 1.2;
        naturalGasEmission.setNaturalGasUsage(naturalGasUsage);
        double expected = 1.2;
        Assert.assertEquals(expected, naturalGasEmission.getNaturalGasUsage(), 0);
    }

    @Test
    public void setNaturalGasUsageTest() {
        double naturalGasUsage = 1.2;
        naturalGasEmission.setNaturalGasUsage(naturalGasUsage);
        double setNaturalGasUsage = naturalGasEmission.getNaturalGasUsage();
        double expected = 1.2;
        Assert.assertEquals(expected, setNaturalGasUsage, 0);
    }

    @Test
    public void toStringTest() {
        NaturalGasEmission naturalGasEmission = new NaturalGasEmission(1.2);
        String expected = "NaturalGasEmission{naturalGasUsage=1.2}";
        Assert.assertEquals(expected, naturalGasEmission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission = naturalGasEmission2;
        Assert.assertEquals(naturalGasEmission, naturalGasEmission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission2.setNaturalGasUsage(1.2);
        Assert.assertEquals(naturalGasEmission, naturalGasEmission2);
    }

    @Test
    public void equalsMethodDifferentGasUsageTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission2.setNaturalGasUsage(3.4);
        Assert.assertNotEquals(naturalGasEmission, naturalGasEmission2);
    }

    @Test
    public void equalsFalseTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission2.setNaturalGasUsage(3.4);
        Assert.assertEquals(false, naturalGasEmission.equals(naturalGasEmission2));
    }

    @Test
    public void equalsTrueTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission2.setNaturalGasUsage(1.2);
        Assert.assertEquals(true, naturalGasEmission.equals(naturalGasEmission2));
    }

    @Test
    public void equalsNullTest() {
        naturalGasEmission.setNaturalGasUsage(1.2);
        naturalGasEmission2 = null;
        Assert.assertEquals(false, naturalGasEmission.equals(naturalGasEmission2));
    }
}