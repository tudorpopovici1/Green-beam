package server.model;

import org.junit.Assert;
import org.junit.Test;

public class AchievementsTest {

    Achievements achievement = new Achievements();
    Achievements achievement2 = new Achievements();

    @Test
    public void getIdTest() {
        long id = 1234L;
        achievement.setId(id);
        long setId = achievement.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }

    @Test
    public void setIdTest() {
        long id = 1234L;
        achievement.setId(id);
        long setId = achievement.getId();
        long expected = 1234L;
        Assert.assertEquals(setId, expected);
    }


    @Test
    public void getUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @Test
    public void setUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @Test
    public void getAchievementIdTest() {
        long achievementId = 1234L;
        achievement.setAchievementId(achievementId);
        long setAchievementId = achievement.getAchievementId();
        long expected = 1234L;
        Assert.assertEquals(setAchievementId, expected);
    }


    @Test
    public void setAchievementIdTest() {
        long achievementId = 1234L;
        achievement.setAchievementId(achievementId);
        long setAchievementId = achievement.getAchievementId();
        long expected = 1234L;
        Assert.assertEquals(setAchievementId, expected);
    }

    @Test
    public void toStringTest() {
        achievement.setId(123L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        String expected = "Achievements{id=123, userId=456, achievementId=789}";
        Assert.assertEquals(expected, achievement.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        achievement.setId(123L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        achievement2 = achievement;
        Assert.assertEquals(achievement, achievement2);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        achievement.setId(123L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        achievement2.setId(123L);
        achievement2.setUserId(456L);
        achievement2.setAchievementId(789L);
        Assert.assertEquals(achievement, achievement2);
    }

    @Test
    public void equalsMethodDifferentIdTest() {
        achievement.setId(1234L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        achievement2.setId(123L);
        achievement2.setUserId(456L);
        achievement2.setAchievementId(789L);
        Assert.assertNotEquals(achievement, achievement2);
    }

    @Test
    public void equalsMethodDifferentUserIdTest() {
        achievement.setId(123L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        achievement2.setId(123L);
        achievement2.setUserId(4567L);
        achievement2.setAchievementId(789L);
        Assert.assertNotEquals(achievement, achievement2);
    }

    @Test
    public void equalsMethodDifferentAchievementIdTest() {
        achievement.setId(123L);
        achievement.setUserId(456L);
        achievement.setAchievementId(789L);
        achievement2.setId(123L);
        achievement2.setUserId(456L);
        achievement2.setAchievementId(7899L);
        Assert.assertNotEquals(achievement, achievement2);
    }
}
