package server.model;

import javax.persistence.*;

/**
 Model class for Achievements table.
 */

@Entity
@Table(
        name = "achievements",
        schema = "public"
)
class Achievements {

    /**
     * Fields of this class.
     */

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

    public void setUserId(final Long userId1) {
        this.userId = userId1;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(final Long achievementId1) {
        this.achievementId = achievementId1;
    }
}
