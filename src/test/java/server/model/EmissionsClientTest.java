package server.model;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EmissionsClientTest {
    EmissionsClient emissionsClient = new EmissionsClient();
    EmissionsClient emissionsClient2 = new EmissionsClient();


    @Test
    public void setEmissionTypeTest() {
        String username = "abc";
        emissionsClient.setEmissionType(username);
        String setEmissionType = emissionsClient.getEmissionType();
        String expected = "abc";
        Assert.assertEquals(setEmissionType, expected);
    }

    @Test
    public void getEmissionTypeTest() {
        String username = "abc";
        emissionsClient.setEmissionType(username);
        String setEmissionType = emissionsClient.getEmissionType();
        String expected = "abc";
        Assert.assertEquals(setEmissionType, expected);
    }

    @Test
    public void getCarbonEmissionTest() {
        emissionsClient.setCarbonEmission(12);
        Assert.assertEquals(12, emissionsClient.getCarbonEmission(), 0);
    }

    @Test
    public void setCarbonEmissionTest() {
        emissionsClient.setCarbonEmission(12);
        Assert.assertEquals(12, emissionsClient.getCarbonEmission(), 0);
    }

    @Test
    public void getDateTest() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        String expectedString = "2014-02-11";
        Date expected = sdf.parse(expectedString);
        Assert.assertEquals(expected, emissionsClient.getDate());
    }

    @Test
    public void setDateTest() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        String expectedString = "2014-02-11";
        Date expected = sdf.parse(expectedString);
        Assert.assertEquals(expected, emissionsClient.getDate());
    }

    @Test
    public void toStringTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        String expected = "EmissionsClient{emissionType='bike', carbonEmission=12.0, date=Tue Feb 11 00:00:00 CET 2014}";
        Assert.assertEquals(expected, emissionsClient.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        emissionsClient2 = emissionsClient;
        Assert.assertEquals(emissionsClient, emissionsClient2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        emissionsClient2.setEmissionType("bike");
        emissionsClient2.setCarbonEmission(12);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emissionsClient2.setDate(dateObject2);
        Assert.assertEquals(emissionsClient, emissionsClient2);
    }

    @Test
    public void equalsMethodDifferentEmissionTypeTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        emissionsClient2.setEmissionType("car");
        emissionsClient2.setCarbonEmission(12);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emissionsClient2.setDate(dateObject2);
        Assert.assertNotEquals(emissionsClient, emissionsClient2);
    }

    @Test
    public void equalsMethodDifferentCarbonEmissionTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        emissionsClient2.setEmissionType("bike");
        emissionsClient2.setCarbonEmission(123);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emissionsClient2.setDate(dateObject2);
        Assert.assertNotEquals(emissionsClient, emissionsClient2);
    }

    @Test
    public void equalsMethodDifferentDateTest() throws ParseException {
        emissionsClient.setEmissionType("bike");
        emissionsClient.setCarbonEmission(12);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emissionsClient.setDate(dateObject);
        emissionsClient2.setEmissionType("bike");
        emissionsClient2.setCarbonEmission(12);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2019-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emissionsClient2.setDate(dateObject2);
        Assert.assertNotEquals(emissionsClient, emissionsClient2);
    }
}