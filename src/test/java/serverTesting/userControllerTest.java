package serverTesting;

import client.Url;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.WebApplicationContext;
import server.Application;
import server.controller.UserController;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.Users;
import server.repository.UserRepository;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class userControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserRepository userRepository;

    private static Users user1;
    private static Users user2;
    private static Users user3;
    private static Users user4;

    @Before
    public void setUp() {

        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {

            Date dob = dateFormat.parse("20-12-1999");

            user1 = new Users(null, "userno1", "pwd", "firstName", "lastName",
                    "country", "userno1@email.com", dob, "user");
            user2 = new Users(null, "userno5", "pwd", "firstName", "lastName",
                    "country", "userno5@email.com", dob, "user");
            user3 = new Users(null, "userno6", "pwd", "firstName", "lastName",
                    "country", "userno6@email.com", dob, "user");
            user4 = new Users(null, "123", "pwd", "firstName", "lastName",
                    "country", "userno6@email.com", dob, "user");

            userRepository.save(user2);
            userRepository.save(user3);

        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

   @After
  public void afterAll() {
        userRepository.deleteByUsername(user1.getUsername());
       userRepository.deleteByUsername(user2.getUsername());
       userRepository.deleteByUsername(user3.getUsername());
    }

    @Test
    public void AddNewUserTest() {
        Users response = restTemplate.postForObject(
                "http://localhost:" + port + "/rest/save/user", user1,
                Users.class);
        user1.setPassword(response.getPassword());
        user1.setId(response.getId());
        Assert.assertEquals(user1, response);
    }


    @Test
    public void AddNewUserAlreadyRegisteredUsername() {
        try {
            Users response = restTemplate.postForObject(
                    "http://localhost:" + port + "/rest/save/user", user4,
                    Users.class);
        } catch(HttpStatusCodeException e) {

        }

        //Test for error here.
    }


}
