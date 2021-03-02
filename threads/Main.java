package threads;

public class Main {
    public static final int size = 1000000;
    public static final int h = size / 2;
    public static float[] arr = new float[size];
    public static float[] halfArr = new float[h];
    public static float[] halfArr2 = new float[h];
    public static int i;
    public static long a;

    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            for (i = 0; i < size; i++) {
                arr[i] = 1.0F;
            }
            System.out.println("Время заполнения единицами: " + (a = System.currentTimeMillis()));
        });
        th.start();
        Thread th2 = new Thread(() -> {
            goToMath(arr);
            System.out.println("Время расчет для массива size поток th2:\n" + (a = System.currentTimeMillis()));
        });
        th2.start();

        Thread thX3 = new Thread(() -> {
            System.arraycopy(arr, 0, halfArr, 0, h);
            System.arraycopy(arr, h, halfArr2, 0, h);
            new Thread(() -> {
                goToMath(halfArr);
            });
            new Thread(() -> {
                goToMath(halfArr2);
            });
            System.arraycopy(halfArr, 0, arr, 0, h);
            System.arraycopy(halfArr2, 0, arr, h, h);
            System.out.println("Время расчета для массивов size/2 поток thX3:\n" + (a = System.currentTimeMillis()));
        });
        thX3.start();

//      так оптимальнее?
//        {
//            Thread th3 = new Thread(() -> {
//                System.arraycopy(arr, 0, halfArr, 0, h);
//                goToMath(halfArr);
//                System.arraycopy(halfArr, 0, arr, 0, h);
//                System.out.println("Время расчета для массива size/2 поток th3:\n" + (a = System.currentTimeMillis()));
//            });
//            Thread th4 = new Thread(() -> {
//                System.arraycopy(arr, h, halfArr2, 0, h);
//                goToMath(halfArr2);
//                System.arraycopy(halfArr2, 0, arr, h, h);
//                System.out.println("Время: расчета для массива size/2 поток th4:\n" + (a = System.currentTimeMillis()));
//            });
//            th3.start();
//            th4.start();
//        }
    }

    public static void goToMath(float[] arr) {
        for (i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
