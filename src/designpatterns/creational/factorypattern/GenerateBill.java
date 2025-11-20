package designpatterns.creational.factorypattern;

public class GenerateBill {
    public static void main(String[] args) {
        GetPlanFactory planFactory = new GetPlanFactory();
        String plan = "COMMERCIALPLAN";
       Plan pl=  planFactory.getPlan(plan);
       pl.getRate();
       pl.calculateBill(10);
    }
}
