package creational;

import java.util.ArrayList;
import java.util.List;

class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

interface Product {}
class ConcreteProductA implements Product {}
abstract class Creator {
    abstract Product createProduct();
}
class ConcreteCreatorA extends Creator {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

interface Button {}
interface Checkbox {}
class MacButton implements Button {}
class MacCheckbox implements Checkbox {}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

class House {
    private int walls;
    public void setWalls(int walls) { this.walls = walls; }
}
class HouseBuilder {
    private House house = new House();
    public HouseBuilder buildWalls(int walls) {
        house.setWalls(walls);
        return this;
    }
    public House build() { return house; }
}

interface Prototype {
    Prototype clonePrototype();
}
class Sheep implements Prototype {
    public Prototype clonePrototype() {
        return new Sheep();
    }
}

class Connection {}
class ConnectionPool {
    private List<Connection> available = new ArrayList<>();

    public Connection acquire() {
        if (available.isEmpty()) return new Connection();
        return available.remove(available.size() - 1);
    }
    public void release(Connection c) {
        available.add(c);
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Singleton: s1 та s2 є одним об'єктом - " + (s1 == s2));

        Creator creator = new ConcreteCreatorA();
        Product p = creator.createProduct();
        System.out.println("Factory Method: створено " + p.getClass().getSimpleName());

        GUIFactory factory = new MacFactory();
        Button b = factory.createButton();
        Checkbox cb = factory.createCheckbox();
        System.out.println("Abstract Factory: створено " + b.getClass().getSimpleName() + " та " + cb.getClass().getSimpleName());

        House house = new HouseBuilder().buildWalls(4).build();
        System.out.println("Builder: Будинок успішно побудовано");

        Sheep original = new Sheep();
        Sheep cloned = (Sheep) original.clonePrototype();
        System.out.println("Prototype: клонована вівця не є оригіналом - " + (original != cloned));

        ConnectionPool pool = new ConnectionPool();
        Connection c = pool.acquire();
        System.out.println("Object Pool: отримано з'єднання");
        pool.release(c);
        System.out.println("Object Pool: з'єднання повернуто в пул");
    }
}