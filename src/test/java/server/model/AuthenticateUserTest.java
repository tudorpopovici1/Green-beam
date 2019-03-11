package server.model;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthenticateUserTest {

    AuthenticateUser authenticateUser= new AuthenticateUser();

    @Test
    public void getUsernameTest() {
        String username = "abc";
        authenticateUser.setUsername(username);
        String setUsername = authenticateUser.getUsername();
        String expected = "abc";
        Assert.assertEquals(setUsername, expected);
    }
    @Test
    public void setUsernameTest() {
        String username = "abc";
        authenticateUser.setUsername(username);
        String setUsername = authenticateUser.getUsername();
        String expected = "abc";
        Assert.assertEquals(setUsername, expected);
    }
    @Test
    public void getPasswordTest() {
        String username = "pass";
        authenticateUser.setPassword(username);
        String expected = "pass";
        Assert.assertEquals(authenticateUser.getPassword(), expected);
    }

    @Test
    public void notgetPasswordTest() {
        String username = "pass";
        authenticateUser.setPassword(username);
        String notexpected = "notpass";
        Assert.assertNotEquals(authenticateUser.getPassword(), notexpected);
    }
    @Test
    public void setPasswordTest() {
        String username = "pass";
        authenticateUser.setPassword(username);
        String setPassword = authenticateUser.getPassword();
        String expected = "pass";
        Assert.assertEquals(setPassword, expected);
    }
    @Test
    public void setTokenTest() {
        String username = "pass";
        authenticateUser.setToken(username);
        String setToken = authenticateUser.getToken();
        String expected = "pass";
        Assert.assertEquals(setToken, expected);
    }
    @Test
    public void getTokenTest() {
        String username = "pass";
        authenticateUser.setToken(username);
        String expected = "pass";
        Assert.assertEquals(authenticateUser.getToken(), expected);
    }



}