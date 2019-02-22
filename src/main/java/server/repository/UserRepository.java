package server.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM user_data u " +
            "JOIN friends_relationship f ON(u.id = f.related_user_id) " +
            "WHERE f.relating_user_id = ?1")
    List<Users> findAllFriendsUser(Long userId);
}
