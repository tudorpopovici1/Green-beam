package server.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import server.model.JwtAuthenticationToken;
import server.model.JwtUser;
import server.model.JwtUserDetails;

import javax.inject.Inject;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class JwtAuthenticationProviderTest {

    @InjectMocks
    private static JwtAuthenticationProvider jwtAuthenticationProvider;

    @Mock
    private JwtValidator jwtValidator;

    private UsernamePasswordAuthenticationToken
            usernamePasswordAuthenticationToken;
    private JwtGenerator jwtGenerator;

    @Before
    public void init() {
        usernamePasswordAuthenticationToken = Mockito.mock(
                UsernamePasswordAuthenticationToken.class);
        jwtAuthenticationProvider = new JwtAuthenticationProvider();
        jwtGenerator = new JwtGenerator();
        jwtValidator = new JwtValidator();
    }

    @Test (expected = RuntimeException.class)
    public void retrieveUserJwtIsNull() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)
        usernamePasswordAuthenticationToken;

        when(jwtAuthenticationToken.getToken()).thenReturn(null);
        jwtAuthenticationProvider.retrieveUser("123", jwtAuthenticationToken);
    }

    @Test
    public void retrieveUserSuccessful() {
        String token = jwtGenerator.generate(new JwtUser(
                "123", 1L, "user"));
        JwtUserDetails expected = new JwtUserDetails("123", 1L, token, null);
        JwtAuthenticationToken jwtAuthenticationToken =
                new JwtAuthenticationToken(token);
        JwtUserDetails response = jwtAuthenticationProvider.retrieveUser(
                "123", jwtAuthenticationToken);
        Assert.assertEquals(expected.getUserName(), response.getUserName());
        Assert.assertEquals(expected.getToken(), response.getToken());
        Assert.assertEquals(expected.getAuthorities(), response.getAuthorities());
    }

}
