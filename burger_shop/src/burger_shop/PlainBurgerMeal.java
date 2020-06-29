package burger_shop;

class PlainBurgerMeal extends Meal {

    String bread;
    String meat;
    String drink;
    String[] sides;

    PlainBurgerMeal(String bread, String meat, String drink, String... sides) {
        super("PlainBurger meal", new PlainBurger(bread, meat), drink, sides);
        this.bread = bread;
        this.meat = meat;
        this.drink = drink;
        this.sides = sides;
    }
}
