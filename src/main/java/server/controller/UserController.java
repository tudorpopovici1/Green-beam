package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.exception.BadCredentialsException;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;

import server.model.Achievements;
import server.model.AchievementsType;
import server.model.EmissionFriend;
import server.model.Emissions;
import server.model.EmissionsClient;
import server.model.Friends;
import server.model.FriendsUserResp;
import server.model.JwtUser;
import server.model.Users;
import server.repository.AchievementRepository;
import server.repository.EmissionRepository;
import server.repository.FriendsRepository;
import server.repository.UserRepository;
import server.security.JwtValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmissionRepository emissionRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    private JwtValidator jwtValidator = new JwtValidator();

    // Returns all the users in the database.
    @GetMapping("/user/all")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    /**
     * API path to register a user.
     * @param user user info
     * @return new user object instance
     * @throws UserAlreadyRegistered exception thrown in case user already registered.
     */

    @PostMapping(value = "/save/user")
    public Users saveUser(@RequestBody Users user) throws UserAlreadyRegistered {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyRegistered(
                    "Username: " + user.getUsername()
                            + " is already in use..");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyRegistered("Email is in use...");
        }

        BCryptPasswordEncoder encryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(encryptPasswordEncoder.encode(user.getPassword()));

        Users users = userRepository.save(user);

        Achievements achievements = new Achievements(user.getId(), 6L);
        achievementRepository.save(achievements);

        Friends friends = new Friends(user.getId(),
                user.getId(), "1");
        friendsRepository.save(friends);

        Emissions emissions = new Emissions(users.getId(), "1", 0, null);
        emissionRepository.save(emissions);
        return users;
    }

    /**
     * Retrieves a list of all users matching the given username.
     * @param username username to search for.
     * @return the matching users.
     */

    @GetMapping(value = "/search/{username}")
    public List<FriendsUserResp> searchFriends(@PathVariable("username") String username) {
        List<FriendsUserResp> searchedFriends = userRepository.queryFriends(username);
        return searchedFriends;
    }

    @GetMapping("/user/get/{username}")
    public Long getUsername(@PathVariable("username") String username) {
        Users user = userRepository.findByUsername(username);
        return user.getId();
    }

    @GetMapping("/user/get/username/{id}")
    public String getUserUsername(@PathVariable("id") Long id) {
        return userRepository.findUserUsername(id);
    }

    /**
     * Returns the info of a specific user.
     * @param request request object instance
     * @param id id of the user
     * @return New FriendsUserResp object instance.
     * @throws ResourceNotFoundException exception
     * @throws BadCredentialsException exception.
     */

    @GetMapping(value = "/user/{id}")
    public FriendsUserResp getUser(HttpServletRequest request,
                                   @PathVariable("id") Long id)
            throws ResourceNotFoundException,
            BadCredentialsException {

        if (isIncorrectUser(request, id)) {
            throw new BadCredentialsException("Nice try!");
        }

        if (userRepository.findUserById(id) == null) {
            throw new ResourceNotFoundException("The user is not available");
        }

        return userRepository.findSpecificUserById(id);
    }

    /**
     * Return a list of all the friends of user with id given as parameter.
     * @param request request object instance.
     * @param id id of the user.
     * @return all friends of a user.
     * @throws BadCredentialsException exception.
     * @throws ResourceNotFoundException exception.
     */

    @GetMapping("/user/allfriends/{id}")
    public List<FriendsUserResp> getFriendsUser(
            HttpServletRequest request, @PathVariable("id") Long id)
            throws BadCredentialsException, ResourceNotFoundException {

        if (isIncorrectUser(request, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        if (userRepository.findUserById(id) == null) {
            throw new ResourceNotFoundException("The user is not available");
        }

        return userRepository.findAllFriendsUser(id);
    }

    /**
     * Adding an emissions of type vegeterian meal / local produce.
     * @param httpServletRequest request obj
     * @param id id of the user
     * @param emissionsClient emissionClient object instance
     * @return String representing the result
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/add/emission/vegMeal/{id}")
    public String addEmissions(HttpServletRequest httpServletRequest,
                                @PathVariable("id") Long id,
                                @RequestBody EmissionsClient emissionsClient)
                                throws BadCredentialsException {
        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }
        Users user = userRepository.findUserById(id);
        Emissions emissions = new Emissions(id, emissionsClient.getEmissionType(),
                emissionsClient.getCarbonEmission(), emissionsClient.getDate());
        emissionRepository.save(emissions);

        int numberVegMeals1 = emissionRepository.getNumberTimesVegMeal(id);
        if (achievementRepository.getNumberOfSpecificAchievement(1L, id) == 0
                && numberVegMeals1 >= 3) {
            Achievements achievements = new Achievements(id, 1L);
            achievementRepository.save(achievements);
        }
        if (achievementRepository.getNumberOfSpecificAchievement(2L, id) == 0
                && numberVegMeals1 >= 7) {
            Achievements achievements = new Achievements(id, 2L);
            achievementRepository.save(achievements);
        }
        if (achievementRepository.getNumberOfSpecificAchievement(3L, id) == 0
                && numberVegMeals1 >= 30) {
            Achievements achievements = new Achievements(id, 3L);
            achievementRepository.save(achievements);
        }

        int numberLocalProducts = emissionRepository.getNumberLocalProducts(id);
        if (achievementRepository.getNumberOfSpecificAchievement(8L, id) == 0
                && numberLocalProducts >= 10) {
            Achievements achievements = new Achievements(id, 8L);
            achievementRepository.save(achievements);
        }

        int numberSolarPanels = emissionRepository.getSolarPanelsInstalled(id);
        if (achievementRepository.getNumberOfSpecificAchievement(9L, id) == 0
                && numberSolarPanels >= 1) {
            Achievements achievements = new Achievements(id, 9L);
            achievementRepository.save(achievements);
        }

        return "Saved";
    }

    /**
     * Add emissions of a user of type transportation.
     * @param httpServletRequest request object
     * @param id user id.
     * @param emissionsClient emissionClient
     * @return new String
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/add/emission/transportation/{id}")
    public String addEmissionsBike(HttpServletRequest httpServletRequest,
                               @PathVariable("id") Long id,
                               @RequestBody EmissionsClient emissionsClient)
            throws BadCredentialsException {

        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        Users user = userRepository.findUserById(id);
        Emissions emissions = new Emissions(id, emissionsClient.getEmissionType(),
                emissionsClient.getCarbonEmission(), emissionsClient.getDate());
        emissionRepository.save(emissions);

        int numberBike = emissionRepository.getNumberTransportationInsteadCar(id);
        if (achievementRepository.getNumberOfSpecificAchievement(4L, id) == 0
                && numberBike >= 10) {
            Achievements achievements = new Achievements(id, 4L);
            achievementRepository.save(achievements);
        }

        int numberTransportation = emissionRepository.getNumberTransportationInsteadCar(id);
        if (achievementRepository.getNumberOfSpecificAchievement(5L, id) == 0
                && numberTransportation >= 30) {
            Achievements achievements = new Achievements(id, 5L);
            achievementRepository.save(achievements);
        }
        return "Saved";
    }

    /**
     * Get achievements of a user.
     * @param httpServletRequest request object.
     * @param id user id
     * @return new list of achievements types.
     * @throws BadCredentialsException exception
     */

    @GetMapping("user/get/achievements/{id}")
    public List<AchievementsType> getAchievementsUser(HttpServletRequest httpServletRequest,
                                                      @PathVariable("id") Long id)
            throws BadCredentialsException {
        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }
        return achievementRepository.getAllAchievementsTypeOfUser(id);
    }

    /**
     * Get all friend requests sent.
     * @param httpServletRequest request object
     * @param id user id
     * @return new List of friends
     * @throws BadCredentialsException exception
     */

    @GetMapping("/user/get/friend/request/sent/{id}")
    public List<Friends> friendRequestSend(HttpServletRequest httpServletRequest,
                               @PathVariable("id") Long id)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        return friendsRepository.getFriendRequestSend(id);
    }

    /**
     * Path to add a friend.
     * @param id user id
     * @param relatingUserId other user id.
     * @param httpServletRequest request object
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/add/friend/{id}")
    public String addFriend(
            @PathVariable("id") Long id,
            @RequestBody Long relatingUserId,
            HttpServletRequest httpServletRequest) throws BadCredentialsException {

        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        Friends friendTo = new Friends(id, relatingUserId, "3");
        Friends friendsFrom = new Friends(relatingUserId, id, "2");

        friendsRepository.save(friendsFrom);
        friendsRepository.save(friendTo);

        int numberFriends = userRepository.findAllFriendsUser(id).size();
        if (achievementRepository.getNumberOfSpecificAchievement(6L, id) == 0
                && numberFriends >=3) {
            Achievements achievements = new Achievements(id, 6L);
            achievementRepository.save(achievements);
        }

        return "Saved";
    }

    /**
     * Path to accept a friend.
     * @param id id of user
     * @param relatingUserId id of other user
     * @param httpServletRequest request object
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/accept/friend/{id}")
    public String acceptFriend(
            @PathVariable("id") Long id,
            @RequestBody Long relatingUserId,
            HttpServletRequest httpServletRequest) throws BadCredentialsException {

        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        friendsRepository.updateRelationshipType("1", id, relatingUserId);
        friendsRepository.updateRelationshipType("1", relatingUserId, id);
        return "Saved";
    }

    /**
     * Reject a friendship path.
     * @param id user id
     * @param relatingUserId other user id
     * @param httpServletRequest request
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/reject/friend/{id}")
    public String rejectFriend(
            @PathVariable("id") Long id,
            @RequestBody Long relatingUserId,
            HttpServletRequest httpServletRequest) throws BadCredentialsException {

        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        friendsRepository.deleteFriend(relatingUserId, id);
        friendsRepository.deleteFriend(id, relatingUserId);
        return "Deleted";
    }

    /**
     * Get friend requests received.
     * @param httpServletRequest request object
     * @param id user id
     * @return new list of friends
     * @throws BadCredentialsException exception
     */

    @GetMapping("/user/get/friend/request/received/{id}")
    public List<Friends> friendRequestRecieved(HttpServletRequest httpServletRequest,
                                           @PathVariable("id") Long id)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, id)) {
            throw new BadCredentialsException("Bad credentials");
        }

        return friendsRepository.getFriendRequestRecieved(id);
    }

    /**
     * Change the country of a user.
     * @param country country
     * @param userId user id
     * @param httpServletRequest request object
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/change/country/{id}")
    public String changeCountry(@RequestBody String country,
                                @PathVariable("id") Long userId,
                                HttpServletRequest httpServletRequest)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }

        userRepository.updateCountryUser(country, userId);
        response = "Changed";
        return response;
    }

    /**
     * Change name of a user.
     * @param name name
     * @param userId user id.
     * @param httpServletRequest req obj
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/change/name/{id}")
    public String changeName(@RequestBody String name,
                                @PathVariable("id") Long userId,
                                HttpServletRequest httpServletRequest)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }

        userRepository.updateNameUser(name, userId);
        response = "Changed";
        return response;
    }

    /**
     * Change dob of a user.
     * @param dateOfBirth name
     * @param userId user id.
     * @param httpServletRequest req obj
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/change/dateOfBirth/{id}")
    public String changeDateOfBirth(@RequestBody Date dateOfBirth,
                             @PathVariable("id") Long userId,
                             HttpServletRequest httpServletRequest) throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }

        userRepository.updateDateOfBirthUser(dateOfBirth, userId);
        response = "Changed";
        return response;
    }

    /**
     * Change email of a user.
     * @param email email
     * @param userId user id
     * @param httpServletRequest req object
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/change/email/{id}")
    public String changeEmail(@RequestBody String email,
                                    @PathVariable("id") Long userId,
                                    HttpServletRequest httpServletRequest)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }

        userRepository.updateEmailUser(email, userId);
        response = "Changed";
        return response;
    }

    /**
     * Change password of a user.
     * @param password password
     * @param userId user id
     * @param httpServletRequest req object
     * @return new string
     * @throws BadCredentialsException exception
     */

    @PostMapping("/user/change/password/{id}")
    public String changePassword(@RequestBody String password,
                                    @PathVariable("id") Long userId,
                                    HttpServletRequest httpServletRequest)
            throws BadCredentialsException {
        String response = "";
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }
        BCryptPasswordEncoder bcryptPasswordEncoder = new
                BCryptPasswordEncoder();
        String encryptedPasswd = bcryptPasswordEncoder
                .encode(password);
        userRepository.updatePasswordUser(encryptedPasswd, userId);
        response = "Changed";
        return response;
    }

    /**
     * Get emissions of all friends of a user.
     * @param httpServletRequest request object
     * @param userId user id
     * @return new list of emissionfriend objects
     * @throws BadCredentialsException exception
     */

    @GetMapping("/user/get/friends/emission/{id}")
    public List<EmissionFriend> getAllFriendsTotalEmissions(HttpServletRequest httpServletRequest,
                                                        @PathVariable("id")
                                                        Long userId)
            throws BadCredentialsException {
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }
        List<FriendsUserResp> top = userRepository.findAllFriendsUser(userId);

        List<EmissionFriend> listTop = new ArrayList<>();

        for (FriendsUserResp f : top) {

            Double response = emissionRepository.getAllEmisionsOfUser(f.getUsername());
            if (response != null) {
                EmissionFriend emiss = new EmissionFriend(f.getUsername(), response);
                listTop.add(emiss);
            }
        }
        return listTop;
    }

    /**
     * Get top 5 friends in terms of emissions.
     * @param httpServletRequest req object
     * @param userId user id
     * @return new emissionFriend list.
     * @throws BadCredentialsException exception
     */

    @GetMapping("/user/get/top/friends/emission/{id}")
    public List<EmissionFriend> getTop5FriendsEmissions(HttpServletRequest httpServletRequest,
                                                         @PathVariable("id")
                                                                 Long userId)
            throws BadCredentialsException {


        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }
        List<EmissionFriend> allFriendsEmissions =
                getAllFriendsTotalEmissions(httpServletRequest, userId);
        Collections.sort(allFriendsEmissions, (o1, o2) -> {
            int result = (int) (o1.getCarbonEmission() - o2.getCarbonEmission());
            return result;
        });
        Collections.reverse(allFriendsEmissions);

        List<EmissionFriend> toReturn = new ArrayList<>();

        if (allFriendsEmissions.size() > 4) {
            for (int i = 0; i < 5; i++) {
                toReturn.add(allFriendsEmissions.get(i));
            }
        } else {
            toReturn = allFriendsEmissions;
        }
        return toReturn;
    }

    /**
     * Get all emissions of a user.
     * @param httpServletRequest req object
     * @param userId user id
     * @return new emissionfriend
     * @throws BadCredentialsException exception
     */

    @GetMapping("/user/get/all/emissions/{id}")
    public EmissionFriend getEmissionsOfUser(HttpServletRequest httpServletRequest,
                                              @PathVariable("id") Long userId)
            throws BadCredentialsException {
        if (isIncorrectUser(httpServletRequest, userId)) {
            throw new BadCredentialsException("Bad credentials");
        }
        String username = userRepository.findUserUsername(userId);
        Double result = emissionRepository.getAllEmisionsOfUser(username);

        if (result != null) {
            EmissionFriend returnEmi = new EmissionFriend(username, result);
            return returnEmi;
        }
        return null;
    }

    private boolean isIncorrectUser(HttpServletRequest request, Long id) {
        String token = request.getHeader("Authorisation").substring(6);
        JwtUser jwtUser = jwtValidator.validate(token);

        if (jwtUser == null) {
            return true;
        }

        return id != jwtUser.getId();
    }

}
