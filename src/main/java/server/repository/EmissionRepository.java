package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.Emissions;

@Repository
public interface EmissionRepository extends JpaRepository<Emissions, Long> {



}
