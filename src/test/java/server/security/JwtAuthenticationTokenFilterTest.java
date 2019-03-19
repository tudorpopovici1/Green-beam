package server.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import server.model.JwtUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collection;

import static org.mockito.Mockito.when;

public class JwtAuthenticationTokenFilterTest {

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private JwtGenerator jwtGenerator;

    @Mock
    private AbstractAuthenticationProcessingFilter abstractAuthenticationProcessingFilter;

    private static JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Before
    public void init() {
        httpServletRequest = Mockito.mock(HttpServletRequest.class);
        httpServletResponse = Mockito.mock(HttpServletResponse.class);
        jwtGenerator = new JwtGenerator();
        jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
    }

    @Test (expected = RuntimeException.class)
    public void attemptAuthenticationHeaderIsNullTest() {
        when(httpServletRequest.getHeader("Authorisation")).thenReturn(null);
        jwtAuthenticationTokenFilter.attemptAuthentication(httpServletRequest,
                httpServletResponse);
    }

    @Test (expected = RuntimeException.class)
    public void attemptAuthenticationIncorrectToken() {
        String incorrectToken = jwtGenerator.generate(new JwtUser("123", 1L, "user"));
        when(httpServletRequest.getHeader("Authorisation")).thenReturn(incorrectToken);
        jwtAuthenticationTokenFilter.attemptAuthentication(httpServletRequest,
                httpServletResponse);
    }

    @Test
    public void attemptAuthenticationSuccessful() {
        String token = "Token " + jwtGenerator.generate(new JwtUser("123", 1L, "user"));
        Authentication expected = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return token;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "123";
            }
        };
        when(httpServletRequest.getHeader("Authorisation")).thenReturn(token);

        jwtAuthenticationTokenFilter.setAuthenticationManager(authentication -> new Authentication() {
            @Override
            public String getName() {
                return "123";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return token;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }
        });

        Authentication response = jwtAuthenticationTokenFilter.attemptAuthentication(
                httpServletRequest, httpServletResponse);
        Assert.assertEquals(expected.getCredentials(), response.getCredentials());
        //Assert.assertEquals(expected, response);
    }

}
