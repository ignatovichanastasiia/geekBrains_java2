package ArrayException;

import java.text.NumberFormat;

public class MyTakeIntException extends NumberFormatException {
    private static int x, y;

    MyTakeIntException(String message, int x, int y) {
        super(message);

        this.x = x;
        this.y = y;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

}
