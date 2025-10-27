/*
The InvalidStopwordException class
Extend Java’s Exception class to be this exception that is raised when the stopword is not found in the text.
*/

public class InvalidStopwordException extends Exception{
    public InvalidStopwordException() {
        super();
    }
    public InvalidStopwordException(Throwable cause) {
        super(cause);
    }
    public InvalidStopwordException(String message) {
        super(message);
    }
    public InvalidStopwordException(String message, Throwable cause) {
        super(message, cause);
    }
}