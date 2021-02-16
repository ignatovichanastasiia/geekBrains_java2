package lesson1;

public class Main {
    public static int max;
    public static int dis;

    public static void main(String[] args) {
        Cat cat1 = new Cat(200, 150);
        Human human1 = new Human(600, 100);
        Robot robot1 = new Robot(2000, 0);
        Jumpable[] jumpables = {cat1, human1, robot1};
        Runnable[] runnables = {cat1, human1, robot1};
        Jumping(jumpables);
        Running(runnables);
        Wall wall1 = new Wall(120);
        Treadmill tr1 = new Treadmill(300);
        JumpingOff(jumpables, wall1);
        RunningDis(runnables, tr1);
        Wall wall2 = new Wall(1);
        Wall wall3 = new Wall(50);
        Wall wall4 = new Wall(150);
        Wall wall5 = new Wall(200);
        Wall[] walls = {wall2, wall3, wall4, wall5};
        System.out.println("Get walls.");
        JumpingOff(jumpables, walls);
        Treadmill tr2 = new Treadmill(100);
        Treadmill tr3 = new Treadmill(300);
        Treadmill tr4 = new Treadmill(400);
        Treadmill tr5 = new Treadmill(800);
        Treadmill[] trms = {tr2, tr3, tr4, tr5};
        System.out.println("Get tracks.");
        RunningDis(runnables, trms);

    }

    public static void Jumping(Jumpable[] jumpables) {
        for (Jumpable o : jumpables) {
            o.jump();
        }
    }

    public static void JumpingOff(Jumpable[] jumpables, Wall w) {
        dis = w.getHeight();
        for (Jumpable o : jumpables) {
            max = o.getHeightMax();
            o.jump(max, dis);
        }
    }

    public static void JumpingOff(Jumpable[] jumpables, Wall[] walls) {
        for (Jumpable o : jumpables) {
            max = o.getHeightMax();
            for (Wall w : walls) {
                dis = w.getHeight();
                if ((max - dis) > 0) {
                    o.jump(max, dis);
                } else {
                    o.jump(max, dis);
                    break;
                }
            }
        }
    }

    public static void Running(Runnable[] runnables) {
        for (Runnable o : runnables) {
            o.run();
        }
    }

    public static void RunningDis(Runnable[] runnables, Treadmill tr) {
        dis = tr.getLength();
        for (Runnable o : runnables) {
            max = o.getLengthMax();
            o.run(max, dis);
        }
    }

    public static void RunningDis(Runnable[] runnables, Treadmill[] trms) {
        for (Runnable o : runnables) {
            max = o.getLengthMax();
            for (Treadmill t : trms) {
                dis = t.getLength();
                if ((max - dis) > 0) {
                    o.run(max, dis);
                } else {
                    o.run(max, dis);
                    break;
                }
            }
        }
    }

}
