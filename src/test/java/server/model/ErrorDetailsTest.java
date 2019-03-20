package server.model;

import org.junit.Assert;
import org.junit.Test;


public class ErrorDetailsTest {
    ErrorDetails errorDetail = new ErrorDetails();
    ErrorDetails errorDetail2 = new ErrorDetails();

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

    @Test
    public void toStringTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        String expected = "ErrorDetails{timestamp='13/01/199', status=404, error='some error', message='go away', path='i am sleepy'}";
        Assert.assertEquals(expected, errorDetail.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2 = errorDetail;
        Assert.assertEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("some error");
        errorDetail2.setMessage("go away");
        errorDetail2.setPath("i am sleepy");
        errorDetail2.setStatus(404);
        errorDetail2.setTimestamp("13/01/199");
        Assert.assertEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentErrortTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("one error");
        errorDetail2.setMessage("go away");
        errorDetail2.setPath("i am sleepy");
        errorDetail2.setStatus(404);
        errorDetail2.setTimestamp("13/01/199");
        Assert.assertNotEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentMessageTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("some error");
        errorDetail2.setMessage("go away, ughhh");
        errorDetail2.setPath("i am sleepy");
        errorDetail2.setStatus(404);
        errorDetail2.setTimestamp("13/01/199");
        Assert.assertNotEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentPathTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("some error");
        errorDetail2.setMessage("go away");
        errorDetail2.setPath("i am sleepy, bruh");
        errorDetail2.setStatus(404);
        errorDetail2.setTimestamp("13/01/199");
        Assert.assertNotEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentStatusTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("some error");
        errorDetail2.setMessage("go away");
        errorDetail2.setPath("i am sleepy");
        errorDetail2.setStatus(403);
        errorDetail2.setTimestamp("13/01/199");
        Assert.assertNotEquals(errorDetail, errorDetail2);
    }

    @Test
    public void equalsMethodDifferentTimeStampTest() {
        errorDetail.setError("some error");
        errorDetail.setMessage("go away");
        errorDetail.setPath("i am sleepy");
        errorDetail.setStatus(404);
        errorDetail.setTimestamp("13/01/199");
        errorDetail2.setError("some error");
        errorDetail2.setMessage("go away");
        errorDetail2.setPath("i am sleepy");
        errorDetail2.setStatus(404);
        errorDetail2.setTimestamp("13/01/19922222222");
        Assert.assertNotEquals(errorDetail, errorDetail2);
    }





}

