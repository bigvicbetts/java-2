package burger_shop;

public class Main {
    public static void main(String[] args) {
        //main execution of the burger shop goes here.  This is the "entry point" of your application

        PlainBurger burger = new PlainBurger(new Bread(), new Meat());
        System.out.println(burger.totalBurgerPrice());
        burger.addTopping("cheese");
        burger.addTopping("pickles");
        burger.addTopping("cheese");
        System.out.println(burger.totalBurgerPrice());
        burger.showBurger();
    }
}
