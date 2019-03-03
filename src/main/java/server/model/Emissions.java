package server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "emissions",
        schema = "public"
)
class Emissions {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "emission_type")
    private Long emissionType;

    @Column(name = "carbon_footprint")
    private Long carbonFootprint;

    @Column(name = "date_of_emission")
    private String date;


    /**
     * Sets new carbonFootprint.
     *
     * @param carbonFootprint New value of carbonFootprint.
     */
    public void setCarbonFootprint(Long carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
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
     * Sets new date.
     *
     * @param date New value of date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets new emissionType.
     *
     * @param emissionType New value of emissionType.
     */
    public void setEmissionType(Long emissionType) {
        this.emissionType = emissionType;
    }

    /**
     * Gets emissionType.
     *
     * @return Value of emissionType.
     */
    public Long getEmissionType() {
        return emissionType;
    }

    /**
     * Gets userId.
     *
     * @return Value of userId.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets new userId.
     *
     * @param userId New value of userId.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets date.
     *
     * @return Value of date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets carbonFootprint.
     *
     * @return Value of carbonFootprint.
     */
    public Long getCarbonFootprint() {
        return carbonFootprint;
    }
}