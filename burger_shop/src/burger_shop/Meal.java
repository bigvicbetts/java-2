package burger_shop;

import java.util.ArrayList;
import java.util.Arrays;

abstract class Meal {

    Burger burger;
    String name;
    String side;
    String drink;
    ArrayList<String> sides;

    Meal(String name, Burger burger, String drink, String... sides) {
        this.name = name;
        this.burger = burger;
        this.drink = drink;
        this.sides = new ArrayList<String>(Arrays.asList(sides));
    }

    double calcPrice() {
        return this.burger.calcPrice() + Side.price + Drink.PRICE;
    }
}
