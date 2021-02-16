package java2.lesson2a;

public class Human {
    private String name;
    private int lengthMax;
    private int heightMax;

    public Human(String name, int lengthMax, int heightMax) {
        this.name = name;
        this.heightMax = heightMax;
        this.lengthMax = lengthMax;
    }
    public String getName(){ return name; }

    public int getHeightMax() {
        return heightMax;
    }

    public int getLengthMax() {
        return lengthMax;
    }
}
