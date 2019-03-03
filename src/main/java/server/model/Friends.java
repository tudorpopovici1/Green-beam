package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
class Friends {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "relating_user_id")
    private Long relatingUserId;

    @Column(name = "related_user_id")
    private Long relatedUserId;

    @Column(name = "relationship_type")
    private String relationshipType;


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
}