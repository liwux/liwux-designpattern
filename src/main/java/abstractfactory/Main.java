package abstractfactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ModernFactory();
        Vehicle c = abstractFactory.createVehicle();
        c.go();
        Weapon w = abstractFactory.createWeapon();
        w.shoot();
        Food b = abstractFactory.createFood();
        b.printName();
    }
}
