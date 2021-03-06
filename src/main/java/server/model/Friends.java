package server.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "friends_relationship")
@Table(
        name = "friends_relationship",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"relating_user_id", "related_user_id"})}
)
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "relating_user_id")
    private Long relatingUserId;

    @Column(name = "related_user_id")
    private Long relatedUserId;

    @Column(name = "relationship_type")
    private String relationshipType;

    /**
     * Creates a new friend object.
     * @param relatingUserId relating id.
     * @param relatedUserId related id.
     * @param relationshipType relationship type
     */

    public Friends(Long relatingUserId, Long relatedUserId, String relationshipType) {
        this.relatingUserId = relatingUserId;
        this.relatedUserId = relatedUserId;
        this.relationshipType = relationshipType;
    }

    public Friends(){}

    /**
     * Gets relatingUserId.
     *
     * @return Value of relatingUserId.
     */
    public Long getRelatingUserId() {
        return relatingUserId;
    }

    /**
     * Gets relationshipType.
     *
     * @return Value of relationshipType.
     */
    public String getRelationshipType() {
        return relationshipType;
    }

    /**
     * Gets relatedUserId.
     *
     * @return Value of relatedUserId.
     */
    public Long getRelatedUserId() {
        return relatedUserId;
    }

    /**
     * Sets new relatingUserId.
     *
     * @param relatingUserId New value of relatingUserId.
     */
    public void setRelatingUserId(Long relatingUserId) {
        this.relatingUserId = relatingUserId;
    }

    /**
     * Sets new relatedUserId.
     *
     * @param relatedUserId New value of relatedUserId.
     */
    public void setRelatedUserId(Long relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets new relationshipType.
     *
     * @param relationshipType New value of relationshipType.
     */
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Friends{"
                + "id=" + id
                + ", relatingUserId=" + relatingUserId
                + ", relatedUserId=" + relatedUserId
                + ", relationshipType='" + relationshipType + '\''
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends friends = (Friends) object;
        return Objects.equals(getId(), friends.getId())
                && Objects.equals(getRelatingUserId(), friends.getRelatingUserId())
                && Objects.equals(getRelatedUserId(), friends.getRelatedUserId())
                && Objects.equals(getRelationshipType(), friends.getRelationshipType());
    }

}