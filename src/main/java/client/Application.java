package client;


import client.services.MessageService;
import client.services.UserService;
import org.springframework.web.client.RestTemplate;
import server.model.AuthenticateUser;
import server.model.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//@SpringBootApplication
public class Application {

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String ADD_USER = URL.ADD_USER.getUrl();
    private static final String GET_USER_FRIENDS = URL.GET_USER_FRIENDS.getUrl();
    private static final String GET_USER = URL.GET_USER.getUrl();
    private static final String AUTH_USER = URL.AUTH_USER.getUrl();
    private static final String GET_ALL_USERS = URL.GET_ALL_USERS.getUrl();


    public static void main(final String[] args) {

        UserService userService = new UserService();

        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try {

            Date dob = dateFormat.parse("20-12-1999");
            Users user = new Users(null, "demo", "123", "TestName", "LastName", "RO", "123@gmail.com", dob);

            userService.addUser(restTemplate, ADD_USER,user);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        userService.getUser(restTemplate, GET_USER, 15L);

        userService.getUserFriends(restTemplate, GET_USER_FRIENDS, 0L);

        userService.authUser(restTemplate, AUTH_USER, new AuthenticateUser("test15", "123"));

    }
}
