package lesson1;

public class Robot implements Runnable, Jumpable {
    private int lengthMax;
    private int heightMax;

    public Robot(int lengthMax, int heightMax) {
        this.heightMax = heightMax;
        this.lengthMax = lengthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public int getLengthMax() {
        return lengthMax;
    }

    @Override
    public void run() {
        System.out.println("Robot run.");
    }

    @Override
    public void run(int max, int dis) {
        if ((max - dis) >= 0) {
            System.out.println("Robot run all distance. Dist.: " + dis);
        } else {
            System.out.println("Robot can't run all distance. Dist.: " + dis);
        }
    }

    @Override
    public void jump() {
        System.out.println("Robot can't jump.");
    }

    @Override
    public void jump(int max, int dis) {
        System.out.println("Robot can't jump of the wall. H.: " + dis);
    }
}
