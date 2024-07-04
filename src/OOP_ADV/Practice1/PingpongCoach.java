package OOP_ADV.Practice1;

public class PingpongCoach extends Coach implements English {
    public PingpongCoach() {
    }

    public PingpongCoach(int age, String name) {
        super(age, name);
    }

    @Override
    public void doing() {
        super.doing();
        System.out.println("Ping Pong");
    }

    @Override
    public void speak() {
        System.out.println("speak english");
    }
}
