package burger_shop;

public class HealthBurger extends Burger {

    String[] toppings = {"lettuce", "tomatoes", "onions", "pickles", "bean sprouts", "carrots"};

    public HealthBurger(Bread bread, Meat meat) {
        super(bread, meat,4, 2.10, .75);
        this.bread = bread;
        this.meat = meat;
    }
}
