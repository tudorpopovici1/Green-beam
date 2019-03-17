package server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "emissions",
        schema = "public"
)
public class Emissions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "emission_type")
    private String emissionType;

    @Column(name = "carbon_footprint")
    private float carbonFootprint;

    @Column(name = "date_of_emission")
    private Date date;

    public Emissions(Long userId, String emissionType, float carbonFootprint, Date date) {
        this.userId = userId;
        this.emissionType = emissionType;
        this.carbonFootprint = carbonFootprint;
        this.date = date;
    }


    /**
     * Sets new carbonFootprint.
     *
     * @param carbonFootprint New value of carbonFootprint.
     */
    public void setCarbonFootprint(float carbonFootprint) {
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
     * Sets new emissionType.
     *
     * @param emissionType New value of emissionType.
     */
    public void setEmissionType(String emissionType) {
        this.emissionType = emissionType;
    }

    /**
     * Gets emissionType.
     *
     * @return Value of emissionType.
     */
    public String getEmissionType() {
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
     * Gets carbonFootprint.
     *
     * @return Value of carbonFootprint.
     */
    public float getCarbonFootprint() {
        return carbonFootprint;
    }

    /**
     * Gets date.
     *
     * @return Value of date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets new date.
     *
     * @param date New value of date.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}