package server.model;

import org.junit.Assert;
import org.junit.Test;


public class AchievementsTypeTest {

    AchievementsType achievementType = new AchievementsType();
    AchievementsType achievementType2 = new AchievementsType();

    @Test
    public void getAchievementIdTest() {
        long achievementId = 1234L;
        achievementType.setAchievementId(achievementId);
        long setAchievementId = achievementType.getAchievementId();
        long expected = 1234L;
        Assert.assertEquals(setAchievementId, expected);
    }
    @Test
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

    @Test
    public void toStringTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        String expeted = "AchievementsType{achievementId=123, achievementName='hey'}";
        Assert.assertEquals(expeted, achievementType.toString());
    }

    @Test
    public void equalsMethodSameObjectTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2 = achievementType;
        Assert.assertEquals(achievementType, achievementType);
    }

    @Test
    public void equalsMethodDifferentObjectTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2.setAchievementName("hey");
        achievementType2.setAchievementId(123L);
        Assert.assertEquals(achievementType, achievementType);
    }

    @Test
    public void equalsMethodDifferentIdTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2.setAchievementName("hey");
        achievementType2.setAchievementId(1233L);
        Assert.assertNotEquals(achievementType, achievementType2);
    }

    @Test
    public void equalsMethodDifferentAchievementNameTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2.setAchievementName("heybro");
        achievementType2.setAchievementId(123L);
        Assert.assertNotEquals(achievementType, achievementType2);
    }

    @Test
    public void equalsFalseTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2.setAchievementName("heybro");
        achievementType2.setAchievementId(123L);
        Assert.assertEquals(false, achievementType.equals(achievementType2));
    }

    @Test
    public void equalsTrueTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2.setAchievementName("hey");
        achievementType2.setAchievementId(123L);
        Assert.assertEquals(true, achievementType.equals(achievementType2));
    }

    @Test
    public void equalsNullTest() {
        achievementType.setAchievementName("hey");
        achievementType.setAchievementId(123L);
        achievementType2 = null;
        Assert.assertEquals(false, achievementType.equals(achievementType2));
    }
}