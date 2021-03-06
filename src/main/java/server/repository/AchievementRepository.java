package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.Achievements;
import server.model.AchievementsType;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievements, Long> {

    @Query("SELECT ach FROM AchievementsType ach "
            + "JOIN Achievements ac ON(ach.achievementId=ac.achievementId) "
            + "JOIN server.model.Users u ON(ac.userId=u.id) "
            + "WHERE u.id=?1")
    List<AchievementsType> getAllAchievementsTypeOfUser(Long userId);

    @Query(value = "SELECT COUNT(*) "
            + "FROM Achievements a "
            + "WHERE a.achievementId = ?1 AND a.userId = ?2")
    Integer getNumberOfSpecificAchievement(Long achievementId, Long userId);

}
