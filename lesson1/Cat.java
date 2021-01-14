package lesson1;

public class Cat implements Runnable,Jumpable{
    private int lengthMax;
    private int heightMax;

    public Cat(int lengthMax, int heightMax){
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
        System.out.println("Cat run.");
    }

    @Override
    public void run(int max,int dis) {
        if ((max-dis)>=0) {
            System.out.println("Cat run all distance. Dist.: "+dis);
        }else{
            System.out.println("Cat can't run all distance. Dist.: "+dis);
        }
    }

    @Override
    public void jump() {
        System.out.println("Cat jump.");
    }

    @Override
    public void jump(int max,int dis) {
        if ((max-dis)>=0) {
            System.out.println("Cat jump of the wall. H.: "+dis);
        }else{
            System.out.println("Cat can't jump of the wall. H.: "+dis);
        }
    }
}
