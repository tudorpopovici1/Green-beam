package server.model;
import org.junit.jupiter.api.Test;


import java.util.Objects;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class AchievementsTest {

    Achievements ach=new Achievements();

    @Test
    void getUserId() {
        //achievements.userId() = Long.valueOf(1234);
        Long a1 = Long.valueOf(1234);
        assertThat(ach.getUserId()).equalsTo(a1);


    }



    @Test
    void setUserId() {

    }

    @Test
    void getAchievementId() {
        Long a1 = Long.valueOf(1234);
        assertThat(ach.getAchievementId()).equals(a1);

    }



    @Test
    void setAchievementId() {
    }}

