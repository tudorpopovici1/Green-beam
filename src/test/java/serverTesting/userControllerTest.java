package serverTesting;

import client.Url;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import server.controller.UserController;
import server.model.Users;
import server.repository.UserRepository;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class userControllerTest {

    private MockMvc mockMvc;

    @Spy
    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static Users user1;
    private static Users user2;
    private static Users user3;
    private static MediaType CONTENT_TYPE = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();

        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {

            Date dob = dateFormat.parse("20-12-1999");

            user1 = new Users(null, "userno1", "pwd", "firstName", "lastName",
                    "country", "email@email.com", dob, "user");
            user2 = new Users(null, "userno2", "pwd", "firstName", "lastName",
                    "country", "email2@email.com", dob, "user");
            user3 = new Users(null, "userno3", "pwd", "firstName", "lastName",
                    "country", "email3@email.com", dob, "user");
            //userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterAll() {
        userRepository.delete(user1);
        userRepository.delete(user2);
        userRepository.delete(user3);
    }

    @Test
    public void addUserTest() throws Exception {

        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {

            Date dob = dateFormat.parse("20-12-1999");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user1));
            mockMvc.perform(post(Url.ADD_USER.getUrl())
                    .contentType(CONTENT_TYPE)
                    .content(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user1)))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(CONTENT_TYPE))
                    .andExpect(jsonPath("$.id", Matchers.is(1)))
                    .andExpect(jsonPath("$.password", Matchers.is("pwd")))
                    .andExpect(jsonPath("$.firstName", Matchers.is("firstName")))
                    .andExpect(jsonPath("$.lastName", Matchers.is("lastName")))
                    .andExpect(jsonPath("$.country", Matchers.is("country")))
                    .andExpect(jsonPath("$.email", Matchers.is("email1@email.com")))
                    .andExpect(jsonPath("$.dateOfBirth", Matchers.is(dob)))
                    .andExpect(jsonPath("$.role", Matchers.is("user")));
        } catch(ParseException e) {
            e.printStackTrace();
        }

    }

}
