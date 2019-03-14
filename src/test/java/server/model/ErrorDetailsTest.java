package server.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;


class ErrorDetailsTest {
    ErrorDetails errorDetail=new ErrorDetails();
    @Test
    public void getStatusTest() {
        int errorDetail1 = 1234;
        errorDetail.setStatus(errorDetail1);
        int setStatus = errorDetail.getStatus();
        int expected = 1234;
        Assert.assertEquals(setStatus,expected);

    }

    @Test
    public void setStatusTest() {
        int errorDetail1 = 1234;
        errorDetail.setStatus(errorDetail1);
        int setStatus = errorDetail.getStatus();
        int expected = 1234;
        Assert.assertEquals(setStatus,expected);

    }
    @Test
    public void setMessageTest() {
        String errorDetail1 = "1234";
        errorDetail.setMessage(errorDetail1);
        String setMessage = errorDetail.getMessage();
        String expected = "1234";
        Assert.assertEquals(setMessage,expected);

    }
    @Test
    public void getMessageTest() {
        String errorDetail1 = "1234";
        errorDetail.setMessage(errorDetail1);
        String setMessage = errorDetail.getMessage();
        String expected = "1234";
        Assert.assertEquals(setMessage,expected);

    }
    @Test
    public void setPathTest() {
        String errorDetail1 = "1234";
        errorDetail.setPath(errorDetail1);
        String setPath = errorDetail.getPath();
        String expected = "1234";
        Assert.assertEquals(setPath,expected);

    }
    @Test
    public void getPathTest() {
        String errorDetail1 = "1234";
        errorDetail.setPath(errorDetail1);
        String setPath = errorDetail.getPath();
        String expected = "1234";
        Assert.assertEquals(setPath,expected);

    }

    @Test
    public void getTimestampTest() {
        String errorDetail1 = "1234";
        errorDetail.setTimestamp(errorDetail1);
        String setTimestamp = errorDetail.getTimestamp();
        String expected = "1234";
        Assert.assertEquals(setTimestamp,expected);

    }
    @Test
    public void setTimestampTest() {
        String errorDetail1 = "1234";
        errorDetail.setTimestamp(errorDetail1);
        String setTimestamp = errorDetail.getTimestamp();
        String expected = "1234";
        Assert.assertEquals(setTimestamp,expected);

    }
    @Test
    public void getErrorTest() {
        String errorDetail1 = "1234";
        errorDetail.setError(errorDetail1);
        String setError = errorDetail.getError();
        String expected = "1234";
        Assert.assertEquals(setError,expected);

    }
    @Test
    public void setErrorTest() {
        String errorDetail1 = "1234";
        errorDetail.setError(errorDetail1);
        String setError = errorDetail.getError();
        String expected = "1234";
        Assert.assertEquals(setError,expected);

    }

    }

