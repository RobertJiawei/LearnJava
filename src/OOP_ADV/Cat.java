package OOP_ADV;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void catchMouse() {
        System.out.println(getName() + " catch mouse");
    }

    @Override
    public void drink() {
        System.out.println("cat drink");
    }
}
