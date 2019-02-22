/*package server.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(
        name = "Friends",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"relating_user_id", "related_user_id"})
}
)
public class Friends {

    @Id
    @Column(columnDefinition = "relating_user_id")
    private Long relating_user_id;

    @Column(columnDefinition = "related_user_id")
    private Long related_user_id;

    @Column(columnDefinition = "relationship_type")
    private String relationship_type;

    public Long getRelating_user_id() {
        return relating_user_id;
    }

    public void setRelating_user_id(Long relating_user_id) {
        this.relating_user_id = relating_user_id;
    }

    public Long getRelated_user_id() {
        return related_user_id;
    }

    public void setRelated_user_id(Long related_user_id) {
        this.related_user_id = related_user_id;
    }

    public String getRelationship_type() {
        return relationship_type;
    }

    public void setRelationship_type(String relationship_type) {
        this.relationship_type = relationship_type;
    }
}
*/