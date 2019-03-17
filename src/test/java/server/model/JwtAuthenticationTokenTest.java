package server.model;

import org.junit.Assert;
import org.junit.Test;


public class JwtAuthenticationTokenTest {


    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(null);

    @Test
    public void getTokenTest() {
        String token = "abc";
        jwtAuthenticationToken.setToken(token);
        String expected = "abc";
        Assert.assertEquals(jwtAuthenticationToken.getToken(), expected);
    }

    @Test
    public void setTokenTest() {
        String token = "abc";
        jwtAuthenticationToken.setToken(token);
        String setToken = jwtAuthenticationToken.getToken();
        String expected = "abc";
        Assert.assertEquals(setToken, expected);
    }
}


