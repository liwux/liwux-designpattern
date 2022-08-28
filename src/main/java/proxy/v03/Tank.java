package proxy.v03;

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

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable{
    void move();
}
