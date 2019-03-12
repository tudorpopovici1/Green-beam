package server.model;

import org.junit.Assert;
import org.junit.Test;


public class FriendsTest {
    Friends friends= new Friends();

    @Test
    public void getRelatingUserIdTest() {
        long relatingUserId = 1234L;
        friends.setRelatingUserId(relatingUserId);
        long setRelatingUserId = friends.getRelatingUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatingUserId, expected);
    }

    @Test
    public void  getRelationshipTypeTest() {
        String relationshipType = "abc";
        friends.setRelationshipType(relationshipType);
        String setRelationshipType = friends.getRelationshipType();
        String expected = "abc";
        Assert.assertEquals(setRelationshipType, expected);
    }

    @Test
    public void getRelatedUserIdTest() {
        long relatedUserId = 1234L;
        friends.setRelatedUserId(relatedUserId);
        long setRelatedUserId = friends.getRelatedUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatedUserId, expected);
    }

    @Test
    public void setRelatingUserIdTest() {
        long relatingUserId = 1234L;
        friends.setRelatingUserId(relatingUserId);
        long setRelatingUserId = friends.getRelatingUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatingUserId, expected);
    }

    @Test
    public void setRelatedUserIdTest() {
        long relatedUserId = 1234L;
        friends.setRelatedUserId(relatedUserId);
        long setRelatedUserId = friends.getRelatedUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatedUserId, expected);
    }

    @Test
    public void setIdTest() {
        long Id = 1234L;
        friends.setId(Id);
        long setId = friends.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void setRelationshipTypeTest() {
        String relationshipType = "abc";
        friends.setRelationshipType(relationshipType);
        String setRelationshipType = friends.getRelationshipType();
        String expected = "abc";
        Assert.assertEquals(setRelationshipType, expected);
    }

    @Test
    public void getIdTest() {
        long Id = 1234L;
        friends.setId(Id);
        long setId = friends.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }
}