package creational;

import creational.Abstract_Factory.Button;
import creational.Abstract_Factory.Checkbox;
import creational.Abstract_Factory.GUIFactory;
import creational.Abstract_Factory.MacFactory;
import creational.Factory_Method.ConcreteCreatorA;
import creational.Factory_Method.Creator;
import creational.Factory_Method.Product;
import creational.Prototype.Sheep;
import creational.Singleton.Singleton;
import creational.builder.House;
import creational.builder.HouseBuilder;
import creational.factory.Document;
import creational.factory.Factory;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Singleton: s1 та s2 є одним об'єктом - " + (s1 == s2));

        Factory simpleFactory = new Factory();
        Document doc = simpleFactory.createDocument("PDF");
        System.out.println("Factory: створено " + doc.getClass().getSimpleName());

        Creator creator = new ConcreteCreatorA();
        Product p = creator.createProduct();
        System.out.println("Factory Method: створено " + p.getClass().getSimpleName());

        GUIFactory abstractFactory = new MacFactory();
        Button b = abstractFactory.createButton();
        Checkbox cb = abstractFactory.createCheckbox();
        System.out.println("Abstract Factory: створено " + b.getClass().getSimpleName() + " та " + cb.getClass().getSimpleName());

        House house = new HouseBuilder().buildWalls(4).build();
        System.out.println("Builder: Будинок успішно побудовано");

        Sheep original = new Sheep();
        Sheep cloned = (Sheep) original.clonePrototype();
        System.out.println("Prototype: клонована вівця не є оригіналом - " + (original != cloned));
    }
}