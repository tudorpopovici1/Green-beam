package server.model;

import org.junit.Assert;
import org.junit.Test;


public class EmissionTypeTest {
    EmissionType emission=new EmissionType();
    @Test
    public void setEmissionIdTest() {
        long emission1 = 1234;
        emission.setEmissionId(emission1);
        long setEmissionId = emission.getEmissionId();
        long expected = 1234;
        Assert.assertEquals(setEmissionId, expected);
    }

    @Test
    public void getEmissionIdTest() {
        long emission1 = 1234;
        emission.setEmissionId(emission1);
        long setEmissionId = emission.getEmissionId();
        long expected = 1234;
        Assert.assertEquals(setEmissionId, expected);
    }
    @Test
    public void setEmissionNameTest() {
        String emission1 = "1234";
        emission.setEmissionName(emission1);
        String setEmissionName = emission.getEmissionName();
        String expected = "1234";
        Assert.assertEquals(setEmissionName, expected);
    }
    @Test
    public void getEmissionNameTest() {
        String emission1 = "1234";
        emission.setEmissionName(emission1);
        String setEmissionName = emission.getEmissionName();
        String expected = "1234";
        Assert.assertEquals(setEmissionName, expected);
    }
}