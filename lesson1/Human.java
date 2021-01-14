package lesson1;

public class Human implements Runnable,Jumpable{
    private int lengthMax;
    private int heightMax;

    public Human(int lengthMax, int heightMax) {
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
        System.out.println("Human run.");
    }

    @Override
    public void run(int max,int dis) {
        if ((max-dis)>=0) {
            System.out.println("Human run all distance. Dist.: "+dis);
        }else{
            System.out.println("Human can't run all distance. Dist.: "+dis);
        }
    }

    @Override
    public void jump() {
        System.out.println("Human jump.");
    }

    @Override
    public void jump(int max,int dis) {
        if ((max-dis)>=0) {
            System.out.println("Human jump of the wall. H.: " + dis);
        }else{
            System.out.println("Human can't jump of the wall. H.: "+dis);
        }
    }
}
