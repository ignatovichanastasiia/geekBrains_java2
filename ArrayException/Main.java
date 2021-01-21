package ArrayException;

public class Main {
    public static int[][] arrInt = new int[4][4];
    public static int sum;
    public static int x, y;
    private static final int SIZE = 4;

    public static void main(String[] args) {
        String[][] arrString = {{"4", "3", "6", "6",},
                    {"3", "4", "6", "2t"},
                    {"2", "7", "5", "4"},
                    {"3", "7", "4", "7"}};
        try {
            arrInt = ArrayException(arrString);
        } catch (MyCastException e) {
            System.out.println(e.getMessage()+e.getX() + ", " + e.getY());
        } catch (MyArrayException e) {
            System.out.println(e.getMessage()+e.getSIZE());
        }
        printArray(arrInt);
        sum = arrSum(arrInt);
        System.out.println("Сумма чисел массива: " + sum);
        System.out.println("end");
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] ArrayException(String[][] arr) throws MyArrayException, MyCastException {
        for(int i = 0;i<arr.length;i++){
            if (arr[i].length != SIZE) {
                throw new MyArrayException("Массив превышает допустимый размер: ", SIZE);
            }
        }
        try {
            for (x = 0; x < arr.length; x++) {
                for (y = 0; y < arr.length; y++) {
                    arrInt[x][y] = Integer.parseInt(arr[x][y]);
                }
            }
        }catch (NumberFormatException e) {
                throw new MyCastException("Преобразование не выполнено. Измените формат ячейки: ", x, y);
        }
        return arrInt;
    }

    public static int arrSum(int[][] arr) {
        for (x = 0; x < arr.length; x++) {
            for (y = 0; y < arr.length; y++) {
                sum = sum + arrInt[x][y];
            }
        }
        return sum;
    }
}
