package server.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;


public class FriendsUserRespTest {


    FriendsUserResp friendsUserResp = new FriendsUserResp();
    FriendsUserResp friendsUserResp2 = new FriendsUserResp();


    @Test
    public void getFirstNameTest() {
        String firstName = "abc";
        friendsUserResp.setFirstName(firstName);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getFirstName(), expected);
    }

    @Test
    public void setFirstNameTest() {
        String firstName = "abc";
        friendsUserResp.setFirstName(firstName);
        String setFirstName = friendsUserResp.getFirstName();
        String expected = "abc";
        Assert.assertEquals(setFirstName, expected);
    }

    @Test
    public void getLastNameTest() {
        String lastName = "abc";
        friendsUserResp.setLastName(lastName);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getLastName(), expected);
    }

    @Test
    public void setLastNameTest() {
        String lastName = "abc";
        friendsUserResp.setLastName(lastName);
        String setLastName = friendsUserResp.getLastName();
        String expected = "abc";
        Assert.assertEquals(setLastName, expected);
    }

    @Test
    public void getUsernameTest() {
        String username = "abc";
        friendsUserResp.setUsername(username);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getUsername(), expected);
    }

    @Test
    public void setUsernameTest() {
        String username = "abc";
        friendsUserResp.setUsername(username);
        String setUsername = friendsUserResp.getUsername();
        String expected = "abc";
        Assert.assertEquals(setUsername, expected);
    }

    @Test
    public void getDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        friendsUserResp.setDateOfBirth(dateOfBirth);
        Date setDateOfBirth = friendsUserResp.getDateOfBirth();
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(setDateOfBirth, dateOfBirthExpected);

    }

    @Test
    public void setDateOfBirthTest() throws ParseException {
        String date = "31/12/1998";
        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        friendsUserResp.setDateOfBirth(dateOfBirth);
        String expected = "31/12/1998";
        Date dateOfBirthExpected = new SimpleDateFormat("dd/MM/yyyy").parse(expected);
        Assert.assertEquals(friendsUserResp.getDateOfBirth(), dateOfBirthExpected);
    }

    @Test
    public void getCountryTest() {
        String county = "abc";
        friendsUserResp.setCountry(county);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getCountry(), expected);
    }

    @Test
    public void setCountryTest() {
        String county = "abc";
        friendsUserResp.setCountry(county);
        String setCounty = friendsUserResp.getCountry();
        String expected = "abc";
        Assert.assertEquals(setCounty, expected);
    }

    @Test
    public void getEmailTest() {
        String email = "abc";
        friendsUserResp.setEmail(email);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getEmail(), expected);
    }

    @Test
    public void setEmailTest() {
        String email = "abc";
        friendsUserResp.setEmail(email);
        String setEmail = friendsUserResp.getEmail();
        String expected = "abc";
        Assert.assertEquals(setEmail, expected);
    }

//    @Test
//    public void toStringTest() throws ParseException {
//        String date = "12/34/5678";
//        Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//        FriendsUserResp friendsUserResp = new FriendsUserResp("abc", dateOfBirth, "def", "ghi", "jkl", "mno");
//        String expected = "FriendsUserResp{username='abc', dateOfBirth=Sat Oct 12 00:00:00 CEST 5680, firstName='def', lastName='ghi', country='jkl', email='mno'}";
//        Assert.assertEquals(friendsUserResp.toString(), expected);
//    }

    @Test
    public void equalsMethodSameObjectTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2 = friendsUserResp;
        Assert.assertEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentFirstNameTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("tudor");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentLastNameTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("something");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentCountryTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("finland");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentDOBTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2012-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentEmailTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("idsad@gmail.com");
        friendsUserResp2.setUsername("irtazahashmi");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

    @Test
    public void equalsMethodDifferentUsernameTest() throws ParseException {
        friendsUserResp.setFirstName("irtaza");
        friendsUserResp.setLastName("hashmi");
        friendsUserResp.setCountry("pakistan");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        friendsUserResp.setDateOfBirth(dateObject);
        friendsUserResp.setEmail("i@gmail.com");
        friendsUserResp.setUsername("irtazahashmi");
        friendsUserResp2.setFirstName("irtaza");
        friendsUserResp2.setLastName("hashmi");
        friendsUserResp2.setCountry("pakistan");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        friendsUserResp2.setDateOfBirth(dateObject2);
        friendsUserResp2.setEmail("i@gmail.com");
        friendsUserResp2.setUsername("something");
        Assert.assertNotEquals(friendsUserResp, friendsUserResp2);
    }

}