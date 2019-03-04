package serverTesting;

import client.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import server.exception.ResourceNotFoundException;
import server.model.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class userServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    private UserService userService = new UserService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser() {
        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {
            Date dob = dateFormat.parse("20-12-1999");
            Users user = new Users(0L, "username", "pwd", "fname",
                    "lname", "country", "email", dob, "user");

            Mockito
                    .when(restTemplate.getForObject("http://localhost:8080/rest/user/0", Users.class))
                    .thenReturn(user);

            Users result = userService.getUser(restTemplate, "http://localhost:8080/rest/user", 0L);

            Assert.assertEquals(user, result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

   /* @Test(expected = ResourceNotFoundException.class)
    public void getUserExceptionThrown() {

        Mockito
                .when(restTemplate.getForObject("http://localhost:8080/rest/user", Users.class))
                .thenThrow(new ResourceNotFoundException("The user is not available"));

        Users user = userService.getUser(restTemplate, "http://localhost:8080/rest/user", 16L);
    }*/
}
