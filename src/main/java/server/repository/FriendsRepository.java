package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.model.EmissionFriend;
import server.model.Friends;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

    @Query ("SELECT f " +
            "FROM Friends f " +
            "WHERE f.relatedUserId = ?1 AND f.relationshipType = '2'")
    List<Friends> getFriendRequestSend(Long relatedUserId);

    @Query ("SELECT f " +
            "FROM Friends f " +
            "WHERE f.relatedUserId = ?1 AND f.relationshipType = '3'")
    List<Friends> getFriendRequestRecieved(Long relatedUserId);

}
