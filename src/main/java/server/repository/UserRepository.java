package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.FriendsUserResp;
import server.model.Users;

import java.util.List;
import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT new server.model.FriendsUserResp"
            + "(u.username, u.dateOfBirth, u.firstName, "
            + "u.lastName, u.country, u.email) FROM user_data u "
            + "JOIN friends_relationship f ON(u.id = f.relatedUserId) "
            + "WHERE f.relatingUserId = ?1")
    List<FriendsUserResp> findAllFriendsUser(Long userId);

    Users findByUsername(String username);

    @Query(value = "SELECT u.password FROM user_data u "
            + "WHERE u.username = ?1")
    String findUserPassword(String username);

    @Query(value = "SELECT u.id FROM user_data u "
            + "WHERE u.username = ?1")
    Long findUserId(String username);

    @Query(value = "SELECT u.username FROM user_data u "
            + "WHERE u.id = ?1")
    String findUserUsername(Long userId);

    @Query(value = "SELECT u FROM user_data u WHERE id=?1")
    Users findUserById(Long id);

    @Query(value = "SELECT u.role FROM user_data u "
            + "WHERE u.username = ?1")
    String findUserRole(String username);

    Users findByEmail(String username);

    @Query(value = "SELECT new server.model.FriendsUserResp"
            + "(u.username, u.dateOfBirth, u.firstName, "
            + "u.lastName, u.country, u.email) FROM user_data u "
            + "WHERE u.id=?1")
    FriendsUserResp findSpecificUserById(Long userId);

    @Query(value = "SELECT new server.model.FriendsUserResp "
            + "(u.username, u.dateOfBirth, u.firstName, "
            + "u.lastName, u.country, u.email) FROM user_data u "
            + "WHERE u.username LIKE %:username% ")
    List<FriendsUserResp> queryFriends(String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user_data u WHERE u.username=?1")
    void deleteByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_data u SET u.country = ?1 WHERE u.userId = ?2")
    void updateCountryUser(String country, Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDDATE user_date u SET u.name = ?1 WHERE u.userId = ?2")
    void updateNameUser(String name, Long userId);
}
