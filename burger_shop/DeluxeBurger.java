package burger_shop;

public class DeluxeBurger extends Burger {

    String[] toppings = {"lettuce", "tomatoes", "onions", "pickles", "cheese", "bacon", "ketchup", "mustard",
            "mayo", "guacamole", "pico de gallo", "relish"};

    public DeluxeBurger(Bread bread, Meat meat) {
        super(bread, meat, 6, 2.00, .75);
        this.bread = bread;
        this.meat = meat;
    }
}
