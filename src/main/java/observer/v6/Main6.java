package observer.v6;

import java.util.ArrayList;
import java.util.List;

class Child{
    private boolean cry = false;
    private List<Observer> observerList = new ArrayList<>();
    {
        observerList.add(new Dad());
        observerList.add(new Mum());
        observerList.add(new Dog());
    }

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(),"bed");
        for (Observer observer : observerList) {
            observer.actionWakeUp(event);
        }
    }
}

class wakeUpEvent{
    long timestamp;
    String loc;
    public wakeUpEvent(long timestamp,String loc){
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer{
    void actionWakeUp(wakeUpEvent event);
}

class Dad implements Observer{

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        System.out.println("dad...."+event);
    }
}

class Mum implements Observer{

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        System.out.println("mum...."+event);
    }
}

class Dog implements Observer{

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        System.out.println("dog wang ..."+event);
    }
}

public class Main6 {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();

    }
}
