package OOP_ADV.Practice1;

public class BasketCoach extends Coach {
    public BasketCoach() {
    }

    public BasketCoach(int age, String name) {
        super(age, name);
    }

    @Override
    public void doing() {
        super.doing();
        System.out.println("Basketball");
    }
}
