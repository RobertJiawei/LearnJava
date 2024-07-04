package OOP_ADV.Practice1;

public class PingpongPlayer extends Player implements English {
    public PingpongPlayer() {
    }

    public PingpongPlayer(int age, String name) {
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
