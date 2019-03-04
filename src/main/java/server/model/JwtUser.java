package server.model;

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
}
