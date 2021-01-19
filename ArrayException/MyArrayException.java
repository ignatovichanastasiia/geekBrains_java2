package ArrayException;

public class MyArrayException extends ArrayIndexOutOfBoundsException {
    private static int SIZE;

    MyArrayException(String message, int SIZE) {
        super(message);
        this.SIZE = SIZE;
    }

    public static int getSIZE(){
        return SIZE;
    }
}
