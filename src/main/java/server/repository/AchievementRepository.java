package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.Achievements;
import server.model.AchievementsType;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievements, Long> {

     @Query(value = "SELECT a " +
                    "FROM Achievements a " +
            "JOIN AchievementsType at ON a.id = at.achievementId " +
            "JOIN user_data u ON a.userId = u.id " +
            "WHERE u.id = :userId"
    )
    Achievements findAchievementsOfUser(Long userId);

    @Query(value = "SELECT DISTINCT ach " +
            "FROM Achievements ach " +
            "JOIN AchievementsType a ON ach.id = a.achievementId " +
            "JOIN user_data u ON ach.user_id = u.user_id " +
            "WHERE u.user_id=:userId ")
    List<AchievementsType> getAchievementsTypeOfUser(Long userId);

}
