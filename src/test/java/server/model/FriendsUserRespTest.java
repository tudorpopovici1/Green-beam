package server.model;

import java.util.Objects;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class FriendsUserRespTest {

    FriendsUserResp friendsUserResp = new FriendsUserResp();

    @org.junit.jupiter.api.Test
    public void getFirstNameTest() {
        String firstName = "abc";
        friendsUserResp.setFirstName(firstName);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getFirstName(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setFirstNameTest() {
        String firstName = "abc";
        friendsUserResp.setFirstName(firstName);
        String setFirstName = friendsUserResp.getFirstName();
        String expected = "abc";
        Assert.assertEquals(setFirstName, expected);
    }

    @org.junit.jupiter.api.Test
    public void getLastNameTest() {
        String lastName = "abc";
        friendsUserResp.setLastName(lastName);
        String expected = "abc";
        Assert.assertEquals(friendsUserResp.getLastName(), expected);
    }

    @org.junit.jupiter.api.Test
    public void setLastNameTest() {
        String lastName = "abc";
        friendsUserResp.setLastName(lastName);
        String setLastName = friendsUserResp.getLastName();
        String expected = "abc";
        Assert.assertEquals(setLastName, expected);
    }

}