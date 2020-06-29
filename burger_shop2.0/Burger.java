package burger_shop;

import java.util.ArrayList;

abstract class Burger {
    String bread;
    String meat;
    String name;
    ArrayList<String> possibleToppings;
    ArrayList<String> burgerToppings;
    int maxToppings;
    double plainPrice;
    double perToppingPrice;

    public Burger(String name, String bread, String meat, ArrayList<String> toppings, ArrayList<String> burgerToppings, int maxToppings,
                  double plainPrice, double perToppingPrice) {

        this.name = name;
        if (Bread.breadTypes.contains(bread)) {
            this.bread = bread;
        }
        else {
            System.out.println("We don't have any " + bread + " bread.");
        }
        if (Meat.meatTypes.contains(meat)) {
            this.meat = meat;
        }
        else {
            System.out.println("We don't have any " + meat + ".");
        }
        this.possibleToppings = toppings;
        this.burgerToppings = burgerToppings;
        this.maxToppings = maxToppings;
        this.plainPrice = plainPrice;
        this.perToppingPrice = perToppingPrice;
    }

    public double getPlainPrice() {
        return this.plainPrice;
    }

    public double getPerToppingPrice() {
        return this.perToppingPrice;
    }

    public double calcPrice() {
        return this.plainPrice + (this.perToppingPrice * this.burgerToppings.size());
    }
}
