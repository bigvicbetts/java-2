import burger_shop.Order;

public class Main {
    public static void main(String[] args) {
        //main execution of the burger shop goes here.  This is the "entry point" of your application

        Order myOrder = new Order("PlainBurger meal", "white", "beef", "Coke", "fries", "apple pie", "onion rings");
        myOrder.purchaseOrder();
        Order myOrder2 = new Order("HealthBurger", "white", "beef");
        myOrder2.addMeal("DeluxeBurger meal", "rye", "turkey", "Coke", "fries", "apple pie", "apple slices");
        myOrder2.addToppings("onions", "lettuce", "pickles", "onions");
        myOrder2.addToppings("bacon", "cheese");
        myOrder2.addSides("fries", "onion rings");
        myOrder2.purchaseOrder();
    }
}
