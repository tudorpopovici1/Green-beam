package server.model;

import java.util.Objects;

public class JwtUser {

    private String userName;
    private long id;
    private String role;

    /**
     * Main constructor of this class.
     * @param userName username.
     * @param id id.
     * @param role role.
     */

    public JwtUser(String userName, long id, String role) {
        this.userName = userName;
        this.id = id;
        this.role = role;
    }

    public JwtUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "JwtUser{"
                + "userName='" + userName + '\''
                + ", id="
                + id
                + ", role='"
                + role
                + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JwtUser)) return false;
        JwtUser jwtUser = (JwtUser) o;
        return getId() == jwtUser.getId() &&
                Objects.equals(getUserName(), jwtUser.getUserName()) &&
                Objects.equals(getRole(), jwtUser.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getId(), getRole());
    }
}
