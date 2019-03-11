package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FriendsTest {
    Friends friends= new Friends();

    @org.junit.jupiter.api.Test
    public void getRelatingUserIdTest() {
        long relatingUserId = 1234L;
        friends.setRelatingUserId(relatingUserId);
        long setRelatingUserId = friends.getRelatingUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatingUserId, expected);
    }

    @org.junit.jupiter.api.Test
    public void  getRelationshipTypeTest() {
        String relationshipType = "abc";
        friends.setRelationshipType(relationshipType);
        String setRelationshipType = friends.getRelationshipType();
        String expected = "abc";
        Assert.assertEquals(setRelationshipType, expected);
    }

    @org.junit.jupiter.api.Test
    public void getRelatedUserIdTest() {
        long relatedUserId = 1234L;
        friends.setRelatedUserId(relatedUserId);
        long setRelatedUserId = friends.getRelatedUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatedUserId, expected);
    }

    @org.junit.jupiter.api.Test
    public void setRelatingUserIdTest() {
        long relatingUserId = 1234L;
        friends.setRelatingUserId(relatingUserId);
        long setRelatingUserId = friends.getRelatingUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatingUserId, expected);
    }

    @org.junit.jupiter.api.Test
    public void setRelatedUserIdTest() {
        long relatedUserId = 1234L;
        friends.setRelatedUserId(relatedUserId);
        long setRelatedUserId = friends.getRelatedUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatedUserId, expected);
    }

    @org.junit.jupiter.api.Test
    public void setIdTest() {
        long Id = 1234L;
        friends.setId(Id);
        long setId = friends.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @org.junit.jupiter.api.Test
    public void setRelationshipTypeTest() {
        String relationshipType = "abc";
        friends.setRelationshipType(relationshipType);
        String setRelationshipType = friends.getRelationshipType();
        String expected = "abc";
        Assert.assertEquals(setRelationshipType, expected);
    }

    @org.junit.jupiter.api.Test
    public void getIdTest() {
        long Id = 1234L;
        friends.setId(Id);
        long setId = friends.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }
}