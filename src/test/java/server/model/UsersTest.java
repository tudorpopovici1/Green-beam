package server.model;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {


    Users user = new Users();


    @org.junit.jupiter.api.Test
    public void setFirstNameTest() {
        String firstName = "abc";
        user.setFirstName(firstName);
        String setFirstName = user.getFirstName();
        String expected = "abc";
        Assert.assertEquals(setFirstName, expected);
    }

    @org.junit.jupiter.api.Test
    public void setIdTest() {
        long id = 1234L;
        user.setId(id);
        long setId = user.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @org.junit.jupiter.api.Test
    public void getPasswordTest() {
        String password = "abc";
        user.setPassword(password);
        String expected = "abc";
        Assert.assertEquals(user.getPassword(), expected);
    }

    @org.junit.jupiter.api.Test
    public void getRoleTest() {
        String role = "abc";
        user.setRole(role);
        String expected = "abc";
        Assert.assertEquals(user.getRole(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setUsernameTest() {
        String username = "abc";
        user.setUsername(username);
        String setUsername = user.getUsername();
        String expected = "abc";
        Assert.assertEquals(setUsername, expected);
    }

    @org.junit.jupiter.api.Test
    public void setCountryTest() {
        String country = "abc";
        user.setCountry(country);
        String setCountry = user.getCountry();
        String expected = "abc";
        Assert.assertEquals(setCountry, expected);
    }

    @org.junit.jupiter.api.Test
    public void getDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        user.setDateOfBirth(dateOfBirth);
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(user.getDateOfBirth(), dateOfBirthExpected);
    }

    @org.junit.jupiter.api.Test
    public void getLastNameTest() {
        String lastName = "abc";
        user.setLastName(lastName);
        String expected = "abc";
        Assert.assertEquals(user.getLastName(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setEmailTest() {
        String email = "abc";
        user.setEmail(email);
        String setEmail = user.getEmail();
        String expected = "abc";
        Assert.assertEquals(setEmail, expected);
    }

    @org.junit.jupiter.api.Test
    public void getUsernameTest() {
        String username = "abc";
        user.setUsername(username);
        String expected = "abc";
        Assert.assertEquals(user.getUsername(), expected);
    }

    @org.junit.jupiter.api.Test
    public void getCountryTest() {
        String country = "abc";
        user.setCountry(country);
        String expected = "abc";
        Assert.assertEquals(user.getCountry(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setRoleTest() {
        String role = "abc";
        user.setRole(role);
        String setRole = user.getRole();
        String expected = "abc";
        Assert.assertEquals(setRole, expected);
    }

    @org.junit.jupiter.api.Test
    public void setDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        user.setDateOfBirth(dateOfBirth);
        Date setDateOfBirth = user.getDateOfBirth();
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(setDateOfBirth, dateOfBirthExpected);
    }
    


}