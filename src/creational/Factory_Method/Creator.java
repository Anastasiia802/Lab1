package creational.Factory_Method;

interface Product {}
class ConcreteProductA implements Product {}

public abstract class Creator {
    abstract Product createProduct();
}

class ConcreteCreatorA extends Creator {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}