package serverTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import server.controller.UserController;
import server.exception.BadCredentialsException;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.FriendsUserResp;
import server.model.JwtUser;
import server.model.Users;
import server.repository.UserRepository;
import server.security.JwtGenerator;

import javax.servlet.http.HttpServletRequest;
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

    private static Users user1;
    private static Users user2;
    private static Users user3;
    private static Users user4;

    private static FriendsUserResp userResp1;
    private static FriendsUserResp userResp2;

    @Before
    public void setUp() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.matches("abc", "abc"));

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

    private String getTokenOfUser(String username, String role, Long id) {
        JwtGenerator jwtGenerator = new JwtGenerator();
        JwtUser jwtUser = new JwtUser(username,
                id, role);
        return jwtGenerator.generate(jwtUser);
    }

}
