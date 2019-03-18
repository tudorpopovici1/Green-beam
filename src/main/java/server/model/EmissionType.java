package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "emission_type",
        schema = "public"
)
class EmissionType {

    @Id
    @GeneratedValue
    @Column(name = "emission_id")
    private Long emissionId;

    @Column(name = "emission_name")
    private String emissionName;

    @Column(name = "emission_type")
    private String emissionType;


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


    public String getEmissionType() {
        return emissionType;
    }

    public void setEmissionType(String emissionType) {
        this.emissionType = emissionType;
    }

    @Override
    public String toString() {
        return "EmissionType{"
                + "emissionId=" + emissionId
                +  ", emissionName='" + emissionName + '\''
                + ", emissionType='" + emissionType + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmissionType)) return false;
        EmissionType that = (EmissionType) o;
        return Objects.equals(getEmissionId(), that.getEmissionId()) &&
                Objects.equals(getEmissionName(), that.getEmissionName()) &&
                Objects.equals(getEmissionType(), that.getEmissionType());
    }
}
