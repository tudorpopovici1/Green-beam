package server.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT new server.model.FriendsUserResp(u.username, u.dateOfBirth, u.firstName, u.lastName) FROM user_data u " +
            "JOIN friends_relationship f ON(u.id = f.related_user_id) " +
            "WHERE f.relating_user_id = ?1")
    List<FriendsUserResp> findAllFriendsUser(Long userId);

    Users findByUsername(String username);
}
