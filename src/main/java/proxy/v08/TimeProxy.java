package proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements InvocationHandler {
    Tank tank;
    public TimeProxy(Tank tank){
        this.tank = tank;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method "+method.getName()+" start ...");
        Object o = method.invoke(tank,args);
        System.out.println("method "+ method.getName()+ " end!");
        return  o;
    }
}
