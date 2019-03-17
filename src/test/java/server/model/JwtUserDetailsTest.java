package server.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUserDetailsTest {

    JwtUserDetails jwtUserDetails = new JwtUserDetails(null, 0L, null,null);

    @Test
    public void getUserNameTest() {
        String userName = "abc";
        jwtUserDetails.setUserName(userName);
        String expected = "abc";
        Assert.assertEquals(jwtUserDetails.getUserName(), expected);
    }

    @Test
    public void setUserNameTest() {
        String userName = "abc";
        jwtUserDetails.setUserName(userName);
        String setUserName = jwtUserDetails.getUserName();
        String expected = "abc";
        Assert.assertEquals(setUserName, expected);
    }

    @Test
    public void getTokenTest() {
        String token = "abc";
        jwtUserDetails.setToken(token);
        String expected = "abc";
        Assert.assertEquals(jwtUserDetails.getToken(), expected);
    }

    @Test
    public void setTokenTest() {
        String token = "abc";
        jwtUserDetails.setToken(token);
        String setToken = jwtUserDetails.getToken();
        String expected = "abc";
        Assert.assertEquals(setToken, expected);
    }

    @Test
    public void getIdTest() {
        long id = 1234L;
        jwtUserDetails.setId(id);
        long setId = jwtUserDetails.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void setIdTest() {
        long id = 1234L;
        jwtUserDetails.setId(id);
        long setId = jwtUserDetails.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void equalsFalseTest() {
        JwtUserDetails jwtUserDetails1 = new JwtUserDetails("abc", 1234L, "def", null);
        JwtUserDetails jwtUserDetails2 = new JwtUserDetails("cba", 1234L, "def", null);
        Assert.assertEquals(false, jwtUserDetails1.equals(jwtUserDetails2));
    }

    @Test
    public void equalsTrueTest() {
        JwtUserDetails jwtUserDetails3 = new JwtUserDetails("abc", 1234L, "def", null);
        JwtUserDetails jwtUserDetails4 = new JwtUserDetails("abc", 1234L, "def", null);
        Assert.assertEquals(true, jwtUserDetails3.equals(jwtUserDetails4));
    }

    @Test
    public void equalsNullTest() {
        JwtUserDetails jwtUserDetails5 = new JwtUserDetails("abc", 1234L, "def", null);
        JwtUserDetails jwtUserDetails6 = null;
        Assert.assertEquals(false, jwtUserDetails5.equals(jwtUserDetails6));
    }
}