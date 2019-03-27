package server.model;

import java.util.Date;
import java.util.Objects;

public class FriendsUserResp {

    private String username;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private String country;
    private String email;

    /**
     * Class constructor.
     * @param username username.
     * @param dateOfBirth dateOfBirth.
     * @param firstName firstName.
     * @param lastName lastName.
     * @param country country.
     * @param email email.
     */

    public FriendsUserResp(final String username, final java.util.Date dateOfBirth,
                           final String firstName, final String lastName,
                           final String country, final String email) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
    }

    public FriendsUserResp() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FriendsUserResp{"
                + "username='" + username + '\''
                + ", dateOfBirth=" + dateOfBirth
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", country='" + country + '\''
                + ", email='" + email + '\''
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof FriendsUserResp)) {
            return false;
        }
        FriendsUserResp that = (FriendsUserResp) object;
        return Objects.equals(getUsername(), that.getUsername())
                && Objects.equals(getDateOfBirth(), that.getDateOfBirth())
                && Objects.equals(getFirstName(), that.getFirstName())
                && Objects.equals(getLastName(), that.getLastName())
                && Objects.equals(getCountry(), that.getCountry())
                && Objects.equals(getEmail(), that.getEmail());
    }
}
