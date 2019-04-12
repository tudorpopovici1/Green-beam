package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WasteEmissionTest {

    WasteEmission wasteEmission = new WasteEmission(0.0);
    WasteEmission wasteEmission2 = new WasteEmission(0.0);

    @Test
    public void getWasteEmissionTest() {
        double wasteEmission1 = 1.2;
        wasteEmission.setWasteEmission(wasteEmission1);
        double expected = 1.2;
        Assert.assertEquals(expected, wasteEmission.getWasteEmission(), 0);
    }

    @Test
    public void setWasteEmissionTest() {
        double wasteEmission1 = 1.2;
        wasteEmission.setWasteEmission(wasteEmission1);
        double setWasteEmission = wasteEmission.getWasteEmission();
        double expected = 1.2;
        Assert.assertEquals(expected, setWasteEmission, 0);
    }

    @Test
    public void toStringTest() {
        WasteEmission wasteEmission = new WasteEmission(1.2);
        String expected = "WasteEmission{wasteEmission=1.2}";
        Assert.assertEquals(expected, wasteEmission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission = wasteEmission2;
        Assert.assertEquals(wasteEmission, wasteEmission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission2.setWasteEmission(1.2);
        Assert.assertEquals(wasteEmission, wasteEmission2);
    }

    @Test
    public void equalsMethodDifferentWasteEmissionTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission2.setWasteEmission(3.4);
        Assert.assertNotEquals(wasteEmission, wasteEmission2);
    }

    @Test
    public void equalsFalseTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission2.setWasteEmission(3.4);
        Assert.assertEquals(false, wasteEmission.equals(wasteEmission2));
    }

    @Test
    public void equalsTrueTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission2.setWasteEmission(1.2);
        Assert.assertEquals(true, wasteEmission.equals(wasteEmission2));
    }

    @Test
    public void equalsNullTest() {
        wasteEmission.setWasteEmission(1.2);
        wasteEmission2 = null;
        Assert.assertEquals(false, wasteEmission.equals(wasteEmission2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(wasteEmission.equals(2L));
    }

}