package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import server.exception.BadCredentialsException;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.*;
import server.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Returns all the users in the database.
    @GetMapping("/user/all")
    public List<Users> getUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping(value = "/save/user")
    public Users saveUser(@RequestBody Users user) throws UserAlreadyRegistered {
        if(userRepository.findByUsername(user.getUsername()) != null)
        {
            throw new UserAlreadyRegistered("Username: " + user.getUsername() + " is already in use..");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @GetMapping(value = "/user/{id}")
    public Optional<Users> getUser(@PathVariable("id") Long id) throws ResourceNotFoundException {

       if(!userRepository.findById(id).isPresent())
            throw new ResourceNotFoundException("The user is not available");

        return userRepository.findById(id);
    }

    // Return a list of all the friends of user with id given as parameter.
    @GetMapping("/user/allfriends/{id}")
    public List<FriendsUserResp> getFriendsUser(@PathVariable("id") Long id)
    {
        return userRepository.findAllFriendsUser(id);
    }


    //Authenticate users.
    @PostMapping("/user/auth")
    public void authUser(@RequestBody AuthenticateUser authenticateUser) throws BadCredentialsException {

        String username = authenticateUser.getUsername();
        String password = authenticateUser.getPassword();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String retrievedPassword = userRepository.findUserPassword(username);

        System.out.println(retrievedPassword);

        if(userRepository.findByUsername(username) == null || !bCryptPasswordEncoder.matches(password, retrievedPassword))
            throw new BadCredentialsException("Incorrect username or password");

    }

    // Handle All other URLS.
    @RequestMapping(method = RequestMethod.GET)
    public void redirectEverythingOtherThanTest()throws ResourceNotFoundException{
        throw new ResourceNotFoundException();
    }

}
