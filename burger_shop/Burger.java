package burger_shop;

import java.util.ArrayList;

public class Burger {

    Bread bread;
    Meat meat;
    String[] toppings = {"lettuce", "tomatoes", "onions", "pickles", "cheese", "bacon", "ketchup", "mustard", "mayo"};
    int maxToppings = 2;
    int toppingsAdded = 0;
    ArrayList<String> burgerToppings = new ArrayList<>();
    double plainPrice;
    double perToppingPrice;

    public Burger(Bread bread, Meat meat, int maxToppings, double plainPrice, double perToppingPrice) {
        this.bread = bread;
        this.meat = meat;
        this.maxToppings = maxToppings;
        this.plainPrice = plainPrice;
        this.perToppingPrice = perToppingPrice;
    }

    public String plainBurgerPrice() {
        return "$" + plainPrice;
    }

    public String totalBurgerPrice() {
        double price = plainPrice + (toppingsAdded * perToppingPrice);
        return "$" + price;
    }

    public void addTopping(String topping) {
        if (toppingsAdded < maxToppings) {
            burgerToppings.add(topping);
            System.out.println("Added " + topping + " to your burger.");
            toppingsAdded++;
        }
        else {
            System.out.println("You cannot add any more toppings");
        }
    }

    public void showBurger() {
        System.out.println("Your burger has " + this.bread.bread + " bread and a " +this.meat.meat + " patty with the following toppings: " + this.burgerToppings.toString());
    }
}
