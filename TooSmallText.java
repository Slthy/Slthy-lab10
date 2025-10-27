/*
The TooSmallText class
Extend Java’s Exception class to be this exception that is raised when the length of the text is less than five words.
*/

import java.io.IOException;

public class TooSmallText extends IOException{
    public TooSmallText() {
        super();
    }
    public TooSmallText(Throwable cause) {
        super(cause);
    }
    public TooSmallText(String message) {
        super(message);
    }
    public TooSmallText(String message, Throwable cause) {
        super(message, cause);
    }
}