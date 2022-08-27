package observer.v4;

class Child{
    private boolean cry = false;
    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog g = new Dog();
    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        d.feed();
        m.hug();
        g.wang();
    }
}


class Dad{
    public void feed(){
        System.out.println("dad feeding......");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging ...");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wang ...");
    }
}

public class Main4 {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();

    }
}
