package burger_shop;

class HealthBurgerMeal extends Meal {

    String bread;
    String meat;
    String drink;
    String[] sides;

    HealthBurgerMeal(String bread, String meat, String drink, String... sides) {
        super("HealthBurger meal", new HealthBurger(bread, meat), drink, sides);
        this.bread = bread;
        this.meat = meat;
        this.drink = drink;
        this.sides = sides;
    }
}