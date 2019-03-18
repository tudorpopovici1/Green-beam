package server.model;

import org.junit.Assert;
import org.junit.Test;


public class EmissionFriendTest {

    EmissionFriend emissionFriend = new EmissionFriend();
    EmissionFriend emissionFriend2 = new EmissionFriend();


    @Test
    public void getUsernameTest() {
        emissionFriend.setUsername("irtaza");
        String expected = "irtaza";
        Assert.assertEquals(expected, emissionFriend.getUsername());
    }

    @Test
    public void setUsernameTest() {
        emissionFriend.setUsername("irtaza");
        String expected = "irtaza";
        Assert.assertEquals(expected, emissionFriend.getUsername());
    }

    @Test
    public void getCarbonEmissionTest() {
        emissionFriend.setCarbonEmission(12.2);
        double expected = 12.2;
        Assert.assertEquals(expected, emissionFriend.getCarbonEmission(), 0);
    }

    @Test
    public void setCarbonEmissionTest() {
        emissionFriend.setCarbonEmission(12.2);
        double expected = 12.2;
        Assert.assertEquals(expected, emissionFriend.getCarbonEmission(), 0);
    }

    @Test
    public void toStringTest() {
        emissionFriend.setUsername("irtaza");
        emissionFriend.setCarbonEmission(12.2);
        String expected = "EmissionFriend{username='irtaza', carbonEmission=12.2}";
        Assert.assertEquals(expected, emissionFriend.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        emissionFriend.setUsername("irtaza");
        emissionFriend.setCarbonEmission(12.2);
        emissionFriend2 = emissionFriend;
        Assert.assertEquals(emissionFriend, emissionFriend2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        emissionFriend.setUsername("irtaza");
        emissionFriend.setCarbonEmission(12.2);
        emissionFriend2.setUsername("irtaza");
        emissionFriend2.setCarbonEmission(12.2);
        Assert.assertEquals(emissionFriend, emissionFriend2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest() {
        emissionFriend.setUsername("irtaza");
        emissionFriend.setCarbonEmission(12.2);
        emissionFriend2.setUsername("tudor");
        emissionFriend2.setCarbonEmission(12.2);
        Assert.assertNotEquals(emissionFriend, emissionFriend2);
    }

    @Test
    public void equalsMethodDifferentCarbonEmissionTest() {
        emissionFriend.setUsername("irtaza");
        emissionFriend.setCarbonEmission(12.2);
        emissionFriend2.setUsername("irtaza");
        emissionFriend2.setCarbonEmission(12.3);
        Assert.assertNotEquals(emissionFriend, emissionFriend2);
    }
}
