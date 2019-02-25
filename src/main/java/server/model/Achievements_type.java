package server.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "achievements_type",
        schema = "public"
)
public class Achievements_type {

    @Id
    @GeneratedValue
    @Column(name = "achievement_id")
    private Long achievementId;

    @Column(name = "achievement_name")
    private String achievementName;

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(final Long achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(final String achievementName) {
        this.achievementName = achievementName;
    }

}