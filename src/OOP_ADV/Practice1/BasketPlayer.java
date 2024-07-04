package OOP_ADV.Practice1;

public class BasketPlayer extends Player {
    public BasketPlayer() {
    }

    public BasketPlayer(int age, String name) {
        super(age, name);
    }

    @Override
    public void doing() {
        super.doing();
        System.out.println("Basketball");
    }
}
