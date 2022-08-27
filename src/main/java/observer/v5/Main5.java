package observer.v5;

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
        for (Observer observer : observerList) {
            observer.actionWakeUp();
        }
    }
}

interface Observer{
    void actionWakeUp();
}

class Dad implements Observer{

    @Override
    public void actionWakeUp() {
        System.out.println("dad feeding......");

    }
}

class Mum implements Observer{

    @Override
    public void actionWakeUp() {
        System.out.println("mum hugging ...");
    }
}

class Dog implements Observer{

    @Override
    public void actionWakeUp() {
        System.out.println("dog wang ...");
    }
}

public class Main5 {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();

    }
}
