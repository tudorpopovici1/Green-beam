package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "emission_type",
        schema = "public"
)
class EmissionType {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "emission_id")
    private Long emissionId;

    @Column(columnDefinition = "emission_name")
    private String emissionName;


    /**
     * Sets new emissionId.
     *
     * @param emissionId New value of emissionId.
     */
    public void setEmissionId(Long emissionId) {
        this.emissionId = emissionId;
    }

    /**
     * Sets new emissionName.
     *
     * @param emissionName New value of emissionName.
     */
    public void setEmissionName(String emissionName) {
        this.emissionName = emissionName;
    }

    /**
     * Gets emissionId.
     *
     * @return Value of emissionId.
     */
    public Long getEmissionId() {
        return emissionId;
    }

    /**
     * Gets emissionName.
     *
     * @return Value of emissionName.
     */
    public String getEmissionName() {
        return emissionName;
    }
}
