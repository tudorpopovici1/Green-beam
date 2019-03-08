package client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import server.model.AuthenticateUser;
import server.model.ErrorDetails;
import server.model.FriendsUserResp;
import server.model.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents UserService.
 */

@Service
public class UserService {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     *  Gets a specific users' details.
     * @param restTemplate restTemplate instantation to use.
     * @param url Url of the request.
     * @param id id of the user.
     * @return a new User object.
     */

    public Users getUser(final RestTemplate restTemplate, String url, final Long id) {
        url += "/" + id.toString();
        Users user = null;
        try {

            user = restTemplate.getForObject(url, Users.class);
            if (user != null) {
                System.out.println(user.toString());
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                System.out.println(e.getResponseBodyAsString());
            }
        }
        return user;
    }

    /**
     * Method to add a User to the data base.
     * @param restTemplate restTemplate
     * @param url url of request
     * @param user user
     */

    public String addUser(final RestTemplate restTemplate,
                        final String url, final Users user) {
        String returnString = "";
        try {
            Users returns = restTemplate.postForObject(url, user, Users.class);
            if (returns != null) {
                returnString = "Registration complete";
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                returnString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return returnString;
    }

    /**
     * Method to get all of a users' friends.
     * @param restTemplate restTemplate object
     * @param url url of the request
     * @param userId userId
     */

    public List<FriendsUserResp> getUserFriends(
            final RestTemplate restTemplate, final String url, final Long userId) {

       List<FriendsUserResp> friendsList = new ArrayList<>();
        try {
            ResponseEntity<FriendsUserResp[]> responseEntity =
                    restTemplate.getForEntity(url + "/" + userId, FriendsUserResp[].class);

            if (responseEntity.getBody() != null) {
                FriendsUserResp[] list = responseEntity.getBody();
                for (FriendsUserResp u : list) {
                    friendsList.add(u);
                }
            }
        } catch(HttpStatusCodeException e) {
            System.out.println(e);
        }
        return friendsList;
    }

    /**
     * Method that checks the credentials of a user.
     * @param restTemplate restTemplate to use.
     * @param url Url of the request.
     * @param authenticateUser authenticateUser object.
     * @return the token of the authenticated user.
     */

    public String authUser(
            final RestTemplate restTemplate, final String url,
            final AuthenticateUser authenticateUser) {
        String token = "";
        try {
            AuthenticateUser authenticateUser1 =
                    restTemplate.postForObject(url, authenticateUser, AuthenticateUser.class);
            if (authenticateUser1 != null) {
                token = authenticateUser1.getToken();
                //System.out.println("The token is + " + authenticateUser1.getToken());
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
               token = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return token;
    }

    private String outputErrorMessage(ObjectMapper objectMapper, String responseString)
    {
        String returnString = "";
        try {
            ErrorDetails errorDetails = objectMapper.readValue(responseString, ErrorDetails.class);
            returnString = errorDetails.getMessage();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
        return  returnString;
    }

}
