package server.model;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {


    Users user = new Users();
    

    @Test
    public void setFirstNameTest() {
        String firstName = "abc";
        user.setFirstName(firstName);
        String setFirstName = user.getFirstName();
        String expected = "abc";
        Assert.assertEquals(setFirstName, expected);
    }

    @Test
    public void setIdTest() {
        long id = 1234L;
        user.setId(id);
        long setId = user.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void getPasswordTest() {
        String password = "abc";
        user.setPassword(password);
        String expected = "abc";
        Assert.assertEquals(user.getPassword(), expected);
    }

    @Test
    public void getRoleTest() {
        String role = "abc";
        user.setRole(role);
        String expected = "abc";
        Assert.assertEquals(user.getRole(), expected);
    }

    @Test
    public void setUsernameTest() {
        String username = "abc";
        user.setUsername(username);
        String setUsername = user.getUsername();
        String expected = "abc";
        Assert.assertEquals(setUsername, expected);
    }

    @Test
    public void setCountryTest() {
        String country = "abc";
        user.setCountry(country);
        String setCountry = user.getCountry();
        String expected = "abc";
        Assert.assertEquals(setCountry, expected);
    }

    @Test
    public void getDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        user.setDateOfBirth(dateOfBirth);
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(user.getDateOfBirth(), dateOfBirthExpected);
    }

    @Test
    public void getLastNameTest() {
        String lastName = "abc";
        user.setLastName(lastName);
        String expected = "abc";
        Assert.assertEquals(user.getLastName(), expected);
    }

    @Test
    public void setEmailTest() {
        String email = "abc";
        user.setEmail(email);
        String setEmail = user.getEmail();
        String expected = "abc";
        Assert.assertEquals(setEmail, expected);
    }

    @Test
    public void getUsernameTest() {
        String username = "abc";
        user.setUsername(username);
        String expected = "abc";
        Assert.assertEquals(user.getUsername(), expected);
    }

    @Test
    public void getCountryTest() {
        String country = "abc";
        user.setCountry(country);
        String expected = "abc";
        Assert.assertEquals(user.getCountry(), expected);
    }

    @Test
    public void setRoleTest() {
        String role = "abc";
        user.setRole(role);
        String setRole = user.getRole();
        String expected = "abc";
        Assert.assertEquals(setRole, expected);
    }

    @Test
    public void setDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        user.setDateOfBirth(dateOfBirth);
        Date setDateOfBirth = user.getDateOfBirth();
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(setDateOfBirth, dateOfBirthExpected);
    }

    @Test
    public void getIdTest() {
        long id = 1234L;
        user.setId(id);
        long setId = user.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void setLastNameTest() {
        String lastName = "abc";
        user.setLastName(lastName);
        String setLastName = user.getLastName();
        String expected = "abc";
        Assert.assertEquals(setLastName, expected);
    }

    @Test
    public void setPasswordTest() {
        String password = "abc";
        user.setPassword(password);
        String setPassword = user.getPassword();
        String expected = "abc";
        Assert.assertEquals(setPassword, expected);
    }

    @Test
    public void getEmailTest() {
        String email = "abc";
        user.setEmail(email);
        String expected = "abc";
        Assert.assertEquals(user.getEmail(), expected);
    }

    @Test
    public void getFirstNameTest() {
        String firstName = "abc";
        user.setFirstName(firstName);
        String expected = "abc";
        Assert.assertEquals(user.getFirstName(), expected);
    }

    @Test
    public void toStringTest() throws ParseException {
        String date = "12/34/5678";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Users user = new Users(1234L, "abc", "def", "ghi", "jkl", "mno", "pqr", dateOfBirth, "vwx");
        String expected = "Users{id=1234, username='abc', password='def', firstName='ghi', lastName='jkl', country='mno', email='pqr', dateOfBirth='Sat Oct 12 00:00:00 CEST 5680', role='vwx'}";
        Assert.assertEquals(user.toString(), expected);
    }

}