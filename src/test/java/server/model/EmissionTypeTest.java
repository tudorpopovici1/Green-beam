package server.model;

import org.junit.Assert;
import org.junit.Test;


public class EmissionTypeTest {
    EmissionType emission = new EmissionType();
    EmissionType emission2 = new EmissionType();

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

    @Test
    public void getEmissionTypeTest() {
        emission.setEmissionType("bike");
        Assert.assertEquals("bike", emission.getEmissionType());
    }

    @Test
    public void setEmissionTypeTest() {
        emission.setEmissionType("bike");
        Assert.assertEquals("bike", emission.getEmissionType());
    }

    @Test
    public void toStringTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        String expected = "EmissionType{emissionId=123, emissionName='hey', emissionType='bike'}";
        Assert.assertEquals(expected, emission.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        emission2 = emission;
        Assert.assertEquals(emission, emission2);

    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        emission2.setEmissionId(123L);
        emission2.setEmissionType("bike");
        emission2.setEmissionName("hey");
        Assert.assertEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentEmissionIdTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        emission2.setEmissionId(1233L);
        emission2.setEmissionType("bike");
        emission2.setEmissionName("hey");
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentEmissionTypeTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        emission2.setEmissionId(123L);
        emission2.setEmissionType("car");
        emission2.setEmissionName("hey");
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentEmissionNameTest() {
        emission.setEmissionId(123L);
        emission.setEmissionType("bike");
        emission.setEmissionName("hey");
        emission2.setEmissionId(123L);
        emission2.setEmissionType("bike");
        emission2.setEmissionName("bye");
        Assert.assertNotEquals(emission, emission2);
    }


}