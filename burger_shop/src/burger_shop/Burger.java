package burger_shop;

import java.util.ArrayList;

abstract class Burger {
    String bread;
    String meat;
    String name;
    final ArrayList<String> POSSIBLE_TOPPINGS;
    ArrayList<String> burgerToppings;
    final int MAX_TOPPINGS;
    final double PLAIN_PRICE;
    final double PER_TOPPING_PRICE;

    Burger(String name, String bread, String meat, ArrayList<String> toppings, ArrayList<String> burgerToppings, int maxToppings,
                  double plainPrice, double perToppingPrice) {

        this.name = name;
        if (Bread.BREAD_TYPES.contains(bread)) {
            this.bread = bread;
        }
        else {
            throw new Error("We do not have " + bread + " bread. Option are " + Bread.BREAD_TYPES + ".");
        }

        if (Meat.MEAT_TYPES.contains(meat)) {
            this.meat = meat;
        }
        else {
            throw new Error("We do not have " + meat + " patties. Options are " + Meat.MEAT_TYPES + ".");
        }

        this.POSSIBLE_TOPPINGS = toppings;
        this.burgerToppings = burgerToppings;
        this.MAX_TOPPINGS = maxToppings;
        this.PLAIN_PRICE = plainPrice;
        this.PER_TOPPING_PRICE = perToppingPrice;
    }

    double getPlainPrice() {
        return this.PLAIN_PRICE;
    }

    double getPerToppingPrice() {
        return this.PER_TOPPING_PRICE;
    }

    double calcPrice() {
        return this.PLAIN_PRICE + (this.PER_TOPPING_PRICE * this.burgerToppings.size());
    }

    void showBurger() {
        if (burgerToppings.size() > 0) {
            System.out.println("You have a " + name + " with " + bread + " bread, a " + meat + " patty and topped " +
                    "with " + burgerToppings + ". The total for this burger is " + calcPrice() + ".");
        }
        else {
            System.out.println("You have a " + name + " with " + bread + " bread, a " + meat + " patty and topped " +
                    "with no toppings.  The total for this burger is " + calcPrice() + ".");
        }
    }
}
