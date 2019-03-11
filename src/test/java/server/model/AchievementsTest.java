package server.model;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;


public class AchievementsTest {

    Achievements achievement = new Achievements();

    @Test
    public void getUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @Test
    public void setUserId() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setUserId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setUserId, expected);
    }

    @Test
    public void getAchievementId() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setAchivementId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setAchivementId, expected);
    }



    @Test
    public void setAchievementId() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long setAchivementId = achievement.getUserId();
        long expected = 1234L;
        Assert.assertEquals(setAchivementId, expected);
    }

}