package server.model;

import org.apache.commons.httpclient.util.DateParseException;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmissionsTest {
    Emissions emission = new Emissions();
    Emissions emission2 = new Emissions();


    @Test
    public void setCarbonFootprintTest() {
        float emission1 = 1234;
        emission.setCarbonFootprint(emission1);
        float setCarbonFootprint = emission.getCarbonFootprint();
        float expected = 1234;
        Assert.assertEquals(setCarbonFootprint, expected, 0);
    }

    @Test
    public void getCarbonFootprintTest() {
        float emission1 = 1234;
        emission.setCarbonFootprint(emission1);
        float setCarbonFootprint = emission.getCarbonFootprint();
        float expected = 1234;
        Assert.assertEquals(setCarbonFootprint, expected, 0);
    }

    @Test
    public void setIdTest() {
        long emission1 = 1234;
        emission.setId(emission1);
        long setId = emission.getId();
        long expected = 1234;
        Assert.assertEquals(setId, expected);
    }
    @Test
    public void getIdTest() {
        long emission1 = 1234L;
        emission.setId(emission1);
        long setId = emission.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void setUserIdTest() {
        long emission1 = 1234;
        emission.setUserId(emission1);
        long setUserId = emission.getUserId();
        long expected = 1234;
        Assert.assertEquals(setUserId, expected);
    }
    @Test
    public void getUserIdTest() {
        long emission1 = 1234;
        emission.setUserId(emission1);
        long setUserId = emission.getUserId();
        long expected = 1234;
        Assert.assertEquals(setUserId, expected);
    }


    @Test
    public void setDate() throws DateParseException, ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        String expectedString = "2014-02-11";
        Date expected = sdf.parse(expectedString);
        Assert.assertEquals(expected, emission.getDate());
    }

    @Test
    public void getDate() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        String expectedString = "2014-02-11";
        Date expected = sdf.parse(expectedString);
        Assert.assertEquals(expected, emission.getDate());
    }

    @Test
    public void equalsMethodSameObjectTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2 = emission;
        Assert.assertEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentIdTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(1234L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentUserIdTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(4566L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentCarbonFootprintTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(122);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentEmissionTypeTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("car");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void equalsMethodDifferentDateTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2019-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertNotEquals(emission, emission2);
    }

    @Test
    public void toStringTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        String expected = "Emissions{id=123, userId=456, emissionType='bike', carbonFootprint=12.0, date=" + dateObject + "}";
        Assert.assertEquals(expected, emission.toString());
    }

    @Test
    public void constructorTest() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        Emissions emissions = new Emissions(1234L, "abc", 5678f, dateObject);
        String result = emissions.getEmissionType();
        Assert.assertEquals(result, emissions.getEmissionType());
    }

    @Test
    public void equalsFalseTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2019-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertEquals(false, emission.equals(emission2));
    }

    @Test
    public void equalsTrueTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2.setId(123L);
        emission2.setUserId(456L);
        emission2.setCarbonFootprint(12);
        emission2.setEmissionType("bike");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = "2014-02-11";
        Date dateObject2 = sdf2.parse(dateString2);
        emission2.setDate(dateObject2);
        Assert.assertEquals(true, emission.equals(emission2));
    }

    @Test
    public void equalsNullTest() throws ParseException {
        emission.setId(123L);
        emission.setUserId(456L);
        emission.setCarbonFootprint(12);
        emission.setEmissionType("bike");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2014-02-11";
        Date dateObject = sdf.parse(dateString);
        emission.setDate(dateObject);
        emission2 = null;
        Assert.assertEquals(false, emission.equals(emission2));
    }
}

