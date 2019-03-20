package server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmissionReductions {

    @JsonProperty("ride_my_bike")
    private float rideBikeEmission;

    @JsonProperty("take_public_transportation")
    private float publicTransportationEmission;

    @JsonProperty ("go_organic")
    private float localProduceEmission;

    @JsonProperty ("thermostat_winter")
    private float loweringTemperatureEmission;

    @JsonProperty ("low_carbon_diet")
    private float vegetarianMealEmission;

    /**
     * Constructor of the class.
     * @param rideBikeEmission - takes a float number of the C02 emission
     * @param publicTransportationEmission - takes a float number of the C02 emission
     * @param localProduceEmission - takes a float number of the C02 emission
     * @param loweringTemperatureEmission - takes a float number of the C02 emission
     * @param vegetarianMealEmission - takes a float number of the C02 emission
     */
    public EmissionReductions(float rideBikeEmission,
                              float publicTransportationEmission,
                              float localProduceEmission,
                              float loweringTemperatureEmission,
                              float vegetarianMealEmission) {
        this.rideBikeEmission = rideBikeEmission;
        this.publicTransportationEmission = publicTransportationEmission;
        this.localProduceEmission = localProduceEmission;
        this.loweringTemperatureEmission = loweringTemperatureEmission;
        this.vegetarianMealEmission = vegetarianMealEmission;
    }

    public EmissionReductions() {};

    /**
     * Gets localProduceEmission.
     *
     * @return Value of localProduceEmission.
     */
    public float getLocalProduceEmission() {
        return localProduceEmission;
    }

    /**
     * Sets new publicTransportationEmission.
     *
     * @param publicTransportationEmission New value of publicTransportationEmission.
     */
    public void setPublicTransportationEmission(float publicTransportationEmission) {
        this.publicTransportationEmission = publicTransportationEmission;
    }

    /**
     * Gets publicTransportationEmission.
     *
     * @return Value of publicTransportationEmission.
     */
    public float getPublicTransportationEmission() {
        return publicTransportationEmission;
    }

    /**
     * Sets new vegetarianMealEmission.
     *
     * @param vegetarianMealEmission New value of vegetarianMealEmission.
     */
    public void setVegetarianMealEmission(float vegetarianMealEmission) {
        this.vegetarianMealEmission = vegetarianMealEmission;
    }

    /**
     * Gets loweringTemperatureEmission.
     *
     * @return Value of loweringTemperatureEmission.
     */
    public float getLoweringTemperatureEmission() {
        return loweringTemperatureEmission;
    }

    /**
     * Gets rideBikeEmission.
     *
     * @return Value of rideBikeEmission.
     */
    public float getRideBikeEmission() {
        return rideBikeEmission;
    }

    /**
     * Sets new loweringTemperatureEmission.
     *
     * @param loweringTemperatureEmission New value of loweringTemperatureEmission.
     */
    public void setLoweringTemperatureEmission(float loweringTemperatureEmission) {
        this.loweringTemperatureEmission = loweringTemperatureEmission;
    }

    /**
     * Sets new rideBikeEmission.
     *
     * @param rideBikeEmission New value of rideBikeEmission.
     */
    public void setRideBikeEmission(float rideBikeEmission) {
        this.rideBikeEmission = rideBikeEmission;
    }

    /**
     * Gets vegetarianMealEmission.
     *
     * @return Value of vegetarianMealEmission.
     */
    public float getVegetarianMealEmission() {
        return vegetarianMealEmission;
    }

    /**
     * Sets new localProduceEmission.
     *
     * @param localProduceEmission New value of localProduceEmission.
     */
    public void setLocalProduceEmission(float localProduceEmission) {
        this.localProduceEmission = localProduceEmission;
    }

    @Override
    public String toString() {
        return "EmissionReductions{"
                + "rideBikeEmission="
                + rideBikeEmission
                + ", publicTransportationEmission=" + publicTransportationEmission
                + ", localProduceEmission=" + localProduceEmission
                + ", loweringTemperatureEmission=" + loweringTemperatureEmission
                + ", vegetarianMealEmission=" + vegetarianMealEmission
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmissionReductions)) return false;
        EmissionReductions that = (EmissionReductions) o;
        return Float.compare(that.getRideBikeEmission(), getRideBikeEmission()) == 0 &&
                Float.compare(that.getPublicTransportationEmission(), getPublicTransportationEmission()) == 0 &&
                Float.compare(that.getLocalProduceEmission(), getLocalProduceEmission()) == 0 &&
                Float.compare(that.getLoweringTemperatureEmission(), getLoweringTemperatureEmission()) == 0 &&
                Float.compare(that.getVegetarianMealEmission(), getVegetarianMealEmission()) == 0;
    }
}
