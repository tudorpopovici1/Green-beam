package server.model;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    Users user = new Users();
    Users user2 = new Users();


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

    @Test
    public void equalsFalseTest() throws ParseException {
        String date = "12/34/5678";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Users user1 = new Users(1234L, "abc", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Users user2 = new Users(1234L, "def", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Users user3 = new Users(1234L, "def", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Assert.assertEquals(false, user1.equals(user3));
    }

    @Test
    public void equalsTrueTest() throws ParseException {
        String date = "12/34/5678";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Users user1 = new Users(1234L, "abc", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Users user2 = new Users(1234L, "def", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Users user3 = new Users(1234L, "def", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Assert.assertEquals(true, user2.equals(user3));
    }

    @Test
    public void equalsNullTest() throws ParseException {
        String date = "12/34/5678";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Users user1 = new Users(1234L, "abc", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Users user2 = null;
        Users user3 = new Users(1234L, "def", "ghi", "jkl", "mno", "pqr", "stu", dateOfBirth, "vxy");
        Assert.assertEquals(false, user1.equals(user2));
    }


    @Test
    public void equalsMethodSameObjectTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2 = user;
        Assert.assertEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentFirstNameTest() throws ParseException {
        user.setFirstName("irtazaaa");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentLastNameTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmiiii");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentCountryTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistannnn");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentDOBTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2013-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmiii");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }


    @Test
    public void equalsMethodDifferentPasswordTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("12345");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentEmailTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i222@gmail.com");
        user.setId(123L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentIdTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123222L);
        user.setRole("admin");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }

    @Test
    public void equalsMethodDifferentRoleTest() throws ParseException {
        user.setFirstName("irtaza");
        user.setLastName("hashmi");
        user.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        user.setDateOfBirth(dateObject);
        user.setUsername("irtazahashmi");
        user.setPassword("123");
        user.setEmail("i@gmail.com");
        user.setId(123L);
        user.setRole("user");
        user2.setFirstName("irtaza");
        user2.setLastName("hashmi");
        user2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        user2.setDateOfBirth(dateObject2);
        user2.setUsername("irtazahashmi");
        user2.setPassword("123");
        user2.setEmail("i@gmail.com");
        user2.setId(123L);
        user2.setRole("admin");
        Assert.assertNotEquals(user, user2);
    }
}