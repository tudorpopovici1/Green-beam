package client.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import server.model.AuthenticateUser;
import server.model.FriendsUserResp;
import server.model.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    public Users getUser(final RestTemplate restTemplate, String URL, final Long id) {

        URL += "/" + id.toString();

        Users user = null;

        try{
            user = restTemplate.getForObject(URL, Users.class);
            System.out.println(user.toString());
        }
        catch(HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {

                System.out.println(e.getResponseBodyAsString());
            }
        }

        return user;
    }

    public void addUser(final RestTemplate restTemplate, final String URL, final Users user)
    {

        try{
            Users returns = restTemplate.postForObject(URL, user, Users.class);
            System.out.println(returns.toString());
        }
        catch(HttpStatusCodeException e)
        {
            if(e.getStatusCode() == HttpStatus.BAD_REQUEST)
            {
                String responseString = e.getResponseBodyAsString();
                System.out.println(responseString);

                // Use ObjectMapper here to create object of error.
            }
        }
    }

    public void getUserFriends(final RestTemplate restTemplate, final String URL, final Long userId)
    {
        ResponseEntity<FriendsUserResp[]> responseEntity = restTemplate.getForEntity(URL + "/" + userId, FriendsUserResp[].class);

        List<FriendsUserResp> list = Arrays.asList(responseEntity.getBody());

        for(FriendsUserResp u : list)
        {
            System.out.println(u.toString());
        }
    }

    public void authUser(final RestTemplate restTemplate, final String URL, final AuthenticateUser authenticateUser)
    {
        try{
            AuthenticateUser authenticateUser1 = restTemplate.postForObject(URL, authenticateUser, AuthenticateUser.class);

            System.out.println("User logged in!");
        }
        catch(HttpStatusCodeException e)
        {
            if(e.getStatusCode() == HttpStatus.FORBIDDEN)
            {
                System.out.println(e.getResponseBodyAsString());
            }
        }
    }

}
