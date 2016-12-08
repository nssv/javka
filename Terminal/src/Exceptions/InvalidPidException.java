package Exceptions;

public class InvalidPidException extends RuntimeException {
    public InvalidPidException(){
        super("Access Denies: Incorrect pid");
    }
}
