package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.exception.CustomException;
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
    public Users saveUser(@RequestBody Users user) throws CustomException {
        if(userRepository.findByUsername(user.getUsername()) != null)
        {
            throw new CustomException("Username: " + user.getUsername() + " is already in use..");
        }

        return userRepository.save(user);
    }

    @GetMapping(value = "/user/{id}")
    public Optional<Users> getUser(@PathVariable("id") Long id) throws CustomException {

       if(!userRepository.findById(id).isPresent())
            throw new CustomException("The user is not available");

        return userRepository.findById(id);
    }

    // Return a list of all the friends of user with id given as parameter.
    @GetMapping("/user/allfriends/{id}")
    public List<FriendsUserResp> getFriendsUser(@PathVariable("id") Long id)
    {
        return userRepository.findAllFriendsUser(id);
    }

}
