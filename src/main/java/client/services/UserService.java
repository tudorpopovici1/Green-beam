package client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Label;
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

/**
 * Class that represents UserService.
 */
@Service
public class UserService {

    /**
     *  Gets a specific users' details.
     * @param restTemplate restTemplate instantation to use.
     * @param url Url of the request.
     * @param id id of the user.
     * @return a new User object.
     */

    private ObjectMapper objectMapper = new ObjectMapper();

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
     * @param errorLabel label to output the errors
     */

    public void addUser(final RestTemplate restTemplate,
                        final String url, final Users user, final Label errorLabel) {

        try {
            Users returns = restTemplate.postForObject(url, user, Users.class);
            if (returns != null) {
                System.out.println(returns.toString());
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                outputErrorMessage(objectMapper, e.getResponseBodyAsString(), errorLabel);
            }
        }
    }

    /**
     * Method to get all of a users' friends.
     * @param restTemplate restTemplate object
     * @param url url of the request
     * @param userId userId
     */

    public void getUserFriends(
            final RestTemplate restTemplate, final String url, final Long userId) {
        ResponseEntity<FriendsUserResp[]> responseEntity =
                restTemplate.getForEntity(url + "/" + userId, FriendsUserResp[].class);

        if (responseEntity.getBody() != null) {

            FriendsUserResp[] list = responseEntity.getBody();

            for (FriendsUserResp u : list) {
                System.out.println(u.toString());
            }
        }
    }

    /**
     * Method that checks the credentials of a user.
     * @param restTemplate restTemplate to use.
     * @param url Url of the request.
     * @param authenticateUser authenticateUser object.
     * @param errorLabel label where to output the errors.
     * @return the token of the authenticated user.
     */

    public String authUser(
            final RestTemplate restTemplate, final String url,
            final AuthenticateUser authenticateUser, final Label errorLabel) {

        String token = "";
        try {
            AuthenticateUser authenticateUser1 =
                    restTemplate.postForObject(url, authenticateUser, AuthenticateUser.class);

            if (authenticateUser1 != null) {
                token = authenticateUser1.getToken();
                System.out.println("The token is + " + authenticateUser1.getToken());
                errorLabel.setText("You have successfully logged in !");
            }
        } catch (HttpStatusCodeException e) {

            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
               outputErrorMessage(objectMapper, e.getResponseBodyAsString(), errorLabel);
            }
        }
        return token;
    }

    private void outputErrorMessage(ObjectMapper objectMapper, String responseString, Label errorLabel)
    {
        try {
            ErrorDetails errorDetails = objectMapper.readValue(responseString, ErrorDetails.class);
            errorLabel.setText(errorDetails.getMessage());
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

}
