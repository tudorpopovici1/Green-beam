package server.model;


import javax.persistence.*;

@Entity
@Table(
        name = "achievements_type",
        schema = "public"
)
class Achievements_type {

    @Id
    @GeneratedValue
    @Column(name = "achievement_id")
    private Long achievementId;

    @Column(name = "achievement_name")
    private String achievementName;

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(final Long achievementId1) {
        this.achievementId = achievementId1;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(final String achievementName1) {
        this.achievementName = achievementName1;
    }
}
