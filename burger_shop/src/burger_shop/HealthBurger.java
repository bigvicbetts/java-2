package burger_shop;

import java.util.ArrayList;
import java.util.Arrays;

class HealthBurger extends Burger {

    HealthBurger(String bread, String meat) {
        super("healthy burger", bread, meat, new ArrayList<String>(Arrays.asList("lettuce", "tomatoes", "onions",
                "pickles", "bean sprouts", "carrots")), new ArrayList<String>(), 4, 2.10,
                .75);
        this.bread = bread;
        this.meat = meat;
    }
}
