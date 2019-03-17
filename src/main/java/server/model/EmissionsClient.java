package server.model;

import java.util.Date;

public class EmissionsClient {

    private String emissionType;
    private float carbonEmission;
    private Date date;

    public EmissionsClient(String emissionType, float carbonEmission, Date date) {
        this.emissionType = emissionType;
        this.carbonEmission = carbonEmission;
        this.date = date;
    }

    public EmissionsClient() {
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
     * Gets carbonEmission.
     *
     * @return Value of carbonEmission.
     */
    public float getCarbonEmission() {
        return carbonEmission;
    }

    /**
     * Sets new carbonEmission.
     *
     * @param carbonEmission New value of carbonEmission.
     */
    public void setCarbonEmission(float carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    /**
     * Sets new date.
     *
     * @param date New value of date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return Value of date.
     */
    public Date getDate() {
        return date;
    }
}
