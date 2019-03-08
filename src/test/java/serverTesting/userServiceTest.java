package serverTesting;

import client.Url;
import client.services.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import javafx.scene.control.Label;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.AuthenticateUser;
import server.model.FriendsUserResp;
import server.model.Users;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class userServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    private static Users user1;
    private static Users user2;
    private static Users user3;
    private static Users user4;

    private static AuthenticateUser authUser1;
    private static AuthenticateUser authUser2;

    private static FriendsUserResp friendsUserResp1;
    private static FriendsUserResp friendsUserResp2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {
            Date dob = dateFormat.parse("20-12-1999");
            user1 = new Users(1L, "userno1", "pwd", "firstName", "lastName",
                    "country", "userno1@email.com", dob, "user");
            user2 = new Users(2L, "userno5", "pwd", "firstName", "lastName",
                    "country", "userno5@email.com", dob, "user");
            user3 = new Users(3L, "userno6", "pwd", "firstName", "lastName",
                    "country", "userno6@email.com", dob, "user");
            user4 = new Users(4L, "123", "pwd", "firstName", "lastName",
                    "country", "userno6@email.com", dob, "user");

            authUser1 = new AuthenticateUser("123", "123");
            authUser2 = new AuthenticateUser("321", "123");
            authUser1.setToken("token1");
            authUser2.setToken("token2");

            friendsUserResp1 = new FriendsUserResp("userno1", dob, "firstName", "lastName",
                    "country", "userno1@email.com");
            friendsUserResp2 = new FriendsUserResp("userno5", dob, "firstName", "lastName",
                    "country", "userno5@email.com");


        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUser() {
        when(restTemplate.getForObject(Url.GET_USER.getUrl() + "/1", Users.class))
                .thenReturn(user1);
        Users result = userService.getUser(restTemplate, Url.GET_USER.getUrl(), 1L);
        Assert.assertEquals(user1, result);
    }

    @Test
    public void UserNotFoundGetUser() {
        when(restTemplate.getForObject(Url.GET_USER.getUrl()+"/1", Users.class)).thenReturn(null);
        Users result = userService.getUser(restTemplate, Url.GET_USER.getUrl(), 1L);
        Assert.assertEquals(null, result);
    }

    @Test
    public void UserNotFoundOrBadCredentialsGetUser() {
      when(restTemplate.getForObject(Url.GET_USER.getUrl() + "/1", Users.class)).thenThrow(new HttpStatusCodeException(HttpStatus.NOT_FOUND) {
          @Override
          public HttpStatus getStatusCode() {
              return HttpStatus.NOT_FOUND;
          }
      });
        Users result = userService.getUser(restTemplate, Url.GET_USER.getUrl(), 1L);
        Assert.assertEquals(null, result);
    }

    @Test
    public void HttpStatusCodeExceptionButNotNotFoundStatusCodeGetUser() {
        when(restTemplate.getForObject(Url.GET_USER.getUrl()+"/1", Users.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.INTERNAL_SERVER_ERROR;
                    }
                });
        Users result = userService.getUser(restTemplate, Url.GET_USER.getUrl(), 1L);
        Assert.assertEquals(null, result);
    }

    @Test
    public void SuccessfullyAddUser() {
        when(restTemplate.postForObject(Url.ADD_USER.getUrl(), user1, Users.class)).thenReturn(user1);
        String result = userService.addUser(restTemplate, Url.ADD_USER.getUrl(), user1);
        Assert.assertEquals("Registration complete", result);
    }

    @Test
    public void PostForObjectAddUserReturnsNull() {
        when(restTemplate.postForObject(Url.ADD_USER.getUrl(), user1, Users.class)).thenReturn(null);
        String result = userService.addUser(restTemplate, Url.ADD_USER.getUrl(), user1);
        Assert.assertEquals("", result);
    }

    @Test
    public void BadRequestExceptionOnAddUser() {
        when(restTemplate.postForObject(Url.ADD_USER.getUrl(), user1, Users.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.BAD_REQUEST) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.BAD_REQUEST;
                    }

                    @Override
                    public String getResponseBodyAsString() {
                        return writeSpecificErrorAsJson(
                                "Username: user1 is already in use..");
                    }
                });
        String result = userService.addUser(restTemplate, Url.ADD_USER.getUrl(), user1);
        Assert.assertEquals("Username: user1 is already in use..", result);
    }

    @Test
    public void HttpStatusCodeExceptionButNotBadRequestStatusCodeAddUser() {
        when(restTemplate.postForObject(Url.ADD_USER.getUrl(), user1, Users.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.INTERNAL_SERVER_ERROR;
                    }

                    @Override
                    public String getResponseBodyAsString() {
                        return writeSpecificErrorAsJson(
                                "Username: user1 is already in use..");
                    }
                });
        String result = userService.addUser(restTemplate, Url.ADD_USER.getUrl(), user1);
        Assert.assertEquals("", result);
    }

    @Test
    public void successfulAuthUser() {
        when(restTemplate.postForObject(Url.AUTH_USER.getUrl(),
                authUser1, AuthenticateUser.class)).thenReturn(authUser1);
        String result = userService.authUser(restTemplate, Url.AUTH_USER.getUrl(),
                authUser1);
        Assert.assertEquals(authUser1.getToken(), result);
    }

    @Test
    public void PostForObjectReturnsNullAuthUser() {
        when(restTemplate.postForObject(Url.AUTH_USER.getUrl(),
                authUser1, AuthenticateUser.class)).thenReturn(null);
        String result = userService.authUser(restTemplate, Url.AUTH_USER.getUrl(),
                authUser1);
        Assert.assertEquals("", result);
    }

    @Test
    public void HttpStatusCodeExceptionStatusCodeIsForbiddenAuthUser() {
        when(restTemplate.postForObject(Url.AUTH_USER.getUrl(), authUser1, AuthenticateUser.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.FORBIDDEN) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.FORBIDDEN;
                    }
                    @Override
                    public String getResponseBodyAsString() {
                        return writeSpecificErrorAsJson(
                                "Incorrect username or password");
                    }
                });
        String result = userService.authUser(restTemplate, Url.AUTH_USER.getUrl(),
                authUser1);
        Assert.assertEquals("Incorrect username or password", result);
    }

    /*@Test
    public void getBadFormattedErrorMessageAuthUser() {
        when(restTemplate.postForObject(Url.AUTH_USER.getUrl(), authUser1, AuthenticateUser.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.FORBIDDEN) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.FORBIDDEN;
                    }
                    @Override
                    public String getResponseBodyAsString() {
                        return //writeSpecificErrorAsJson();
                        "{\"message\" / \"123\"}";
                    }
                });
        String result = userService.authUser(restTemplate, Url.AUTH_USER.getUrl(),
                authUser1);
        Assert.assertEquals("", result);
    }*/

    @Test
    public void HttpStatusCodeExceptionAnyOtherStatusCodeAuthUser() {
        when(restTemplate.postForObject(Url.AUTH_USER.getUrl(), authUser1, AuthenticateUser.class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return HttpStatus.INTERNAL_SERVER_ERROR;
                    }
                });
        String result = userService.authUser(restTemplate, Url.AUTH_USER.getUrl(),
                authUser1);
        Assert.assertEquals("", result);
    }

    @Test
    public void SuccessfullyGetUserFriends() {
        FriendsUserResp[] arrayOfFriends = new FriendsUserResp[1];
        arrayOfFriends[0] = friendsUserResp2;

        ResponseEntity<FriendsUserResp[]> arrayFriends = new ResponseEntity<>(arrayOfFriends, HttpStatus.OK);
        List<FriendsUserResp> expected = Arrays.asList(arrayOfFriends);

        when(restTemplate.getForEntity(Url.GET_USER_FRIENDS.getUrl()+"/1", FriendsUserResp[].class)).thenReturn(arrayFriends);

        List<FriendsUserResp> result = userService.getUserFriends(restTemplate,
                Url.GET_USER_FRIENDS.getUrl(),1L);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void HttpStatusCodeExceptionCaughtGetUserFriends() {
        when(restTemplate.getForEntity(Url.GET_USER_FRIENDS.getUrl()+"/1", FriendsUserResp[].class))
                .thenThrow(new HttpStatusCodeException(HttpStatus.NOT_FOUND) {
                });
        List<FriendsUserResp> expected = new ArrayList<>();
        List<FriendsUserResp> result = userService.getUserFriends(restTemplate, Url.GET_USER_FRIENDS.getUrl(),
                1L);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void ResponseEntityHasNullBodyGetUserFriends() {
        ResponseEntity<FriendsUserResp[]> arrayFriends = new ResponseEntity<>(null, HttpStatus.OK);
        when(restTemplate.getForEntity(Url.GET_USER_FRIENDS.getUrl()+"/1", FriendsUserResp[].class)).thenReturn(arrayFriends);
        List<FriendsUserResp> expected = new ArrayList<>();
        List<FriendsUserResp> result = userService.getUserFriends(restTemplate, Url.GET_USER_FRIENDS.getUrl(),
                1L);
        Assert.assertEquals(expected, result);
    }

    private String writeSpecificErrorAsJson(String errorMessage) {
        JsonFactory jFactory = new JsonFactory();
        StringWriter writer = new StringWriter();
        String jsonString = "";
        try {
            JsonGenerator jsonGenerator = jFactory.createJsonGenerator(writer);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("message", errorMessage);
            jsonGenerator.writeEndObject();
            jsonGenerator.close();
            jsonString = writer.toString();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private String writeSpecificErrorAsJson() {
        JsonFactory jFactory = new JsonFactory();
        StringWriter writer = new StringWriter();
        String jsonString = "";
        try {
            JsonGenerator jsonGenerator = jFactory.createJsonGenerator(writer);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("message", 123);
            jsonGenerator.writeEndObject();
            jsonGenerator.close();
            jsonString = writer.toString();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
