package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.EmissionFriend;
import server.model.Friends;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

    @Query ("SELECT f " +
            "FROM server.model.Friends f " +
            "WHERE f.relatedUserId = ?1 AND f.relationshipType = '2'")
    List<Friends> getFriendRequestSend(Long relatedUserId);

    @Query ("SELECT f " +
            "FROM server.model.Friends f " +
            "WHERE f.relatedUserId = ?1 AND f.relationshipType = '3'")
    List<Friends> getFriendRequestRecieved(Long relatedUserId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE server.model.Friends f SET f.relationshipType = ?1 WHERE f.relatingUserId = ?2 AND f.relatedUserId = ?3")
    void updateRelationshipType(String relationshipType, Long relatingUserId, Long relatedUserId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM server.model.Friends f WHERE f.relatingUserId = ?1 AND f.relatedUserId = ?2")
    void deleteFriend(Long relatingUserId, Long relatedUserId);
}
