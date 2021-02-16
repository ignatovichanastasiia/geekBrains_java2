package java2.lesson2a;

public class Lesson1 {

    public static void main(String[] args) {
        Object[] list1 = new Object[3];
        Object[] list2 = new Object[4];
        Cat c1 = new Cat("Bars", 200, 3);
        Robot r1 = new Robot("s3p0", 1000, 0);
        Human h1 = new Human("Valera", 600, 2);
        Wall w1 = new Wall(1);
        Treadmill tr1 = new Treadmill(100);
        Wall w2 = new Wall(3);
        Treadmill tr2 = new Treadmill(300);
        list1[0] = c1;
        list1[1] = r1;
        list1[2] = h1;
        list2[0] = w1;
        list2[1] = tr1;
        list2[2] = w2;
        list2[3] = tr2;

        for(int i = 0; i < list1.length; i++){
            for(int y = 0; y < list2.length;y++){
                if(list2[y] instanceof Wall) {
                    if (list1[i] instanceof Cat) {
                        System.out.println(((Cat) list1[i]).getName());
                        int heightMax = ((Cat) list1[i]).getHeightMax();
                        int height = ((Wall) list2[y]).getHeight();
                        if(!((Wall) list2[y]).jump(heightMax, height)) break;
                    } else if (list1[i] instanceof Robot) {
                        System.out.println(((Robot) list1[i]).getName());
                        int heightMax = ((Robot) list1[i]).getHeightMax();
                        int height = ((Wall) list2[y]).getHeight();
                        if(!((Wall) list2[y]).jump(heightMax, height)) break;
                    } else if (list1[i] instanceof Human) {
                        System.out.println(((Human) list1[i]).getName());
                        int heightMax = ((Human) list1[i]).getHeightMax();
                        int height = ((Wall) list2[y]).getHeight();
                        if(!((Wall) list2[y]).jump(heightMax, height)) break;
                    }
                }else if(list2[y] instanceof Treadmill) {
                    if (list1[i] instanceof Cat) {
                        int lengthMax = ((Cat) list1[i]).getLengthMax();
                        int length = ((Runnable) list2[y]).getLength();
                        if(!((Treadmill) list2[y]).run(lengthMax, length)) break;
                    } else if (list1[i] instanceof Robot) {
                        int lengthMax = ((Robot) list1[i]).getLengthMax();
                        int length = ((Runnable) list2[y]).getLength();
                        if(!((Treadmill) list2[y]).run(lengthMax, length)) break;
                    } else if (list1[i] instanceof Human) {
                        int lengthMax = ((Human) list1[i]).getLengthMax();
                        int length = ((Runnable) list2[y]).getLength();
                        if(!((Treadmill) list2[y]).run(lengthMax, length)) break;
                    }
                }
            }
        }
    }
}