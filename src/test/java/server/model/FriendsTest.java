package server.model;

import org.junit.Assert;
import org.junit.Test;


public class FriendsTest {
    Friends friends = new Friends();
    Friends friends2 = new Friends();

    @Test
    public void getRelatingUserIdTest() {
        long relatingUserId = 1234L;
        friends.setRelatingUserId(relatingUserId);
        long setRelatingUserId = friends.getRelatingUserId();
        long expected = 1234L;
        Assert.assertEquals(setRelatingUserId, expected);
    }

    @Test
    public void getRelationshipTypeTest() {
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

    @Test
    public void toStringTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        String expected = "Friends{id=123, relatingUserId=789, relatedUserId=456, relationshipType='bro'}";
        Assert.assertEquals(expected, friends.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2 = friends;
        Assert.assertEquals(friends, friends2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2.setId(123L);
        friends2.setRelatedUserId(456L);
        friends2.setRelatingUserId(789L);
        friends2.setRelationshipType("bro");
        Assert.assertEquals(friends, friends2);
    }

    @Test
    public void equalsMethodDifferenIdTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2.setId(1233L);
        friends2.setRelatedUserId(456L);
        friends2.setRelatingUserId(789L);
        friends2.setRelationshipType("bro");
        Assert.assertNotEquals(friends, friends2);
    }

    @Test
    public void equalsMethodDifferenRelatedUserIdTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2.setId(123L);
        friends2.setRelatedUserId(45633L);
        friends2.setRelatingUserId(789L);
        friends2.setRelationshipType("bro");
        Assert.assertNotEquals(friends, friends2);
    }

    @Test
    public void equalsMethodDifferenRelatingUserIdTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2.setId(123L);
        friends2.setRelatedUserId(456L);
        friends2.setRelatingUserId(78931L);
        friends2.setRelationshipType("bro");
        Assert.assertNotEquals(friends, friends2);
    }

    @Test
    public void equalsMethodDifferenRelationshipTypeTest() {
        friends.setId(123L);
        friends.setRelatedUserId(456L);
        friends.setRelatingUserId(789L);
        friends.setRelationshipType("bro");
        friends2.setId(123L);
        friends2.setRelatedUserId(456L);
        friends2.setRelatingUserId(789L);
        friends2.setRelationshipType("sis");
        Assert.assertNotEquals(friends, friends2);
    }


}