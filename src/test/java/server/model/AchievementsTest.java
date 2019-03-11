package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;


public class AchievementsTest {

    Achievements achievement = new Achievements();

    @org.junit.jupiter.api.Test
    public void getUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @org.junit.jupiter.api.Test
    public void setUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @org.junit.jupiter.api.Test
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

}