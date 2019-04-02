package server.model;

import org.junit.Assert;
import org.junit.Test;


public class JwtUserTest {

    JwtUser jwtUser = new JwtUser();
    JwtUser jwtUser2 = new JwtUser();

    @Test
    public void getUserNameTest() {
        String userName = "abc";
        jwtUser.setUserName(userName);
        String expected = "abc";
        Assert.assertEquals(jwtUser.getUserName(), expected);
    }

    @Test
    public void setUserNameTest() {
        String userName = "abc";
        jwtUser.setUserName(userName);
        String setUserName = jwtUser.getUserName();
        String expected = "abc";
        Assert.assertEquals(setUserName, expected);
    }

    @Test
    public void getIdTest() {
        long id = 1234L;
        jwtUser.setId(id);
        long expected = 1234L;
        Assert.assertEquals(jwtUser.getId(), expected);
    }

    @Test
    public void setIdTest() {
        long id = 1234L;
        jwtUser.setId(id);
        long setId = jwtUser.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void getRoleTest() {
        String role = "abc";
        jwtUser.setRole(role);
        String expected = "abc";
        Assert.assertEquals(jwtUser.getRole(), expected);
    }

    @Test
    public void setRoleTest() {
        String role = "abc";
        jwtUser.setRole(role);
        String setRole = jwtUser.getRole();
        String expected = "abc";
        Assert.assertEquals(setRole, expected);
    }

    @Test
    public void toStringTest() {
        JwtUser jwtUser = new JwtUser("abc", 1234L, "xyz");
        String expected = "JwtUser{userName='abc', id=1234, role='xyz'}";
        Assert.assertEquals(jwtUser.toString(), expected);
    }

    @Test
    public void equalsMethodSameObjectTest()  {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("irtaza");
        jwtUser2 = jwtUser;
        Assert.assertEquals(jwtUser, jwtUser2);
    }

    @Test
    public void equalsMethodDifferentObjectTest()  {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("irtaza");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertEquals(jwtUser, jwtUser2);
    }

    @Test
    public void equalsMethodDifferentIdTest()  {
        jwtUser.setId(1223L);
        jwtUser.setRole("user");
        jwtUser.setUserName("irtaza");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertNotEquals(jwtUser, jwtUser2);
    }

    @Test
    public void equalsMethodDifferentRoleTest()  {
        jwtUser.setId(123L);
        jwtUser.setRole("admin");
        jwtUser.setUserName("irtaza");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertNotEquals(jwtUser, jwtUser2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest()  {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("tudors");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertNotEquals(jwtUser, jwtUser2);
    }

    @Test
    public void equalsFalseTest() {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("tudors");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertEquals(false, jwtUser.equals(jwtUser2));
    }

    @Test
    public void equalsTrueTest() {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("irtaza");
        jwtUser2.setId(123L);
        jwtUser2.setRole("user");
        jwtUser2.setUserName("irtaza");
        Assert.assertEquals(true, jwtUser.equals(jwtUser2));
    }

    @Test
    public void equalsNullTest() {
        jwtUser.setId(123L);
        jwtUser.setRole("user");
        jwtUser.setUserName("tudors");
        jwtUser2 = null;
        Assert.assertEquals(false, jwtUser.equals(jwtUser2));
    }

}