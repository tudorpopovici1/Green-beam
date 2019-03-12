package server.model;

import org.junit.Assert;



class JwtUserTest {


    JwtUser jwtUser = new JwtUser();


    @org.junit.jupiter.api.Test
    public void getUserNameTest() {
        String userName = "abc";
        jwtUser.setUserName(userName);
        String expected = "abc";
        Assert.assertEquals(jwtUser.getUserName(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setUserNameTest() {
        String userName = "abc";
        jwtUser.setUserName(userName);
        String setUserName = jwtUser.getUserName();
        String expected = "abc";
        Assert.assertEquals(setUserName, expected);
    }

    @org.junit.jupiter.api.Test
    public void getIdTest() {
        long id = 1234L;
        jwtUser.setId(id);
        long expected = 1234L;
        Assert.assertEquals(jwtUser.getId(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setIdTest() {
        long id = 1234L;
        jwtUser.setId(id);
        long setId = jwtUser.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @org.junit.jupiter.api.Test
    public void getRoleTest() {
        String role = "abc";
        jwtUser.setRole(role);
        String expected = "abc";
        Assert.assertEquals(jwtUser.getRole(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setRoleTest() {
        String role = "abc";
        jwtUser.setRole(role);
        String setRole = jwtUser.getRole();
        String expected = "abc";
        Assert.assertEquals(setRole, expected);
    }

}