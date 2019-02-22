package server.repository;

import org.springframework.stereotype.Repository;
import server.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
