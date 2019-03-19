package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "achievements_type",
        schema = "public"
)
public class AchievementsType {

    @Id
    @GeneratedValue
    @Column(name = "achievement_id")
    private Long achievementId;

    @Column(name = "achievement_name")
    private String achievementName;

    /**
     * Sets new achievementId.
     *
     * @param achievementId New value of achievementId.
     */
    public void setAchievementId(Long achievementId) {

        this.achievementId = achievementId;
    }

    /**
     * Gets achievementId.
     *
     * @return Value of achievementId.
     */
    public Long getAchievementId() {
        return achievementId;
    }

    /**
     * Sets new achievementName.
     *
     * @param achievementName New value of achievementName.
     */
    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    /**
     * Gets achievementName.
     *
     * @return Value of achievementName.
     */
    public String getAchievementName() {
        return achievementName;
    }

    @Override
    public String toString() {
        return "AchievementsType{"
                + "achievementId=" + achievementId
                + ", achievementName='" + achievementName + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AchievementsType)) return false;
        AchievementsType that = (AchievementsType) o;
        return getAchievementId().equals(that.getAchievementId()) &&
                getAchievementName().equals(that.getAchievementName());
    }

}
