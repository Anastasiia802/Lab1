package creational;

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