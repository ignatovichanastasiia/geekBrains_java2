package ArrayException;

import java.text.NumberFormat;

public class MyCastException extends NumberFormatException {
    private static int x, y;

    MyCastException(String message, int i, int y) {
        super(message);
        this.x = i;
        this.y = y;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

}
