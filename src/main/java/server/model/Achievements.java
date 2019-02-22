package server.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "achievements",
        schema = "public"
)
public class Achievements {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "achievement_id")
    private Long achievementId;

    @ManyToOne
    @JoinColumn(name = "achievement_join")
    private Achievements_type achievement;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Achievements_type getAchievementsType() {
        return achievement;
    }

    public void setAchievementsType(Achievements_type achievementsType) {
        this.achievement = achievementsType;
    }
}