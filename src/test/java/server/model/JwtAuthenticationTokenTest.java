package server.model;

import org.junit.Assert;



public class JwtAuthenticationTokenTest {


    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken("");

    
    @org.junit.jupiter.api.Test
    public void getTokenTest() {
        String token = "abc";
        jwtAuthenticationToken.setToken(token);
        String expected = "abc";
        Assert.assertEquals(jwtAuthenticationToken.getToken(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setTokenTest() {
        String token = "abc";
        jwtAuthenticationToken.setToken(token);
        String setToken = jwtAuthenticationToken.getToken();
        String expected = "abc";
        Assert.assertEquals(setToken, expected);
    }


}