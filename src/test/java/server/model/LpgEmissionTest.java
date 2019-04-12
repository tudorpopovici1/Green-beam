package server.model;

import org.junit.Assert;
import org.junit.Test;

public class LpgEmissionTest {

    LpgEmission lpgEmission = new LpgEmission(0.0);
    LpgEmission lpgEmission2 = new LpgEmission(0.0);

    @Test
    public void getLpgEmissionTest() {
        double lpgEmission1 = 1.2;
        lpgEmission.setLpgEmission(lpgEmission1);
        double expected = 1.2;
        Assert.assertEquals(expected, lpgEmission.getLpgEmission(), 0);
    }

    @Test
    public void setLpgEmissionTest() {
        double lpgEmission1 = 1.2;
        lpgEmission.setLpgEmission(lpgEmission1);
        double setLpgEmission = lpgEmission.getLpgEmission();
        double expected = 1.2;
        Assert.assertEquals(expected, setLpgEmission, 0);
    }

    @Test
    public void toStringTest() {
        LpgEmission lpgEmission = new LpgEmission(1.2);
        String expected = "LPGEmission{lpgEmission=1.2}";
        Assert.assertEquals(expected, lpgEmission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission = lpgEmission2;
        Assert.assertEquals(lpgEmission, lpgEmission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission2.setLpgEmission(1.2);
        Assert.assertEquals(lpgEmission, lpgEmission2);
    }

    @Test
    public void equalsMethodDifferentLpgEmissionTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission2.setLpgEmission(3.4);
        Assert.assertNotEquals(lpgEmission, lpgEmission2);
    }
    @Test
    public void equalsFalseTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission2.setLpgEmission(3.4);
        Assert.assertEquals(false, lpgEmission.equals(lpgEmission2));
    }

    @Test
    public void equalsTrueTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission2.setLpgEmission(1.2);
        Assert.assertEquals(true, lpgEmission.equals(lpgEmission2));
    }

    @Test
    public void equalsNullTest() {
        lpgEmission.setLpgEmission(1.2);
        lpgEmission2 = null;
        Assert.assertEquals(false, lpgEmission.equals(lpgEmission2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(lpgEmission.equals(2L));
    }


}
