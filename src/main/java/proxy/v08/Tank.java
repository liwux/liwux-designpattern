package proxy.v08;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving .......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        //refection 通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{
                        Movable.class
                }, new TimeProxy(tank));
        m.move();
    }
}

interface Movable{
    void move();
}
