package client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import server.exception.CustomException;
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

    public void getUser(RestTemplate restTemplate, String URL, Long id) throws CustomException {
        URL += "/" + id.toString();

        try{
            Users user = restTemplate.getForObject(URL, Users.class);
            System.out.println(user.toString());
        }
        catch(HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {

                System.out.println(e.getResponseBodyAsString());
            }
        }
    }

    public void addUser(RestTemplate restTemplate, String URL, String username)
    {
        String pattern = "dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        try{
            Date dob = dateFormat.parse("20-12-1999");
            Users user = new Users(null, username, "123", "TestName", "LastName", "RO", "123@gmail.com", dob);

            try{
                Users returns = restTemplate.postForObject(URL, user, Users.class);
                System.out.println(returns.toString());
            }
            catch(HttpStatusCodeException e)
            {
                if(e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
                {
                    String responseString = e.getResponseBodyAsString();
                    System.out.println(responseString);

                    // Use ObjectMapper here to create object of error.
                }
            }

        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
    }

    public void getUserFriends(RestTemplate restTemplate, String URL, Long userId)
    {
        ResponseEntity<FriendsUserResp[]> responseEntity = restTemplate.getForEntity(URL + "/" + userId, FriendsUserResp[].class);

        List<FriendsUserResp> list = Arrays.asList(responseEntity.getBody());

        for(FriendsUserResp u : list)
        {
            System.out.println(u.toString());
        }
    }

}
