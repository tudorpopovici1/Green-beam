package server.model;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JwtAuthenticationTokenTest {


    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(null);
    JwtAuthenticationToken jwtAuthenticationToken2 = new JwtAuthenticationToken(null);

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

    @Test
    public void toStringTest() {
        jwtAuthenticationToken.setToken("123");
        String expected = "JwtAuthenticationToken{token='123'}";
        Assert.assertEquals(expected, jwtAuthenticationToken.toString());
    }

    @Test
    public void equalsMethodSameObjectTest()  {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2 = jwtAuthenticationToken;
        Assert.assertEquals(jwtAuthenticationToken, jwtAuthenticationToken2);
    }

    @Test
    public void equalsMethodDifferentObjectTest()  {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2.setToken("123");
        Assert.assertEquals(jwtAuthenticationToken, jwtAuthenticationToken2);
    }

    @Test
    public void equalsMethodDifferentTokenTest()  {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2.setToken("123213");
        Assert.assertNotEquals(jwtAuthenticationToken, jwtAuthenticationToken2);
    }

    @Test
    public void equalsFalseTest() {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2.setToken("123213");
        Assert.assertEquals(false, jwtAuthenticationToken.equals(jwtAuthenticationToken2));
    }

    @Test
    public void equalsTrueTest() {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2.setToken("123");
        Assert.assertEquals(true, jwtAuthenticationToken.equals(jwtAuthenticationToken2));
    }

    @Test
    public void equalsNullTest() {
        jwtAuthenticationToken.setToken("123");
        jwtAuthenticationToken2 = null;
        Assert.assertEquals(false, jwtAuthenticationToken.equals(jwtAuthenticationToken2));
    }

    @Test
    public void equalsMethodDifferentClassTest() {
        Assert.assertFalse(jwtAuthenticationToken.equals(2L));
    }



}


