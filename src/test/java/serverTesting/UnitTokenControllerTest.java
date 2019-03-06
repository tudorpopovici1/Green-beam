package serverTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import server.controller.TokenController;
import server.controller.UserController;
import server.exception.BadCredentialsException;
import server.model.AuthenticateUser;
import server.model.JwtUser;
import server.model.Users;
import server.repository.UserRepository;
import server.security.JwtGenerator;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UnitTokenControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private TokenController tokenController;

    @Mock
    private UserRepository userRepository;

    private static AuthenticateUser authenticateUser;
    private static AuthenticateUser authenticateUser2;

    @Before
    public void init() {
        authenticateUser = new AuthenticateUser("321", "123");
        authenticateUser2 = new AuthenticateUser("12322", "abc");
    }

    @Test (expected = BadCredentialsException.class)
    public void UsernameNotFoundAuthentication() throws BadCredentialsException {
        when(userRepository.findByUsername(authenticateUser.getUsername())).thenReturn(null);
        tokenController.generate(authenticateUser);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadPasswordAuthentication() throws BadCredentialsException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String retrievedPassword = bCryptPasswordEncoder.encode("dummy_password");
        when(userRepository.findByUsername(authenticateUser.getUsername())).thenReturn(new Users());
        when(userRepository.findUserPassword(authenticateUser.getUsername())).thenReturn(retrievedPassword);
        tokenController.generate(authenticateUser);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadUsernameAndBadPasswordAuthentication() throws BadCredentialsException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String retrievedPassword = bCryptPasswordEncoder.encode("dummy_password");
        when(userRepository.findByUsername(authenticateUser2.getUsername())).thenReturn(null);
        when(userRepository.findUserPassword(authenticateUser2.getUsername())).thenReturn(retrievedPassword);
        tokenController.generate(authenticateUser2);
    }

    @Test
    public void GoodAuthentication() throws BadCredentialsException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String retrievedPassword = bCryptPasswordEncoder.encode(authenticateUser2.getPassword());
        when(userRepository.findByUsername(authenticateUser2.getUsername())).thenReturn(new Users());
        when(userRepository.findUserPassword(authenticateUser2.getUsername())).thenReturn(retrievedPassword);
        when(userRepository.findUserRole(authenticateUser2.getUsername())).thenReturn("user");
        when(userRepository.findUserId(authenticateUser2.getUsername())).thenReturn(1L);

        AuthenticateUser response = tokenController.generate(authenticateUser2);
        authenticateUser2.setToken(getTokenOfUser(authenticateUser2.getUsername(),
                "user", 1L));
        Assert.assertEquals(authenticateUser2, response);
    }

    private String getTokenOfUser(String username, String role, Long id) {
        JwtGenerator jwtGenerator = new JwtGenerator();
        JwtUser jwtUser = new JwtUser(username,
                id, role);
        return jwtGenerator.generate(jwtUser);
    }

}
