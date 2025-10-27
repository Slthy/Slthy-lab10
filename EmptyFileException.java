/*
Extend Java’s IOException class to be this EmptyFileException class.
An exception of this type should be raised when the contents of the file to be parsed are empty.
You should pass in a string to its constructor, which passes that string to the parent’s constructor.
This string will be what is printed when your other code does something like:

catch (TooSmallText e){
    System.out.println(e); // will print whatever string you passed to the constructor
}
because .toString() will be called on the exception object there.

*/

import java.io.IOException;


public class EmptyFileException extends IOException{
    public EmptyFileException() {
        super();
    }
    public EmptyFileException(Throwable cause) {
        super(cause);
    }
    public EmptyFileException(String message) {
        super(message);
    }
    public EmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}