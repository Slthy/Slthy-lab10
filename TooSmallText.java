import java.io.IOException;

public class TooSmallText extends IOException{
    public TooSmallText(String message) {
        super(message);
    }
}