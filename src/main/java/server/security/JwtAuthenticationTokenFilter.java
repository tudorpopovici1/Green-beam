package server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import server.model.JwtAuthenticationToken;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public  JwtAuthenticationTokenFilter() {
        super("/rest/user/**");
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws AuthenticationException {

        String header = httpServletRequest.getHeader("Authorisation");

        if (header == null || !header.startsWith("Token")) {
            throw new RuntimeException("JWT Token is missing.");
        }

        String authenticationToken = header.substring(6);

        JwtAuthenticationToken jwtAuthenticationToken =
                new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(jwtAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

}
