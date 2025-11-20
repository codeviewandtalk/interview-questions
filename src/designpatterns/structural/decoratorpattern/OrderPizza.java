package designpatterns.structural.decoratorpattern;

public class OrderPizza {
    public static void main(String[] args) {
        BasePizza basePizza = new Margherita();
        System.out.println( "Base Pizza= " + basePizza.cost());

        ToppingDecorator cheesePizza = new ExtraCheese(basePizza);
        System.out.println("Cheese Pizza= " + cheesePizza.cost());

        ToppingDecorator  mushroom= new Mushroom(basePizza);
        System.out.println( "Mushroom Pizza= " + mushroom.cost());

        ToppingDecorator mushroomCheesePizza = new Mushroom(cheesePizza);
        System.out.println( "Mushroom Cheese Pizza= " + mushroomCheesePizza.cost());

    }
}
