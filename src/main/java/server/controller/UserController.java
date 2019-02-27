package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import server.exception.BadCredentialsException;
import server.exception.DbException;
import server.exception.ResourceNotFoundException;
import server.exception.UserAlreadyRegistered;
import server.model.FriendsUserResp;
import server.model.JwtUser;
import server.model.Users;
import server.repository.UserRepository;
import server.security.JwtValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtValidator jwtValidator;

    // Returns all the users in the database.
    @GetMapping("/user/all")
    public List<Users> getUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping(value = "/save/user")
    public Users saveUser(@RequestBody Users user) throws UserAlreadyRegistered, DbException {

        if(userRepository.findByUsername(user.getUsername()) != null)
        {
            throw new UserAlreadyRegistered("Username: " + user.getUsername() + " is already in use..");
        }

        if(userRepository.findByEmail(user.getEmail()) != null)
        {
            throw new UserAlreadyRegistered("Email is in use...");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @GetMapping(value = "/user/{id}")
    public FriendsUserResp getUser(HttpServletRequest request, @PathVariable("id") Long id) throws ResourceNotFoundException, BadCredentialsException {

        if(!isCorrectUser(request, id))
            throw new BadCredentialsException("Nice try!");

       if(!userRepository.findById(id).isPresent())
            throw new ResourceNotFoundException("The user is not available");

        return userRepository.findSpecificUserById(id);
    }

    // Return a list of all the friends of user with id given as parameter.
    @GetMapping("/user/allfriends/{id}")
    public List<FriendsUserResp> getFriendsUser(HttpServletRequest request, @PathVariable("id") Long id) throws BadCredentialsException {

        if(!isCorrectUser(request, id))
            throw new BadCredentialsException("Bad credentials");

        return userRepository.findAllFriendsUser(id);
    }

    // Handle All other URLS.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public void redirectEverythingOtherThanTest()throws ResourceNotFoundException{
        throw new ResourceNotFoundException();
    }

    private boolean isCorrectUser(HttpServletRequest request, Long id){

        String token = request.getHeader("Authorisation").substring(6);

        JwtUser jwtUser = jwtValidator.validate(token);

        System.out.println(token);
        if(jwtUser != null)
            System.out.println(jwtUser);

        if(jwtUser == null || id != jwtUser.getId())
            return false;

        return true;
    }

}
