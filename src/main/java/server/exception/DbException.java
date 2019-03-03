package server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class DbException extends Exception {

    public DbException(){
        super();
    }

    public DbException(String excp) {
        super(excp);
    }
}
