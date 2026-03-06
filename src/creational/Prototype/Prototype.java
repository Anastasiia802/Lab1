package creational.Prototype;

public interface Prototype {
    Prototype clonePrototype();
}

class Sheep implements Prototype {
    public Prototype clonePrototype() {
        return new Sheep();
    }
}