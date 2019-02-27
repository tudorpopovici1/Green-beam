package server.controller;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import server.exception.BadCredentialsException;
import server.exception.ResourceNotFoundException;
import server.model.AuthenticateUser;
import server.model.JwtUser;
import server.repository.UserRepository;
import server.security.JwtGenerator;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String generate(@NotNull @RequestBody AuthenticateUser authenticateUser) throws BadCredentialsException {

        String username = authenticateUser.getUsername();
        String password = authenticateUser.getPassword();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String retrievedPassword = userRepository.findUserPassword(username);

        Long id = userRepository.findUserId(username);
        String role = userRepository.findUserRole(username);

        if(userRepository.findByUsername(username) == null || !bCryptPasswordEncoder.matches(password, retrievedPassword))
            throw new BadCredentialsException("Incorrect username or password");

        JwtUser jwtUser = new JwtUser(username, id, role);

        return jwtGenerator.generate(jwtUser);

    }

    /*@PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){//@PathVariable("username") final String username, @PathVariable("userid") Long userId, @PathVariable("role") final String role) {//@RequestBody final JwtUser jwtUser)

            //JwtUser jwtUser = new JwtUser(username, userId, role);
            return jwtGenerator.generate(jwtUser);
    }*/
}

