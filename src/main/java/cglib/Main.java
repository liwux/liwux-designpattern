package cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //增强
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return result;
    }
}

class Tank{
    public void move(){
        System.out.println("Tank moving .......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
