package burger_shop;

public class Meal {

    Burger burger;
    String side;
    String drink;
    String bread;
    String meat;

    public Meal(String bread, String meat, String drink) {
        this.bread = bread;
        this.meat = meat;
        this.burger = new PlainBurger(bread, meat);
        this.side = Side.sideOptions.get(1);
        this.drink = drink;
    }

    public double calcPrice() {
        return this.burger.calcPrice() + Side.price + Drink.price;
    }
}
