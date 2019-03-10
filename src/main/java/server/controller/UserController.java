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
import server.model.FriendsUserResp;
import server.model.JwtUser;
import server.model.Users;
import server.repository.UserRepository;
import server.security.JwtValidator;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

        return userRepository.save(user);
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

    private boolean isIncorrectUser(HttpServletRequest request, Long id) {
        String token = request.getHeader("Authorisation").substring(6);
        JwtUser jwtUser = jwtValidator.validate(token);

        if (jwtUser == null) {
            return true;
        }

        return id != jwtUser.getId();
    }

}
