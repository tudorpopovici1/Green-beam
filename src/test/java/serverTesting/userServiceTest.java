package serverTesting;

import client.services.MessageService;
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
import server.exception.CustomException;
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
    UserService userService = new UserService();

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser() throws CustomException {
        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try{
            Date dob = dateFormat.parse("20-12-1999");
            Users user = new Users(0L, "username", "pwd", "fname", "lname", "country", "email", dob);

            Mockito
                    .when(restTemplate.getForObject("http://localhost:8080/rest/user/0", Users.class))
                    .thenReturn(user);

            Users result = userService.getUser(restTemplate, "http://localhost:8080/rest/user", 0L);

            Assert.assertEquals(user, result);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
    }

}
