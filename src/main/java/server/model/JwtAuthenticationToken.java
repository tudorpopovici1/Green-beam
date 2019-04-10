package server.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Objects;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(final String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationToken{"
                + "token='" + token + '\''
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof JwtAuthenticationToken)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        JwtAuthenticationToken that = (JwtAuthenticationToken) object;
        return Objects.equals(getToken(), that.getToken());
    }
}
