package OOP_ADV.INTERFACE_ABSTRACT;

public class Dog extends Animal implements Swim {
    public Dog() {
    }

    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public void eat() {
        System.out.println("dog eating");
    }

    @Override
    public void swim() {
        System.out.println("dog swimming");
    }
}
