package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.Emissions;

@Repository
public interface EmissionRepository extends JpaRepository<Emissions, Long> {

    @Query(value = "SELECT SUM(emi.carbonFootprint)" +
            "FROM Emissions emi " +
            "JOIN server.model.Users u  ON(u.id=emi.userId) " +
            "WHERE u.username=?1")
    Double getAllEmisionsOfUser(String username);

}
