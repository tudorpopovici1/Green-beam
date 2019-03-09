package server.model;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class AchievementsTest {

    Achievements achievement = new Achievements();

    @Test
    void getUserId() {
        //achievements.userId() = Long.valueOf(1234);
        Long a1 = Long.valueOf(1234);
        assertThat(achievement.getUserId()).equals(a1);
    }



    @Test
    void setUserId() {

    }

    @Test
    void getAchievementId() {
        Long a1 = Long.valueOf(1234);
        assertThat(achievement.getAchievementId()).equals(a1);
    }



    @Test
    void setAchievementId() {
    }

}
