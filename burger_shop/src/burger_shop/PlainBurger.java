package burger_shop;

import java.util.ArrayList;
import java.util.Arrays;

class PlainBurger extends Burger {

    PlainBurger(String bread, String meat) {
        super("plain burger", bread, meat, new ArrayList<String>(Arrays.asList("lettuce", "tomatoes", "onions",
                "pickles", "cheese", "bacon", "ketchup", "mustard", "mayo")), new ArrayList<String>(),
                2, 2.50, .50);
        this.bread = bread;
        this.meat = meat;
    }
}
