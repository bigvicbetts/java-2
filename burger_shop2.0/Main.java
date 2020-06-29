package burger_shop;

public class Main {
    public static void main(String[] args) {
        //main execution of the burger shop goes here.  This is the "entry point" of your application

        burger_shop.Order myOrder = new burger_shop.Order(new burger_shop.Meal("white", "beef", "Diet Coke"));
        myOrder.addBurger(new burger_shop.DeluxeBurger("wheat", "turkey"));
        myOrder.addToppings("pickles", "cheese");
        myOrder.addToppings("bacon", "lettuce");
        myOrder.addSides("fries", "apple slices");
        myOrder.addDrink("water", "milk");
        myOrder.purchaseOrder();


    }
}
