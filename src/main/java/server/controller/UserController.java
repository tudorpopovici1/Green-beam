package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.model.*;
import server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

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


    // Return a list of all the friends of user with id given as parameter.
    @GetMapping("/user/allfriends/{id}")
    public List<Users> getFriendsUser(@PathVariable("id") Long id)
    {
        return userRepository.findAllFriendsUser(id);
    }

}
