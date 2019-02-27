package server.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import server.model.JwtUser;

@Component
public class JwtValidator {

    private String secret = "secret";

    public JwtUser validate(String token){

        JwtUser jwtUser = null;

        try {

            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        return jwtUser;
    }

}
