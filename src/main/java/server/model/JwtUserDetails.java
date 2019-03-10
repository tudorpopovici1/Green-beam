package server.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtUserDetails that = (JwtUserDetails) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(token, that.token) &&
                Objects.equals(id, that.id) &&
                Objects.equals(authorities, that.authorities);
    }

    /**
     * Main constructor of this class.
     * @param userName username
     * @param id id
     * @param token token
     * @param grantedAuthorities grantedAuthorities
     */
    public JwtUserDetails(String userName,
                          long id, String token,
                          List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.id = id;
        this.token = token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
