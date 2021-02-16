package java2.lesson2a;

public class Treadmill implements Runnable{
    private int length;

    Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean run(int max, int dis) {
        if ((max-dis)>=0) {
            System.out.println("run all distance. Dist.: "+dis);
            return true;
        }else{
            System.out.println("can't run all distance. Dist.: " + dis);
            return false;
        }
    }
}
