package burger_shop;

public class PlainBurger extends Burger {

    String[] toppings = {"lettuce", "tomatoes", "onions", "pickles", "cheese", "bacon", "ketchup", "mustard", "mayo"};

    public PlainBurger(Bread bread, Meat meat) {
        super(bread, meat, 2, 2.50, .50);
    }
}
