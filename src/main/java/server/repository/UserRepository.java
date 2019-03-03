package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.FriendsUserResp;
import server.model.Users;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT new server.model.FriendsUserResp"
            + "(u.username, u.dateOfBirth, u.firstName, "
            + "u.lastName, u.country, u.email) FROM user_data u "
            + "JOIN friends_relationship f ON(u.id = f.related_user_id) "
            + "WHERE f.relating_user_id = ?1")
    List<FriendsUserResp> findAllFriendsUser(Long userId);

    Users findByUsername(String username);

    @Query(value = "SELECT u.password FROM user_data u "
            + "WHERE u.username = ?1")
    String findUserPassword(String username);

    @Query(value = "SELECT u.id FROM user_data u "
            + "WHERE u.username = ?1")
    Long findUserId(String username);

    @Query(value = "SELECT u.role FROM user_data u "
            + "WHERE u.username = ?1")
    String findUserRole(String username);

    Users findByEmail(String username);

    @Query(value = "SELECT new server.model.FriendsUserResp"
            + "(u.username, u.dateOfBirth, u.firstName, "
            + "u.lastName, u.country, u.email) FROM user_data u "
            + "WHERE u.id=?1")
    FriendsUserResp findSpecificUserById(Long userId);
}
