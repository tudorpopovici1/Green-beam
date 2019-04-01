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
import server.model.AchievementsType;
import server.model.AuthenticateUser;
import server.model.EmissionFriend;
import server.model.EmissionsClient;
import server.model.ErrorDetails;
import server.model.Friends;
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
     * Searches a user friends.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param username user's username
     * @return new list of friendsuserresp.
     */
    public List<FriendsUserResp> searchFriends(final RestTemplate restTemplate, final String url,
                                               final String username) {

        List<FriendsUserResp> list = new ArrayList<>();
        try {
            ResponseEntity<FriendsUserResp[]> responseEntity
                    = restTemplate.exchange(url + "/" + username,
                    HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), FriendsUserResp[].class);
            if (responseEntity.getBody() != null) {
                for (FriendsUserResp f : responseEntity.getBody()) {
                    list.add(f);
                }
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Gets the username of the user's friend.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param username user's username
     * @param token userToken
     * @return new user id
     */
    public Long getUsername(final RestTemplate restTemplate, final String url,
                              final String username, final String token) {
        Long userId = -1L;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Long> entity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<Long> responseEntity =
                    restTemplate.exchange(url + "/" + username, HttpMethod.GET, entity,
                    Long.class);
            if (responseEntity.getBody() != null) {
                userId = responseEntity.getBody();
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
        }
        return userId;
    }

    /**
     * Gets the username of the user.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param id user's id
     * @param token userToken
     * @return new username
     */
    public String getUserUsername(final RestTemplate restTemplate, final String url,
                            final Long id, final String token) {
        String usernameRet = "";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Long> entity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(url + "/" + id, HttpMethod.GET, entity,
                    String.class);
            if (responseEntity.getBody() != null) {
                usernameRet = responseEntity.getBody();
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
        }
        return usernameRet;
    }

    /**
     * Adds a friend to the user's database.
     * @param restTemplate restTempemplate Object
     * @param url server url
     * @param relatedUserId user id
     * @param relatingUserId friend's user id
     * @param token user token
     * @return new string
     */
    public String addFriend(final RestTemplate restTemplate, final String url,
                            final Long relatedUserId, final Long relatingUserId,
                            final String token) {
        String returnString = "";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Long> entity = new HttpEntity<>(relatingUserId, httpHeaders);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    url + "/" + relatedUserId, HttpMethod.POST, entity, String.class);
            returnString = response.getBody();
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                returnString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return returnString;
    }

    /**
     * Getting a friend request from another user.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param id user id
     * @param token user token
     * @return new list of friends
     */
    public List<Friends> getFriendRequest(
            final RestTemplate restTemplate, final String url, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(httpHeaders);


        List<Friends> friendsList = new ArrayList<>();
        try {
            ResponseEntity<Friends[]> response
                    = restTemplate.exchange(url + "/" + id,
                    HttpMethod.GET, entity, Friends[].class);

            if (response.getBody() != null) {
                Friends[] list = response.getBody();
                for (Friends f : list) {
                    friendsList.add(f);
                }
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
        }
        return friendsList;
    }

    /**
     * Accepting a friend request.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param relatingUserId friend user id
     * @param id user id
     * @param token user token
     * @return new string
     */
    public String accepting(
            final RestTemplate restTemplate, final String url,
            final Long relatingUserId, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(relatingUserId, httpHeaders);

        String responseString = "";
        try {
            ResponseEntity<String> response
                    = restTemplate.exchange(url + "/" + id, HttpMethod.POST,
                    entity, String.class);

            if (response.getBody() != null) {
                responseString = "Accepted";
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    /**
     * Rejecting a friend request.
     * @param restTemplate restTemplate Object
     * @param url server url
     * @param relatingUserId friends user id
     * @param id user id
     * @param token user token
     * @return new string
     */
    public String rejecting(
            final RestTemplate restTemplate, final String url,
            final Long relatingUserId, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(relatingUserId, httpHeaders);

        String responseString = "";
        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url + "/" + id, HttpMethod.POST, entity, String.class);

            if (response.getBody() != null) {
                responseString = "Rejected";
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    /**
     * Updates.
     * @param restTemplate restTemplate object
     * @param argument argument
     * @param url server url
     * @param id user id
     * @param token user token
     * @return new string
     */
    public String updates(
            final RestTemplate restTemplate, final String argument,
            final String url, final Long id, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(argument, httpHeaders);

        String responseString = "";
        try {
            ResponseEntity<String> response =
                    restTemplate.exchange(url + "/" + id, HttpMethod.POST, entity, String.class);

            if (response.getBody() != null) {
                responseString = response.getBody();
            }
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.FORBIDDEN) {
                responseString = outputErrorMessage(objectMapper, e.getResponseBodyAsString());
            }
        }
        return responseString;
    }

    /**
     * Get the achievements of the user.
     * @param restTemplate restTemplate object
     * @param url server url
     * @param userId user id
     * @param token user token
     * @return new list of achievement types
     */
    public List<AchievementsType> getAchievementsOfUser(
            final RestTemplate restTemplate, final String url,
            final Long userId, final String token) {

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
            e.printStackTrace();
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
            final RestTemplate restTemplate, final String url,
            final Long userId, final String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmissionsClient> entity = new HttpEntity<>(httpHeaders);

        List<FriendsUserResp> friendsList = new ArrayList<>();
        try {
            ResponseEntity<FriendsUserResp[]> responseEntity =
                    restTemplate.exchange(
                            url + "/" + userId, HttpMethod.GET, entity, FriendsUserResp[].class);

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

    /**
     * Gets the emission of the user.
     * @param restTemplate restTemplate Object
     * @param url server url
     * @param userId user id
     * @param token user token
     * @return new emissionfriend object
     */
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


    /**
     * Gets the emission of the friends user.
     * @param restTemplate restTemplate Object
     * @param url server url
     * @param token user token
     * @param userId user id
     * @return new list of emissionfriend objects
     */
    public List<EmissionFriend> getEmissionsOfFriends(final RestTemplate restTemplate,
                                                      final String url, final String token,
                                                      Long userId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorisation", "Token " + token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EmissionsClient> entity = new HttpEntity<>(httpHeaders);

        List<EmissionFriend> toReturn = new ArrayList<>();

        try {
            ResponseEntity<EmissionFriend[]> responseEntity = restTemplate
                    .exchange(url + "/" + userId, HttpMethod.GET, entity, EmissionFriend[].class);
            if (responseEntity.getBody() != null) {
                for (EmissionFriend e : responseEntity.getBody()) {
                    toReturn.add(e);
                }
            }
        } catch (HttpStatusCodeException e) {
            System.out.println(e);
        }

        return toReturn;
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
