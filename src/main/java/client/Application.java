package client;


import client.services.MessageService;
import client.services.UserService;
import org.springframework.web.client.RestTemplate;
import server.exception.CustomException;


//@SpringBootApplication
public class Application {

    private static final String GET_MESSAGE = "http://localhost:8080/greeting";
    private static String GET_USER = "http://localhost:8080/rest/user";
    private static final String GET_ALL_USERS = "http://localhost:8080/rest/user/all";
    private static final String ADD_USER = "http://localhost:8080/rest/save/user";
    private static final String GET_USER_FRIENDS = "http://localhost:8080/rest/user/allfriends";

    private static final RestTemplate restTemplate = new RestTemplate();


    public static void main(final String[] args) throws CustomException {

        UserService userService = new UserService();

        MessageService messageService = new MessageService();

        Message msg = messageService.getMessage(restTemplate, GET_MESSAGE);

        userService.getUser(restTemplate, GET_USER, 15L);

        userService.addUser(restTemplate, ADD_USER,"test8");

        userService.getUserFriends(restTemplate, GET_USER_FRIENDS, 0L);

    }
}
