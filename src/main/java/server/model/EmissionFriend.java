package server.model;

import java.util.Objects;

public class EmissionFriend {

    private String userName;
    private double carbonEmission;

    public EmissionFriend(String username, double carbonEmission) {
        this.userName = username;
        this.carbonEmission = carbonEmission;
    }

    public EmissionFriend() {
    }


    /**
     * Sets new username.
     *
     * @param username New value of username.
     */
    public void setUsername(String username) {
        this.userName = username;
    }

    /**
     * Gets username.
     *
     * @return Value of username.
     */
    public String getUsername() {
        return userName;
    }

    /**
     * Sets new carbonEmission.
     *
     * @param carbonEmission New value of carbonEmission.
     */
    public void setCarbonEmission(double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    /**
     * Gets carbonEmission.
     *
     * @return Value of carbonEmission.
     */
    public Double getCarbonEmission() {
        return carbonEmission;
    }

    @Override
    public String toString() {
        return "EmissionFriend{"
                + "username='" + userName + '\''
                + ", carbonEmission=" + carbonEmission
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EmissionFriend)) {
            return false;
        }
        EmissionFriend that = (EmissionFriend) object;
        return Double.compare(that.getCarbonEmission(), getCarbonEmission()) == 0
                && Objects.equals(userName, that.userName);
    }
}
