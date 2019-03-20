package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 Model class for Achievements table.
 */

@Entity
@Table(
        name = "achievements",
        schema = "public"
)
public class Achievements {

    /**
     * Fields of this class.
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "achievement_id")
    public Long achievementId;

    public Achievements(Long userId, Long achievementId) {
        this.userId = userId;
        this.achievementId = achievementId;
    }

    public Achievements(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Achievements{"
                + "id=" + id
                + ", userId=" + userId
                + ", achievementId=" + achievementId
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Achievements)) return false;
        Achievements that = (Achievements) o;
        return id.equals(that.id) &&
                getUserId().equals(that.getUserId()) &&
                getAchievementId().equals(that.getAchievementId());
    }
}
