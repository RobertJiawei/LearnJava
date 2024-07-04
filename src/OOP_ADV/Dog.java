package OOP_ADV;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void watchHouse() {
        System.out.println(getName() + " watch house");
    }
}
