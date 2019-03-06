package serverTesting;

import client.Url;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import server.Application;
import server.exception.BadCredentialsException;
import server.model.AuthenticateUser;
import server.model.ErrorDetails;
import server.model.JwtUser;
import server.security.JwtGenerator;
import server.security.JwtValidator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class tokenControllerTest {

    //@Autowired
    //Environment environment;

    //String port = environment.getProperty("local.server.port");

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    private AuthenticateUser authenticateUser;
    private AuthenticateUser authenticateUser2;

    private JwtGenerator jwtGenerator;

    @Before
    public void init() {
        authenticateUser = new AuthenticateUser("321", "123");
        authenticateUser2 = new AuthenticateUser("12322", "abc");

        jwtGenerator = new JwtGenerator();
        authenticateUser.setToken(getTokenOfUser(authenticateUser.getUsername(),
                "user", 69L));
    }

    @Test
    public void authenticateGoodUserCredentialsTest() {

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        AuthenticateUser response = restTemplate.postForObject(
                "http://localhost:" + port + "/token", authenticateUser, AuthenticateUser.class);

        Assert.assertEquals(response.getToken(), authenticateUser.getToken());
    }

   /* @Test (expected = BadCredentialsException.class)
    public void authenticateBadUserCredentialsUsernameTest() {

        AuthenticateUser response = restTemplate.postForObject(
                "http://localhost:" + port + "/token", authenticateUser2,
                AuthenticateUser.class);
    }*/

    private String getTokenOfUser(String username, String role, Long id) {
        JwtUser jwtUser = new JwtUser(username,
                id, role);
        return jwtGenerator.generate(jwtUser);
    }

}
