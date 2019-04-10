package server.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUserDetailsTest {

    JwtUserDetails jwtUserDetails = new JwtUserDetails(null, 0L, null,null);
    JwtUserDetails jwtUserDetails2= new JwtUserDetails(null, 0L, null,null);


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
    public void toStringTest() {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("irtaza");
        jwtUserDetails.setAuthorities(null);
        String expected = "JwtUserDetails{userName='irtaza', token='he', id=123, authorities=null}";
        Assert.assertEquals(expected, jwtUserDetails.toString());
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

    @Test
    public void equalsMethodSameObjectTest()  {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("irtaza");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2 = jwtUserDetails;
        Assert.assertEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void equalsMethodDifferentObjectTest()  {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("irtaza");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2.setId(123L);
        jwtUserDetails2.setToken("he");
        jwtUserDetails2.setUserName("irtaza");
        jwtUserDetails2.setAuthorities(null);
        Assert.assertEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void equalsMethodDifferentIdTest()  {
        jwtUserDetails.setId(1232L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("irtaza");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2.setId(123L);
        jwtUserDetails2.setToken("he");
        jwtUserDetails2.setUserName("irtaza");
        jwtUserDetails2.setAuthorities(null);
        Assert.assertNotEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void equalsMethodDifferentTokenTest()  {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("hse");
        jwtUserDetails.setUserName("irtaza");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2.setId(123L);
        jwtUserDetails2.setToken("he");
        jwtUserDetails2.setUserName("irtaza");
        jwtUserDetails2.setAuthorities(null);
        Assert.assertNotEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest()  {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("tudor");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2.setId(123L);
        jwtUserDetails2.setToken("he");
        jwtUserDetails2.setUserName("irtaza");
        jwtUserDetails2.setAuthorities(null);
        Assert.assertNotEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void equalsMethodDifferentAuthoritiesTest()  {
        jwtUserDetails.setId(123L);
        jwtUserDetails.setToken("he");
        jwtUserDetails.setUserName("tudor");
        jwtUserDetails.setAuthorities(null);
        jwtUserDetails2.setId(123L);
        jwtUserDetails2.setToken("he");
        jwtUserDetails2.setUserName("irtaza");
        jwtUserDetails2.setAuthorities(null);
        Assert.assertNotEquals(jwtUserDetails, jwtUserDetails2);
    }

    @Test
    public void getAuthoritiesTest() {
        Assert.assertEquals(jwtUserDetails.getAuthorities(), null);
    }

    @Test
    public void getPasswordTest() {
        Assert.assertEquals(jwtUserDetails.getPassword(), null);
    }

    @Test
    public void getUsernameTest() {
        Assert.assertEquals(jwtUserDetails.getUserName(), null);
    }

    @Test
    public void isAccountNonExpiredTest() {
        Assert.assertEquals(jwtUserDetails.isAccountNonExpired(), true);
    }

    @Test
    public void isAccountNonLockedTest() {
        Assert.assertEquals(jwtUserDetails.isAccountNonLocked(), true);
    }

    @Test
    public void isCredentialsNonExpiredTest() {
        Assert.assertEquals(jwtUserDetails.isCredentialsNonExpired(), true);
    }

    @Test
    public void isEnabledTest() {
        Assert.assertEquals(jwtUserDetails.isEnabled(), true);
    }
}