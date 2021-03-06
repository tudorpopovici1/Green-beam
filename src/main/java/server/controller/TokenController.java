package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.exception.BadCredentialsException;
import server.model.AuthenticateUser;
import server.model.JwtUser;
import server.repository.UserRepository;
import server.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator = new JwtGenerator();

    @Autowired
    private UserRepository userRepository;

    /**
     * Authenticates a user using its credentials.
     * @param authenticateUser object instance of user credentials
     * @return authenticateuser object instance
     * @throws BadCredentialsException exception thrown in case of wrong credentials.
     */

    @PostMapping
    public AuthenticateUser generate(
            @RequestBody AuthenticateUser authenticateUser)
            throws BadCredentialsException {

        String username = authenticateUser.getUsername();
        String password = authenticateUser.getPassword();
        BCryptPasswordEncoder encryptPasswordEncoder = new BCryptPasswordEncoder();
        String retrievedPassword = userRepository.findUserPassword(username);

        Long id = userRepository.findUserId(username);
        String role = userRepository.findUserRole(username);

        if (
                userRepository.findByUsername(username) == null
                        || !encryptPasswordEncoder.matches(password, retrievedPassword)) {

            throw new BadCredentialsException("Incorrect username or password");
        }

        JwtUser jwtUser = new JwtUser(username, id, role);
        authenticateUser.setToken(jwtGenerator.generate(jwtUser));
        return authenticateUser;
    }
}
