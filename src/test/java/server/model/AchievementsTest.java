package server.model;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AchievementsTest {

    Achievements achievement = new Achievements();

    @Test
    public void getUserIdTest() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long expected = 1234L;
        assertThat(achievement.getUserId()).isEqualTo(expected);
    }

    @Test
    public void setUserId() {
        long userId = 1234L;
        achievement.setUserId(userId);
        long expected = 1234L;
        assertThat(achievement.getUserId()).isEqualTo(expected);
    }

    @Test
    public void getAchievementId() {
        long achievementId = 3456L;
        achievement.setAchievementId(achievementId);
        long expected = 3456L;
        assertThat(achievement.getAchievementId()).isEqualTo(expected);
    }



    @Test
    public void setAchievementId() {
        long achievementId = 3456L;
        achievement.setAchievementId(achievementId);
        long expected = 3456L;
        assertThat(achievement.getAchievementId()).isEqualTo(expected);
    }

}