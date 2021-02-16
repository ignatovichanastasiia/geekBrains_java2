package java2.lesson2a;

public class Wall implements Jumpable {
    private int height;

    Wall(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public boolean jump(int max, int dis) {
        if ((max-dis)>=0) {
            System.out.println("jump of the wall. H.: "+dis);
            return true;
        }else{
            System.out.println("can't jump of the wall. H.: "+dis);
            return false;
        }
    }
}
