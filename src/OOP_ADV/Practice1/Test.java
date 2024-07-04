package OOP_ADV.Practice1;

public class Test {
    public static void main(String[] args) {
        PingpongPlayer a = new PingpongPlayer(18, "abc");

        a.doing();
        a.speak();

        System.out.println("-----------------------");

        BasketCoach b = new BasketCoach(50, "123");

        b.doing();
    }
}
