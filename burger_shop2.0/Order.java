package burger_shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private ArrayList<Burger> burgers = new ArrayList<Burger>();
    private ArrayList<Meal> meals = new ArrayList<Meal>();
    private ArrayList<String> sides = new ArrayList<String>();
    private ArrayList<String> drinks = new ArrayList<String>();
    private double totalPrice = 0;

    public Order(Burger burger) {
        this.burgers.add(burger);
    }

    // This will add each item within the Meal class to it's specific variable in this class.
    // That way, the item can be handled as an individual item.  "Meal" is just a concept, not an item.
    // I have not implemented any discounts based on items being grouped in a meal.  Perhaps later...
    public Order(Meal meal) {
        this.meals.add(meal);
        this.burgers.add(meal.burger);
        this.sides.add(meal.side);
        this.drinks.add(meal.drink);
    }

    public void addSides(String... sides) {
        for (String side : sides) {
            if (Side.sideOptions.contains(side)) {
                this.sides.add(side);
                System.out.println("We have added " + side + " to your order.");
            }
            else {
                System.out.println("We do not have " + side + " right now.");
            }
        }
    }

    public void addDrink(String... drinks) {
        for (String drink : drinks) {
            if (Drink.drinkOptions.contains(drink)) {
                this.drinks.add(drink);
                System.out.println("We have added a " + drink + " to your order.");
            }
            else {
                System.out.println("We do not have " + drink + " right now.");
            }
        }
    }

    public void addBurger(Burger burger) {
        this.burgers.add(burger);
    }

    private int selectBurger(String[] toppings) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Which burger would you like these toppings added to?");
        for (int i = 0; i < burgers.size(); i++) {
            System.out.println((i + 1) + ". " + burgers.get(i).name);
        }
        System.out.print("Enter selection: ");
        choice = scanner.nextInt() - 1;
        return choice;
    }

    public void addToppings(String... toppings) {
        if (this.burgers.isEmpty()) {
            System.out.println("You have nothing to top.");
        }
        else {  // WARNING!!  Ternary operator below.  Hope it doesn't break my codel :-)
                Burger burger = this.burgers.get((burgers.size() == 1 ? 0 : selectBurger(toppings)));
                if (burger.burgerToppings.size() + toppings.length > burger.maxToppings) {
                    System.out.println("You can only put " + burger.maxToppings + " toppings on your " + burger.name + ".");
                }
                else {
                    for (String topping : toppings) {
                        if (!burger.possibleToppings.contains(topping)) {
                            System.out.println("Cannot add " + topping + " to your " + burger.name + ".");
                        }
                        else {
                            burger.burgerToppings.add(topping);
                            System.out.println("We just added " + topping + " to your " + burger.name + ".");
                        }
                    }
                }
            System.out.println("Your " + burger.name + " has the following toppings: " + burger.burgerToppings);
        }
    }

    private double calcBurgerTotal() {
        double burgerTotal = 0;
        for (Burger burger : this.burgers) {
            burgerTotal += burger.calcPrice();
        }
        return burgerTotal;
    }

    public void clearOrder() {
        burgers = new ArrayList<Burger>();
        meals = new ArrayList<Meal>();
        sides = new ArrayList<String>();
        drinks = new ArrayList<String>();
        totalPrice = 0;
    }

    public void purchaseOrder() {
        int burgerQty = burgers.size();
        double burgerTotal = calcBurgerTotal();
        int sideQty = sides.size();
        double sideTotal = sideQty * Side.price;
        int drinkQty = drinks.size();
        double drinkTotal = drinkQty * Drink.price;
        totalPrice = burgerTotal + sideTotal + drinkTotal;

        System.out.println("You ordered " + burgerQty + " burgers which total $" + burgerTotal);
        System.out.println("as well as " + sideQty + " sides which totalled $" + sideTotal);
        System.out.println("and " + drinkQty + " drinks which totalled $" + drinkTotal + ".");
        System.out.println("All together, your order costs $" + totalPrice);
        clearOrder();
    }
}
