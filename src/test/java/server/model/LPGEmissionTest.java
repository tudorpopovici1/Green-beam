package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LPGEmissionTest {

    LPGEmission lpgEmission = new LPGEmission(0.0);
    LPGEmission lpgEmission2 = new LPGEmission(0.0);

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
        LPGEmission lpgEmission = new LPGEmission(1.2);
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

}