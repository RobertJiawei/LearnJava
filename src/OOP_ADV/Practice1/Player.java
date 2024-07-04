package OOP_ADV.Practice1;

public class Player extends Person {
    public Player() {
    }

    public Player(int age, String name) {
        super(age, name);
    }

    @Override
    public void doing() {
        System.out.println("learning");
    }
}
