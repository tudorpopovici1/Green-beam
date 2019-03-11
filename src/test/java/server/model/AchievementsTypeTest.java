package server.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AchievementsTypeTest {
    AchievementsType achievementType = new AchievementsType();
    @org.junit.jupiter.api.Test
    public void getAchievementIdTest() {
        long achievementId = 1234L;
        achievementType.setAchievementId(achievementId);
        long setAchievementId = achievementType.getAchievementId();
        long expected = 1234L;
        Assert.assertEquals(setAchievementId, expected);
    }
    @org.junit.jupiter.api.Test
    public void setAchievementIdTest() {
        long achievementId = 1234L;
        achievementType.setAchievementId(achievementId);
        long setAchievementId = achievementType.getAchievementId();
        long expected = 1234L;
        Assert.assertEquals(setAchievementId, expected);
    }
    @Test
    public void getAchievementNameTest(){
        String achievementName="abc";
        achievementType.setAchievementName(achievementName);
        String expected = "abc";
        Assert.assertEquals(achievementType.getAchievementName(), expected);

    }
    @Test
    public void setAchievementNameTest(){
        String achievementName="abc";
        achievementType.setAchievementName(achievementName);
        String setAchievementName = achievementType.getAchievementName();
        String expected = "abc";
        Assert.assertEquals(setAchievementName, expected);

    }

}