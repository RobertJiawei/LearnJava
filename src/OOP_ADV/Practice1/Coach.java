package OOP_ADV.Practice1;

public class Coach extends Person {
    public Coach() {
    }

    public Coach(int age, String name) {
        super(age, name);
    }

    @Override
    public void doing() {
        System.out.println("teaching");
    }
}
