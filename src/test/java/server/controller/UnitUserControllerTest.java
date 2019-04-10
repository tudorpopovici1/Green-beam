package server.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import server.exception.BadCredentialsException;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.*;
import server.repository.AchievementRepository;
import server.repository.EmissionRepository;
import server.repository.FriendsRepository;
import server.repository.UserRepository;
import server.security.JwtGenerator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UnitUserControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private FriendsRepository friendsRepository;

    @Mock
    private AchievementRepository achievementRepository;

    @Mock
    private EmissionRepository emissionRepository;

    private static Users user1;
    private static Users user2;
    private static Users user3;
    private static Users user4;

    private static FriendsUserResp userResp1;
    private static FriendsUserResp userResp2;

    private static Friends friends1;
    private static Friends friends2;

    @Before
    public void setUp() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
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

            userResp1 = new FriendsUserResp("userno1", dob, "firstName", "lastName",
                    "country", "userno1@email.com");
            userResp2 = new FriendsUserResp("userno5", dob, "firstName", "lastName",
                    "country", "userno5@email.com");

            friends1 = new Friends(1L, 2L, null);
            friends2 = new Friends(1L, 3L, null);

        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = UserAlreadyRegistered.class)
    public void UsernameAlreadyInUseException() throws UserAlreadyRegistered {
        when(userRepository.findByUsername(user1.getUsername())).thenReturn(user1);
        userController.saveUser(user1);
    }

    @Test (expected = UserAlreadyRegistered.class)
    public void EmailAlreadyInUseRegistration() throws UserAlreadyRegistered {
        when(userRepository.findByEmail(
                user1.getEmail())).thenReturn(user1);
        when(userRepository.findByUsername(user1.getUsername())).thenReturn(user1);
        userController.saveUser(user1);
    }

    @Test
    public void successfulRegistration() throws UserAlreadyRegistered {
        when(userRepository
                .findByUsername(user2.getUsername())).thenReturn(null);
        when(userRepository
                .findByEmail(user2.getEmail())).thenReturn(null);
        when(userRepository.save(user2)).thenReturn(user2);
        Users response = userController.saveUser(user2);
        Assert.assertEquals(user2, response);
    }

    @Test
    public void getAllUsersTest() {
        List<Users> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        when(userRepository.findAll()).thenReturn(list);
        List<Users> responseList = userController.getUsers();
        Assert.assertEquals(list, responseList);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void NoSuchUserTest() throws ResourceNotFoundException, BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserById(1L)).thenReturn(null);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        FriendsUserResp response = userController.getUser(httpServletRequest, 1L);
        Assert.assertEquals(userResp1, response);
    }

    @Test (expected = BadCredentialsException.class)
    public void WrongTokenSpecified() throws ResourceNotFoundException, BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), "user",
                15L));
        when(userRepository.findUserById(1L)).thenReturn(user1);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        FriendsUserResp response = userController.getUser(httpServletRequest, 1L);
        Assert.assertEquals(userResp1, response);
    }

    @Test
    public void CorrectGetUser() throws ResourceNotFoundException, BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserById(1L)).thenReturn(user1);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        FriendsUserResp response = userController.getUser(httpServletRequest, 1L);
        Assert.assertEquals(userResp1, response);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void NoSuchUserTestGetFriends() throws ResourceNotFoundException, BadCredentialsException {
        List<FriendsUserResp> newList = new ArrayList<>();
        newList.add(userResp2);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        when(userRepository.findUserById(1L)).thenReturn(null);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        when(userRepository.findAllFriendsUser(1L)).thenReturn(newList);

        List<FriendsUserResp> response = userController.getFriendsUser(httpServletRequest, 1L);
        Assert.assertEquals(newList, response);
    }

    @Test (expected = BadCredentialsException.class)
    public void WrongTokenSpecifiedGetFriends() throws ResourceNotFoundException, BadCredentialsException {
        List<FriendsUserResp> newList = new ArrayList<>();
        newList.add(userResp2);

        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), "user",
                15L));

        when(userRepository.findUserById(1L)).thenReturn(user1);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        when(userRepository.findAllFriendsUser(1L)).thenReturn(newList);

        List<FriendsUserResp> response = userController.getFriendsUser(httpServletRequest, 1L);
        Assert.assertEquals(newList, response);
    }

    @Test
    public void CorrectGetFriendsUser() throws ResourceNotFoundException, BadCredentialsException {
        List<FriendsUserResp> expected = new ArrayList<>();
        expected.add(userResp2);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserById(1L)).thenReturn(user1);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        when(userRepository.findAllFriendsUser(1L)).thenReturn(expected);

        List<FriendsUserResp> response = userController.getFriendsUser(httpServletRequest, 1L);
        Assert.assertEquals(expected, response);
    }

    @Test (expected = BadCredentialsException.class)
    public void IncorrectUserMethodThrowsExceptionGetFriendsUser() throws ResourceNotFoundException, BadCredentialsException {
        List<FriendsUserResp> expected = new ArrayList<>();
        expected.add(userResp2);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        when(userRepository.findUserById(1L)).thenReturn(user1);
        when(userRepository.findSpecificUserById(1L)).thenReturn(userResp1);
        when(userRepository.findAllFriendsUser(1L)).thenReturn(expected);
        List<FriendsUserResp> response = userController.getFriendsUser(httpServletRequest, 1L);
    }

    /*@Test
    public void successfulAddEmission() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        Emissions emission = new Emissions(0L, "1",
                0.2F, date);
        EmissionsClient emissionsClient = new EmissionsClient("123",
                0.2F, date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserById(user1.getId())).thenReturn(user1);
        when(emissionRepository.save(emission)).thenReturn(emission);
        String response = userController.addEmissions(httpServletRequest, 1L, emissionsClient);
        Assert.assertEquals("Saved", response);
    }*/

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsAddEmission() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        Emissions emission = new Emissions(0L, "1",
                0.2F, date);
        EmissionsClient emissionsClient = new EmissionsClient("123",
                0.2F, date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.addEmissions(httpServletRequest, 1L, emissionsClient);
    }

    @Test (expected = BadCredentialsException.class)
    public void GetAllEmissionsOfUserBadCredentials() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.getEmissionsOfUser(httpServletRequest, 1L);
    }

    @Test
    public void resultIsNullGetEmissionsOfUser() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserUsername(user1.getId())).thenReturn(user1.getUsername());
        when(emissionRepository.getAllEmisionsOfUser(user1.getUsername())).thenReturn(null);
        EmissionFriend response = userController.getEmissionsOfUser(httpServletRequest,
                1L);
        Assert.assertEquals(null, response);
    }

    @Test
    public void successfulGetEmissionsOfUser() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findUserUsername(user1.getId())).thenReturn(user1.getUsername());
        Double expected = 0.2D;
        when(emissionRepository.getAllEmisionsOfUser(user1.getUsername())).thenReturn(expected);
        EmissionFriend result = userController.getEmissionsOfUser(httpServletRequest,
                1L);
        EmissionFriend emissionFriendExpected = new EmissionFriend(user1.getUsername(),
                expected);
        Assert.assertEquals(emissionFriendExpected, result);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsGetFriendsTotalEmissions() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.getAllFriendsTotalEmissions(httpServletRequest,
                1L);
    }

    @Test
    public void WillReturnNullGetAllEmissionsFriends() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(userRepository.findAllFriendsUser(user1.getId())).thenReturn(new ArrayList<>());
        List<EmissionFriend> expected = new ArrayList<>();
        List<EmissionFriend> result = userController.getAllFriendsTotalEmissions(
                httpServletRequest, 1L);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void HasNullElementsGetAllEmissionsFriends() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        List<FriendsUserResp> friendList = new ArrayList<>();
        friendList.add(userResp1);
        friendList.add(userResp2);

        when(userRepository.findAllFriendsUser(user1.getId())).thenReturn(friendList);
        when(emissionRepository.getAllEmisionsOfUser(userResp1.getUsername()))
                .thenReturn(1D);
        when(emissionRepository.getAllEmisionsOfUser(userResp2.getUsername()))
                .thenReturn(null);
        List<EmissionFriend> result = userController.getAllFriendsTotalEmissions(
                httpServletRequest, 1L);
        List<EmissionFriend> expected = new ArrayList<>();
        expected.add(new EmissionFriend("userno1", 1D));
        Assert.assertEquals(expected.get(0), result.get(0));
    }

    @Test
    public void successfulGetAllEmissionsFriends() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        List<FriendsUserResp> friendList = new ArrayList<>();
        friendList.add(userResp1);
        friendList.add(userResp2);

        when(userRepository.findAllFriendsUser(user1.getId())).thenReturn(friendList);
        when(emissionRepository.getAllEmisionsOfUser(userResp1.getUsername()))
                .thenReturn(1D);
        when(emissionRepository.getAllEmisionsOfUser(userResp2.getUsername()))
                .thenReturn(1D);
        List<EmissionFriend> result = userController.getAllFriendsTotalEmissions(
                httpServletRequest, 1L);
        List<EmissionFriend> expected = new ArrayList<>();
        expected.add(new EmissionFriend("userno1", 1D));
        expected.add(new EmissionFriend("userno5", 1D));
        Assert.assertEquals(expected.get(0), result.get(0));
        Assert.assertEquals(expected.get(1), result.get(1));
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsTop5Emissions() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.getTop5FriendsEmissions(httpServletRequest,
                1L);
    }

    /*@Test
    public void friendListLessOrEqualTo4TopEmissions() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        List<FriendsUserResp> friendList = new ArrayList<>();
        friendList.add(userResp1);
        friendList.add(userResp2);

        List<EmissionFriend> expected = new ArrayList<>();
        expected.add(new EmissionFriend("userno1", 1D));
        expected.add(new EmissionFriend("userno5", 1D));

        when(userRepository.findAllFriendsUser(user1.getId()))
                .thenReturn(friendList);

        when(emissionRepository.getAllEmisionsOfUser(userResp1.getUsername()))
                .thenReturn(0.1D);
        when(emissionRepository.getAllEmisionsOfUser(userResp2.getUsername()))
                .thenReturn(0.1D);

        when(userController.getAllFriendsTotalEmissions(httpServletRequest,
                user1.getId())).thenReturn(expected);

        List<EmissionFriend> result = userController
                .getTop5FriendsEmissions(httpServletRequest,
                        1L);

        Assert.assertEquals(expected.get(0).getUsername(), result.get(0).getUsername());
        Assert.assertTrue(expected.get(0).getCarbonEmission() ==
                result.get(0).getCarbonEmission());
        Assert.assertEquals(expected.get(1).getUsername(), result.get(1).getUsername());
        Assert.assertTrue(expected.get(1).getCarbonEmission() ==
                result.get(1).getCarbonEmission());
        *//*Assert.assertEquals(expected.get(3).getUsername(), result.get(3).getUsername());
        Assert.assertTrue(expected.get(3).getCarbonEmission() ==
                result.get(3).getCarbonEmission());
        Assert.assertEquals(expected.get(4).getUsername(), result.get(4).getUsername());
        Assert.assertTrue(expected.get(4).getCarbonEmission() ==
                result.get(4).getCarbonEmission());*//*
    }*/

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsEmissionBike() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.addEmissionsBike(httpServletRequest, user1.getId(),
                emissionsClient);
    }

    @Test
    public void successfulAddEmission10times() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(emissionRepository.getNumberTransportationInsteadCar(user1.getId()))
                .thenReturn(10);
        when(achievementRepository.getNumberOfSpecificAchievement(4L,
                user1.getId())).thenReturn(0);
        String response = userController.addEmissionsBike(httpServletRequest,
                user1.getId(), emissionsClient);
    }

    @Test
    public void sucessfulAddEmission10times2() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(emissionRepository.getNumberTransportationInsteadCar(user1.getId()))
                .thenReturn(30);
        when(achievementRepository.getNumberOfSpecificAchievement(5L,
                user1.getId())).thenReturn(0);
        String response = userController.addEmissionsBike(httpServletRequest,
                user1.getId(), emissionsClient);
    }

    @Test
    public void successfulAddEmission10timesFail1() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(emissionRepository.getNumberTransportationInsteadCar(user1.getId()))
                .thenReturn(10);
        when(achievementRepository.getNumberOfSpecificAchievement(4L,
                user1.getId())).thenReturn(1);
        String response = userController.addEmissionsBike(httpServletRequest,
                user1.getId(), emissionsClient);
    }

    @Test
    public void successfulAddEmission10timesFail2() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(emissionRepository.getNumberTransportationInsteadCar(user1.getId()))
                .thenReturn(8);
        when(achievementRepository.getNumberOfSpecificAchievement(4L,
                user1.getId())).thenReturn(0);
        String response = userController.addEmissionsBike(httpServletRequest,
                user1.getId(), emissionsClient);
    }

    @Test
    public void sucessfulAddEmission10Fail3() throws BadCredentialsException {
        Date date = Mockito.mock(Date.class);
        EmissionsClient emissionsClient = new EmissionsClient("1", 1F,
                date);
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        when(emissionRepository.getNumberTransportationInsteadCar(user1.getId()))
                .thenReturn(30);
        when(achievementRepository.getNumberOfSpecificAchievement(5L,
                user1.getId())).thenReturn(1);
        String response = userController.addEmissionsBike(httpServletRequest,
                user1.getId(), emissionsClient);
    }

    //Helper method of this testing class.
    private String getTokenOfUser(String username, String role, Long id) {
        JwtGenerator jwtGenerator = new JwtGenerator();
        JwtUser jwtUser = new JwtUser(username,
                id, role);
        return jwtGenerator.generate(jwtUser);
    }

    @Test
    public void changeSuccessfulCountry() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        String response = userController.changeCountry("123", 1L, httpServletRequest);
        Assert.assertEquals("Changed", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsChangeCountry() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.changeCountry("123", 1L, httpServletRequest);
    }

    @Test
    public void changeSuccessfulName() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        String response = userController.changeName("123", 1L, httpServletRequest);
        Assert.assertEquals("Changed", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsChangeName() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.changeName("123", 1L, httpServletRequest);
    }

    @Test
    public void changeSuccessfulDob() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        Date date = Mockito.mock(Date.class);
        String response = userController.changeDateOfBirth(date, 1L, httpServletRequest);
        Assert.assertEquals("Changed", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsChangeDob() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        Date date = Mockito.mock(Date.class);
        userController.changeDateOfBirth(date, 1L, httpServletRequest);
    }

    @Test
    public void changeSuccessfulEmail() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        String response = userController.changeEmail("123", 1L, httpServletRequest);
        Assert.assertEquals("Changed", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsChangeEmail() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.changeEmail("123", 1L, httpServletRequest);
    }

    @Test
    public void changeSuccessfulPassword() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));

        String response = userController.changePassword("123", 1L, httpServletRequest);
        Assert.assertEquals("Changed", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsChangePassword() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.changePassword("123", 1L, httpServletRequest);
    }

    @Test
    public void friendReqReceivedSuccessful() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        List<Friends> expected = new ArrayList<>();
        expected.add(friends1);
        when(friendsRepository.getFriendRequestRecieved(
                user1.getId()))
                .thenReturn(expected);
        List<Friends> response = userController.friendRequestRecieved(
                httpServletRequest, user1.getId());
        Assert.assertEquals(expected.get(0), response.get(0));
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsFriendRequestReceived() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.friendRequestRecieved(httpServletRequest, 1L);
    }

    @Test
    public void friendReqSentSuccessful() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        List<Friends> expected = new ArrayList<>();
        expected.add(friends1);
        when(friendsRepository.getFriendRequestSend(
                user1.getId()))
                .thenReturn(expected);
        List<Friends> response = userController.friendRequestSend(
                httpServletRequest, user1.getId());
        Assert.assertEquals(expected.get(0), response.get(0));
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsFriendRequestSent() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.friendRequestSend(httpServletRequest, 1L);
    }

    @Test
    public void rejectFriendSuccessful() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        String response = userController.rejectFriend(1L, 2L, httpServletRequest);
        Assert.assertEquals("Deleted", response);
    }

    @Test(expected = BadCredentialsException.class)
    public void rejectFriendBadCredentials() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.rejectFriend(1L, 2L, httpServletRequest);
    }

    @Test
    public void acceptFriendSuccessful() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        String response = userController.acceptFriend(1L, 2L, httpServletRequest);
        Assert.assertEquals("Saved", response);
    }

    @Test(expected = BadCredentialsException.class)
    public void acceptFriendBadCredentials() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.acceptFriend(1L, 2L, httpServletRequest);
    }

    @Test
    public void successfulAddFriends() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        String response = userController.addFriend(1L, 2L, httpServletRequest);
        Assert.assertEquals("Saved", response);
    }

    @Test (expected = BadCredentialsException.class)
    public void BadCredentialsAddFriend() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.addFriend(1L, 2L, httpServletRequest);
    }

    @Test
    public void searchFriendsSuccessful() {
        List<FriendsUserResp> expected = new ArrayList<>();
        expected.add(userResp1);
        when(userRepository.queryFriends(user1.getUsername()))
                .thenReturn(expected);
        List<FriendsUserResp> response = userController
                .searchFriends(user1.getUsername());
        Assert.assertEquals(expected.get(0), response.get(0));
    }

    @Test
    public void getAchievementsSuccessful() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token " + getTokenOfUser(
                user1.getUsername(), user1.getRole(),
                user1.getId()));
        List<AchievementsType> expected = new ArrayList<>();
        AchievementsType achievementsType = new AchievementsType(1L, "123");
        expected.add(achievementsType);
        when(achievementRepository.getAllAchievementsTypeOfUser(
                user1.getId()))
                .thenReturn(expected);
        List<AchievementsType> response = userController.getAchievementsUser(httpServletRequest,
                user1.getId());
        Assert.assertEquals(expected.get(0), response.get(0));
    }

    @Test (expected = BadCredentialsException.class)
    public void getAchievementsBadCredentials() throws BadCredentialsException {
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.addHeader("Authorisation", "Token ");
        userController.getAchievementsUser(httpServletRequest,
                user1.getId());
    }

}
