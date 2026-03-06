package creational;

interface Button {}
interface Checkbox {}
class MacButton implements Button {}
class MacCheckbox implements Checkbox {}

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}