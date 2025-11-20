package designpatterns.creational.factorypattern;

public class GetPlanFactory {

    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        } else if (planType == "DOMESTICPLAN") {
            return new DomesticPlan();
        } else if (planType == "COMMERCIALPLAN") {
            return new CommercialPlan();
        } else if (planType == "INSTITUTIONALPLAN") {
            return new InstitutionalPlan();
        }
        return null;
    }
}
