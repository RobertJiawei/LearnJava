package OOP_ADV.INTERFACE_ABSTRACT;

public class Test {
    public static void main(String[] args) {
        Frog f = new Frog(1, "frog");

        f.eat();
        f.swim();

        Rabbit r = new Rabbit(2, "rabbit");

        r.eat();
    }
}
