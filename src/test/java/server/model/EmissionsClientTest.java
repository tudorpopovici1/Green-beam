package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmissionsClientTest {
    EmissionsClient emissionsClient = new EmissionsClient();


    @Test
    public void setEmissionTypeTest() {
        String username = "abc";
        emissionsClient.setEmissionType(username);
        String setEmissionType = emissionsClient.getEmissionType();
        String expected = "abc";
        Assert.assertEquals(setEmissionType, expected);
    }
}