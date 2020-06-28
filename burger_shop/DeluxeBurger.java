package burger_shop;

import java.util.ArrayList;
import java.util.Arrays;

public class DeluxeBurger extends Burger {

    public DeluxeBurger(String bread, String meat) {
        super("deluxe burger", bread, meat, new ArrayList<String>(Arrays.asList("lettuce", "tomatoes", "onions",
                "pickles", "cheese", "bacon", "ketchup", "mustard", "mayo", "guacamole", "pico de gallo",
                "relish")), new ArrayList<String>(), 6, 2.00, .75);
        this.bread = bread;
        this.meat = meat;
    }
}
