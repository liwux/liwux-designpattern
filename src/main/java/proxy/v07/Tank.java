package proxy.v07;

import java.util.Random;

public class Tank implements Movable{

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank moving ......");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new TankLogProxy(
                new TankTimeProxy(
                        new Tank()
        )).move();
    }
}

class TankTimeProxy implements Movable{
    Movable movable;

    public TankTimeProxy(Movable movable){
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }
}


class TankLogProxy implements Movable{
    Movable movable;

    public TankLogProxy(Movable movable){
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("Start moving");
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println("Stopped!");
    }
}

interface Movable{
    void move();
}
