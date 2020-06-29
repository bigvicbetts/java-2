package burger_shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Order {

    private ArrayList<Burger> burgers = new ArrayList<Burger>();
    private ArrayList<Meal> meals = new ArrayList<Meal>();
    private ArrayList<String> sides = new ArrayList<String>();
    private ArrayList<String> drinks = new ArrayList<String>();
    private String bread;
    private String meat;
    private String meal;
    private String drink;
    private String[] side;
    private double totalPrice = 0;

    public Order(String burger, String bread, String meat) {

        switch (burger) {
            case "PlainBurger":
                this.burgers.add(new PlainBurger(bread, meat));
                break;
            case "HealthBurger":
                this.burgers.add(new HealthBurger(bread, meat));
                break;
            case "DeluxeBurger":
                this.burgers.add(new DeluxeBurger(bread, meat));
                break;
            default:
                throw new Error("We do not currently have a " + burger + ". Options are PlainBurger, HealthBurger, or DeluxeBurger");
        }

        this.bread = bread;
        this.meat = meat;
    }

    // This will add each item within the Meal class to it's specific variable in this class.
    // That way, the item can be handled as an individual item.  "Meal" is just a concept, not an item.
    // I have not implemented any discounts based on items being grouped in a meal.  Perhaps later...
    public Order(String meal, String bread, String meat, String drink, String... side) {
            this.bread = bread;
            this.meat = meat;
            this.drink = drink;
            this.side = side;
        switch(meal) {
            case "PlainBurger meal":
                this.meals.add(new PlainBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new PlainBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            case "HealthBurger meal":
                this.meals.add(new HealthBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new HealthBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            case "DeluxeBurger meal":
                this.meals.add(new DeluxeBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new DeluxeBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            default:
                throw new Error("We do not currently have a " + meal + ". Options are PlainBurger meal, HealthBurger meal, or DeluxeBurger meal.");
        }
    }

    public void addSides(String... sides) {
        for (String side : sides) {
            if (Side.sideOptions.contains(side)) {
                this.sides.add(side);
                System.out.println("We have added " + side + " to your order.");
            }
            else {
                throw new Error("We do not have " + side + " right now. Your options are " + Side.sideOptions + ".");
            }
        }
    }

    public void addDrink(String drink) {
            if (Drink.DRINK_OPTIONS.contains(drink)) {
                this.drinks.add(drink);
                System.out.println("We have added a " + drink + " to your order.");
            }
            else {
                throw new Error("We do not have " + drink + " right now. Your options are " + Drink.DRINK_OPTIONS + ".");
            }

    }

    public void addBurger(String burger, String bread, String meat) {
        switch (burger) {
            case "PlainBurger":
                this.burgers.add(new PlainBurger(bread, meat));
                break;
            case "HealthBurger":
                this.burgers.add(new HealthBurger(bread, meat));
                break;
            case "DeluxeBurger":
                this.burgers.add(new DeluxeBurger(bread, meat));
                break;
            default:
                throw new Error("We do not currently have a " + burger + ". Options are PlainBurger, HealthBurger, or DeluxeBurger");
        }
    }

    public void addMeal(String meal, String bread, String meat, String drink, String... side) {
        switch(meal) {
            case "PlainBurger meal":
                this.meals.add(new PlainBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new PlainBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            case "HealthBurger meal":
                this.meals.add(new HealthBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new HealthBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            case "DeluxeBurger meal":
                this.meals.add(new DeluxeBurgerMeal(bread, meat, drink, side));
                this.burgers.add(new DeluxeBurger(bread, meat));
                addDrink(drink);
                if (side.length < 4) {
                    addSides(side);
                }
                else {
                    throw new Error("You can only have three sides with this meal.");
                }
                break;
            default:
                throw new Error("We do not currently have a " + meal + ". Options are PlainBurger meal, HealthBurger meal, or DeluxeBurger meal.");
        }
    }

    private int selectBurger(String[] toppings) {
        ArrayList<String> theseToppings = new ArrayList<String>(Arrays.asList(toppings));
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Which burger would you like " + theseToppings + " added to?");
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
        else {  // WARNING!!  Ternary operator below.  Hope it doesn't break my code :-)
                Burger burger = this.burgers.get((burgers.size() == 1 ? 0 : selectBurger(toppings)));
                if (burger.burgerToppings.size() + toppings.length > burger.MAX_TOPPINGS) {
                    System.out.println("You can only put " + burger.MAX_TOPPINGS + " toppings on your " + burger.name + ".");
                }
                else {
                    for (String topping : toppings) {
                        if (!burger.POSSIBLE_TOPPINGS.contains(topping)) {
                            System.out.println("Cannot add " + topping + " to your " + burger.name + ".");
                        }
                        else {
                            if (burger.burgerToppings.contains(topping)) {
                                System.out.println("You have already added " + topping + " to your " + burger.name );
                            }
                            else {
                                burger.burgerToppings.add(topping);
                                System.out.println("We just added " + topping + " to your " + burger.name + ".");
                            }
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
        if (burgers.size() > 0) {
            for (Burger burger : burgers) {
                burger.showBurger();
                totalPrice += burger.calcPrice();
            }
        }
        else {
            System.out.println("You have no burgers for this order.");
        }

        if (sides.size() > 0) {
            double sidePrice = (sides.size() * Side.price);
            totalPrice += sidePrice;
            System.out.println("You also have " + sides + " which, together, total " + sidePrice + ".");
        } else {
            System.out.println("You have no sides for this order.");
        }

        if (drinks.size() > 0) {
            double drinkPrice = (drinks.size() * Drink.PRICE);
            totalPrice += drinkPrice;
            System.out.println("You also have " + drinks + " which, together, total " + (drinks.size() * Drink.PRICE) + ".");
        }
        else {
            System.out.println("You have no drinks for this order.");
        }

        System.out.println("Your total for this order is $" + totalPrice);
    }
}
