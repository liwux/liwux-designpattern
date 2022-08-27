package observer.v3;

class Child{
    private boolean cry = false;
    private Dad d = new Dad();
    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        d.feed();
    }
}


class Dad{
    public void feed(){
        System.out.println("dad feeding......");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}
