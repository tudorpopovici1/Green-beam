package server.model;

import java.util.Date;

public class EmissionsClient {

    private String emissionType;
    private float carbonEmission;
    private Date date;

    /**
     * Emission client object constructor.
     * @param emissionType - type of emission
     * @param carbonEmission - CO2 unit
     * @param date - timestamp
     */
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

    @Override
    public String toString() {
        return "EmissionsClient{"
                + "emissionType='" + emissionType + '\''
                + ", carbonEmission=" + carbonEmission
                + ", date=" + date
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmissionsClient)) return false;
        EmissionsClient that = (EmissionsClient) o;
        return Float.compare(that.getCarbonEmission(), getCarbonEmission()) == 0 &&
                getEmissionType().equals(that.getEmissionType()) &&
                getDate().equals(that.getDate());
    }

}
