package server.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

/**
 *
 */
@Entity(name = "user_data")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_data", schema = "public")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(
            name = "username",
            unique = true
    )
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "country")
    private String country;

    @Email
    @Column(
            name = "email",
            unique = true
    )
    private String email;

    //@DateTimeFormat
    @Column(name = "date_of_birth")
    private java.util.Date dateOfBirth;

    @Column(name = "user_role")
    private String role;

    public Users() {
    }

    public Users(final Long id, final String username,
                 final String password, final String firstName, final String lastName,
                 final String country, final @Email String email, final java.util.Date dateOfBirth,
                 final String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }



    /**
     * @return  String representation of this class.
     */
    @Override
    public String toString() {
        return "Users{"
                + "id="
                + id
                + ", username='" + username + '\''
                + ", password='" + password + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", country='" + country + '\''
                + ", email='" + email + '\''
                + ", dateOfBirth='" + dateOfBirth
                + '\''
                + '}';
    }

    /**
     * Sets new firstName.
     *
     * @param firstNameField New value of firstName.
     */
    public void setFirstName(final String firstNameField) {
        this.firstName = firstNameField;
    }

    /**
     * Sets new id.
     *
     * @param idField New value of id.
     */
    public void setId(final Long idField) {
        this.id = idField;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets role.
     *
     * @return Value of role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets new username.
     *
     * @param usernameField New value of username.
     */
    public void setUsername(final String usernameField) {
        this.username = usernameField;
    }

    /**
     * Sets new country.
     *
     * @param countryField New value of country.
     */
    public void setCountry(final String countryField) {
        this.country = countryField;
    }

    /**
     * Gets dateOfBirth.
     *
     * @return Value of dateOfBirth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets lastName.
     *
     * @return Value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets new email.
     *
     * @param emailField New value of email.
     */
    public void setEmail(final String emailField) {
        this.email = emailField;
    }

    /**
     * Gets username.
     *
     * @return Value of username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets country.
     *
     * @return Value of country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets new role.
     *
     * @param roleField New value of role.
     */
    public void setRole(final String roleField) {
        this.role = roleField;
    }

    /**
     * Sets new dateOfBirth.
     *
     * @param dateOfBirthField New value of dateOfBirth.
     */
    public void setDateOfBirth(final Date dateOfBirthField) {
        this.dateOfBirth = dateOfBirthField;
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
     * Sets new lastName.
     *
     * @param lastNameField New value of lastName.
     */
    public void setLastName(final String lastNameField) {
        this.lastName = lastNameField;
    }

    /**
     * Sets new password.
     *
     * @param passwordField New value of password.
     */
    public void setPassword(final String passwordField) {
        this.password = passwordField;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets firstName.
     *
     * @return Value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }
}
