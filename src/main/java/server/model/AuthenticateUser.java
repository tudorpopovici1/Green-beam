package server.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class AuthenticateUser {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String token;

    public AuthenticateUser() {
    }

    public AuthenticateUser(final String username1, final String password1) {
        this.username = username1;
        this.password = password1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username1) {
        this.username = username1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password1) {
        this.password = password1;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token1) {
        this.token = token1;
    }

    @Override
    public String toString() {
        return "AuthenticateUser{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", token='" + token + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthenticateUser that = (AuthenticateUser) obj;
        return Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(token, that.token);
    }
}
