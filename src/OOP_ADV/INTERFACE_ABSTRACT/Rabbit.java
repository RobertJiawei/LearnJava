package OOP_ADV.INTERFACE_ABSTRACT;

public class Rabbit extends Animal {
    public Rabbit() {
    }

    public Rabbit(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("rabbit eating");
    }
}
