package client.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import server.model.*;

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

    public String addFriend(final RestTemplate restTemplate, final String url,
                            final Long relatedUserId, final Long relatingUserId, final String token) {
        String returnString = "";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Long> entity = new HttpEntity<>(relatingUserId, httpHeaders);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url + "/" + relatedUserId, HttpMethod.POST, entity, String.class);
            returnString = response.getBody();
        }
        catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                returnString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return returnString;
    }

    public List<Friends> getFriendRequest(
            final RestTemplate restTemplate, final String url, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);


        List<Friends> friendsList = new ArrayList<>();
        try {
            ResponseEntity<Friends[]> response = restTemplate.exchange(url + "/" + id, HttpMethod.GET, entity, Friends[].class);

            if(response.getBody() != null) {
                Friends[] list = response.getBody();
                for (Friends f : list) {
                    friendsList.add(f);
                }
            }
        } catch (HttpStatusCodeException e) {

        }
        return friendsList;
    }

    public String accepting(
            final RestTemplate restTemplate, final String url, final Long relatingUserId, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(relatingUserId, httpHeaders);

        String responseString = "";
        try {
            ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.POST, entity, String.class);

            if(response.getBody() != null) {
                responseString = "Accepted";
            }
        } catch (HttpStatusCodeException e) {
            if(e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    public String rejecting(
            final RestTemplate restTemplate, final String url, final Long relatingUserId, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(relatingUserId, httpHeaders);

        String responseString = "";
        try {
            ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.POST, entity, String.class);

            if(response.getBody() != null) {
                responseString = "Rejected";
            }
        } catch (HttpStatusCodeException e) {
            if(e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    public String updates(
            final RestTemplate restTemplate, final String argument, final String url, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(argument, httpHeaders);

        String responseString ="";
        try {
            ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.POST, entity, String.class);

            if(response.getBody() != null) {
                responseString = response.getBody();
            }
        } catch (HttpStatusCodeException e) {
            if(e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    public List<AchievementsType> getAchievementsOfUser(
            final RestTemplate restTemplate, final String url, final Long userId, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);

        List<AchievementsType> achievementsTypesList = new ArrayList<>();
        try {
            ResponseEntity<AchievementsType[]> responseEntity =
                    restTemplate.exchange(url + "/" + userId, HttpMethod.GET,
                            entity, AchievementsType[].class);

            if (responseEntity.getBody() != null) {
                AchievementsType[] list = responseEntity.getBody();
                for (AchievementsType u : list) {
                    achievementsTypesList.add(u);
                }
            }
        } catch (HttpStatusCodeException e) {

        }
        return achievementsTypesList;
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
        } catch (HttpStatusCodeException e) {
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
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                token = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return token;
    }

    /**
     * Adds emission of a user.
     * @param restTemplate restTemplate
     * @param url url
     * @param userId user Id.
     * @param emissionsClient emission Client.
     * @param token token of user.
     * @return string representing the result.
     */

    public String addEmissionOfUser(final RestTemplate restTemplate, final String url,
                                    final Long userId, final EmissionsClient emissionsClient,
                                    final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmissionsClient> entity = new HttpEntity<>(emissionsClient, httpHeaders);

        String response = "";
        try {
            ResponseEntity<String> responseString = restTemplate.exchange(
                    url + "/" + userId, HttpMethod.POST,
                    entity, String.class);
            response = responseString.getBody();
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                response = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return response;
    }

    public EmissionFriend getEmissionsOfUser(final RestTemplate restTemplate, final String url,
                                             final Long userId, final String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmissionsClient> entity = new HttpEntity<>(httpHeaders);

        EmissionFriend emissionFriend;

        try {
            ResponseEntity<EmissionFriend> responseString = restTemplate.exchange(
                    url + "/" + userId, HttpMethod.GET,
                    entity, EmissionFriend.class);
            emissionFriend = responseString.getBody();
            return emissionFriend;
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                //emissionFriend = null;
                //response = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return null;
    }

    private String outputErrorMessage(ObjectMapper objectMapper, String responseString) {
        String returnString = "";
        try {
            ErrorDetails errorDetails = objectMapper.readValue(responseString, ErrorDetails.class);
            returnString = errorDetails.getMessage();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return  returnString;
    }

}
