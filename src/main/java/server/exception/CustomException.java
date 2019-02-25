package server.exception;

public class CustomException extends Exception {

    public CustomException(){
        super();
    }

    public CustomException(final String msg)
    {
        super(msg);
    }

}
