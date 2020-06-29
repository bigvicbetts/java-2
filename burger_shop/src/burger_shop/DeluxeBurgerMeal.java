package burger_shop;

class DeluxeBurgerMeal extends Meal {

    String bread;
    String meat;
    String drink;
    String[] sides;

    DeluxeBurgerMeal(String bread, String meat, String drink, String... sides) {
        super("DeluxeBurger meal", new DeluxeBurger(bread, meat), drink, sides);
        this.bread = bread;
        this.meat = meat;
        this.drink = drink;
        this.sides = sides;
    }
}