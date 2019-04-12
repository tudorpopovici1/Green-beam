package server.model;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AuthenticateUserTest {

    AuthenticateUser authenticateUser = new AuthenticateUser();
    AuthenticateUser authenticateUser2 = new AuthenticateUser();


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
    public void setPasswordTest() {
        String username = "pass";
        authenticateUser.setPassword(username);
        String expected = "pass";
        Assert.assertEquals(authenticateUser.getPassword(), expected);
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

    @Test
    public void toStringTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        String expcted = "AuthenticateUser{username='irtaza', password='123', token='231'}";
        Assert.assertEquals(expcted, authenticateUser.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2 = authenticateUser;
        Assert.assertEquals(authenticateUser, authenticateUser2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtaza");
        authenticateUser2.setPassword("123");
        authenticateUser2.setToken("231");
        Assert.assertEquals(authenticateUser, authenticateUser2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtazahashmi");
        authenticateUser2.setPassword("123");
        authenticateUser2.setToken("231");
        Assert.assertNotEquals(authenticateUser, authenticateUser2);
    }

    @Test
    public void equalsMethodDifferentPasswordTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtaza");
        authenticateUser2.setPassword("123456");
        authenticateUser2.setToken("231");
        Assert.assertNotEquals(authenticateUser, authenticateUser2);
    }

    @Test
    public void equalsMethodDifferentTokenTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtaza");
        authenticateUser2.setPassword("123");
        authenticateUser2.setToken("2312312");
        Assert.assertNotEquals(authenticateUser, authenticateUser2);
    }

    @Test
    public void ConstructorTest() {
        AuthenticateUser authenticateUser = new AuthenticateUser("abc", "def");
        String result = authenticateUser.getPassword();
        Assert.assertEquals(result, authenticateUser.getPassword());
    }

    @Test
    public void equalsFalseTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtaza");
        authenticateUser2.setPassword("123");
        authenticateUser2.setToken("2312312");
        Assert.assertEquals(false, authenticateUser.equals(authenticateUser2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(authenticateUser.equals(2L));
    }

    @Test
    public void equalsTrueTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2.setUsername("irtaza");
        authenticateUser2.setPassword("123");
        authenticateUser2.setToken("231");
        Assert.assertEquals(true, authenticateUser.equals(authenticateUser2));
    }

    @Test
    public void equalsNullTest() {
        authenticateUser.setUsername("irtaza");
        authenticateUser.setPassword("123");
        authenticateUser.setToken("231");
        authenticateUser2 = null;
        Assert.assertEquals(false, authenticateUser.equals(authenticateUser2));
    }
}