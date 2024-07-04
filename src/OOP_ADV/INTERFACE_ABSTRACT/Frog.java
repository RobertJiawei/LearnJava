package OOP_ADV.INTERFACE_ABSTRACT;

public class Frog extends Animal implements Swim {
    public Frog() {
    }

    public Frog(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("frog eating");
    }

    @Override
    public void swim() {
        System.out.println("frog swimming");
    }
}
