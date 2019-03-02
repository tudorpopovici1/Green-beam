package server.model;

import javax.persistence.*;

@Entity
@Table(
        name = "achievements",
        schema = "public"
)
class Achievements {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "achievement_id")
    private Long achievementId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(final Long achievementId) {
        this.achievementId = achievementId;
    }
}