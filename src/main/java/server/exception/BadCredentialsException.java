package server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BadCredentialsException extends Exception{

    public BadCredentialsException(){
        super();
    }

    public BadCredentialsException(final String msg){
        super(msg);
    }

}
